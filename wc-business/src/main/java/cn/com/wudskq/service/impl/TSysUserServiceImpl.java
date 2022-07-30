package cn.com.wudskq.service.impl;

import cn.com.wudskq.expection.BusinessException;
import cn.com.wudskq.expection.GlobalExceptionHandler;
import cn.com.wudskq.mapper.TSysUserMapper;
import cn.com.wudskq.mapper.TSysUserRoleMapper;
import cn.com.wudskq.model.SysUserDetails;
import cn.com.wudskq.model.TSysUser;
import cn.com.wudskq.model.TSysUserRole;
import cn.com.wudskq.model.query.UserInfoQueryDTO;
import cn.com.wudskq.service.TSysUserService;
import cn.com.wudskq.snowflake.IdGeneratorSnowflake;
import cn.com.wudskq.utils.JWTTokenUtil;
import cn.com.wudskq.utils.Md5Util;
import cn.com.wudskq.vo.Response;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wudskq
 */
@Service
public class TSysUserServiceImpl implements TSysUserService {

    @Resource
    private TSysUserMapper tSysUserMapper;

    @Resource
    private TSysUserRoleMapper tSysUserRoleMapper;

    @Resource
    private IdGeneratorSnowflake idGeneratorSnowflake;

    @Autowired
    private GlobalExceptionHandler globalExceptionHandler;

    @Override
    public TSysUser findByUsername(String username) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name",username);
        queryWrapper.eq("status",0);
        return tSysUserMapper.selectOne(queryWrapper);
    }


    @Override
    public String getTenantCodeByUserId(Long id) {
        List<String> tenantCodeList = tSysUserMapper.getTenantCodeByUserId(id);
        String res = tenantCodeList.stream().map(String::valueOf).collect(Collectors.joining(","));
        return res;
    }

    @Override
    public List<TSysUser> getUserInfoList(UserInfoQueryDTO userInfoQuery) {
        //获取当前操作用户系统租户代码权限
        String tenantCode = JWTTokenUtil.getCurrentLoginUserTenantCode();
        PageHelper.startPage(userInfoQuery.getPageNum(),userInfoQuery.getPageSize());
        return tSysUserMapper.getUserInfoList(userInfoQuery,tenantCode);
    }

    @Override
    public TSysUser getUserDetail(Long id) {
        TSysUser userDetail = tSysUserMapper.getUserDetail(id);
        
        //查询用户关联的角色ID
        QueryWrapper<TSysUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",id);
        TSysUserRole tSysUserRole = tSysUserRoleMapper.selectOne(queryWrapper);
        if(null != tSysUserRole && null != tSysUserRole.getRoleId()){
            userDetail.setRoleId(tSysUserRole.getRoleId());
        }
        return userDetail;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Response saveUser(TSysUser sysUser){
            //查询账号是否重复
            QueryWrapper<TSysUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_name",sysUser.getUserName());
            TSysUser tSysUser = tSysUserMapper.selectOne(queryWrapper);
            if(null != tSysUser)
            {
               if(sysUser.getUserName().equals(tSysUser.getUserName())) {
                   Response response = globalExceptionHandler.handleBusinessException(new BusinessException(500, "当前添加的账号已存在,请勿重复添加!"));
                   return response;
               }
            }else {
                //获取当前操作用户
                SysUserDetails currentLoginUser = JWTTokenUtil.getCurrentLoginUser();
                String AncestorId = currentLoginUser.getId()+",";
                if(null != currentLoginUser.getAncestorId() && !"".equals(currentLoginUser.getAncestorId())){
                    AncestorId = AncestorId + currentLoginUser.getAncestorId();
                }
                sysUser.setAncestorId(AncestorId);
                //新增用户
                sysUser.setPassWord(Md5Util.MD5(sysUser.getPassWord()));
                tSysUserMapper.insert(sysUser);

                //新增用户与角色关联关系
                TSysUserRole tSysUserRole = new TSysUserRole();
                tSysUserRole.setUserId(sysUser.getId()).setRoleId(sysUser.getRoleId());
                tSysUserRoleMapper.insert(tSysUserRole);
            }
       return null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Response updateUser(TSysUser sysUser) {
        //特殊情况(admin账号只有admin可以更改)
        SysUserDetails currentLoginUser = JWTTokenUtil.getCurrentLoginUser();
        //如果更新的账号为admin
        if("admin".equals(sysUser.getUserName()))
        {
            if(!"admin".equals(currentLoginUser.getUsername()))
            {
                Response response = globalExceptionHandler.handleBusinessException(new BusinessException(500,"您无权修改admin账号"));
                return response;
            }
        }
        //判断更新密码是否与原密码相同
        TSysUser datasourceUser = tSysUserMapper.selectById(sysUser.getId());
        if(datasourceUser.getPassWord().equals(sysUser.getPassWord()))
        {
            sysUser.setPassWord(datasourceUser.getPassWord());
        }else {
            String currentPasswd = Md5Util.MD5(sysUser.getPassWord());
            sysUser.setPassWord(currentPasswd);
        }
        tSysUserMapper.updateById(sysUser);

        //更新用户与角色关联关系
        TSysUserRole tSysUserRole = new TSysUserRole();
        tSysUserRole.setUserId(sysUser.getId()).setRoleId(sysUser.getRoleId());
        QueryWrapper<TSysUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",sysUser.getId());

        //有的更新无则新增
        Integer relationCount = tSysUserRoleMapper.selectCount(queryWrapper);
        if(null != relationCount && 1 == relationCount)
        {
            tSysUserRoleMapper.update(tSysUserRole,queryWrapper);
        }else {
            tSysUserRoleMapper.insert(tSysUserRole);
        }
        return null;
    }

    @Override
    public void removeUser(List<String> ids) {
        tSysUserMapper.removeUser(ids);
    }
}

