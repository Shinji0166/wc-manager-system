package cn.com.wudskq.service.impl;

import cn.com.wudskq.mapper.TSysUserMapper;
import cn.com.wudskq.mapper.TSysUserRoleMapper;
import cn.com.wudskq.model.TSysUser;
import cn.com.wudskq.model.TSysUserRole;
import cn.com.wudskq.model.query.UserInfoQueryDTO;
import cn.com.wudskq.service.TSysUserService;
import cn.com.wudskq.snowflake.IdGeneratorSnowflake;
import cn.com.wudskq.utils.Md5Util;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public TSysUser findByUsername(String username) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name",username);
        queryWrapper.eq("status",0);
        return tSysUserMapper.selectOne(queryWrapper);
    }

    @Override
    public List<TSysUser> getUserInfoList(UserInfoQueryDTO userInfoQuery) {
        PageHelper.startPage(userInfoQuery.getPageNum(),userInfoQuery.getPageSize());
        return tSysUserMapper.getUserInfoList(userInfoQuery);
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

    @Override
    public void saveUser(TSysUser sysUser) {
        //新增用户
        sysUser.setPassWord(Md5Util.MD5(sysUser.getPassWord()));
        tSysUserMapper.insert(sysUser);
        //新增用户与角色关联关系
        TSysUserRole tSysUserRole = new TSysUserRole();
        tSysUserRole.setUserId(sysUser.getId()).setRoleId(sysUser.getRoleId());
        tSysUserRoleMapper.insert(tSysUserRole);
    }

    @Override
    public void updateUser(TSysUser sysUser) {
        //判断更新密码是否与原密码相同
        TSysUser datasourceUser = tSysUserMapper.selectById(sysUser.getId());
        if(datasourceUser.getPassWord().equals(sysUser.getPassWord())){
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
        if(null != relationCount && 1 == relationCount){
            tSysUserRoleMapper.update(tSysUserRole,queryWrapper);
        }else {
            tSysUserRoleMapper.insert(tSysUserRole);
        }

    }

    @Override
    public void removeUser(List<String> ids) {
        tSysUserMapper.removeUser(ids);
    }
}

