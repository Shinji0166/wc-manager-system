package cn.com.wudskq.service.impl;

import cn.com.wudskq.mapper.TSysRoleMapper;
import cn.com.wudskq.mapper.TSysRoleResMapper;
import cn.com.wudskq.model.TSysRole;
import cn.com.wudskq.model.TSysRoleRes;
import cn.com.wudskq.model.query.RoleInfoQueryDTO;
import cn.com.wudskq.model.vo.SysRoleSelectVo;
import cn.com.wudskq.service.TSysRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wudskq
 */
@Service
public class TSysRoleServiceImpl implements TSysRoleService {

    @Autowired
    private TSysRoleMapper sysRoleMapper;

    @Autowired
    private TSysRoleResMapper sysRoleResMapper;


    @Override
    public List<SysRoleSelectVo> getRoleSelect(RoleInfoQueryDTO roleInfoQuery) {
        return sysRoleMapper.getRoleSelect(roleInfoQuery);
    }

    @Override
    public List<TSysRole> getRoleInfoList(RoleInfoQueryDTO roleInfoQuery) {
        PageHelper.startPage(roleInfoQuery.getPageNum(),roleInfoQuery.getPageSize());
        return sysRoleMapper.getRoleInfoList(roleInfoQuery);
    }

    @Override
    public TSysRole getRoleDetail(Long id) {
        //根据角色ID查询菜单权限列表
        QueryWrapper<TSysRoleRes> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id",id);
        List<TSysRoleRes> sysRoleResList = sysRoleResMapper.selectList(queryWrapper);
        List<String> resList = new ArrayList<>();
        for (TSysRoleRes tSysRoleRes : sysRoleResList) {
            Long resId = tSysRoleRes.getResId();
            resList.add(String.valueOf(resId));
        }

        //set数据
        TSysRole roleDetail = sysRoleMapper.getRoleDetail(id);
        roleDetail.setMenuAuthList(resList);
        return roleDetail;
    }


    @Override
    public void saveRole(TSysRole sysRole) {
        sysRoleMapper.insert(sysRole);
        //新增角色菜单权限关联
        sysRole.getMenuAuthList().forEach(value->{
            TSysRoleRes sysRoleRes = new TSysRoleRes().setRoleId(sysRole.getId()).setResId(Long.valueOf(value));
            sysRoleResMapper.insert(sysRoleRes);
        });
    }

    @Override
    public void updateRole(TSysRole sysRole) {
        sysRoleMapper.updateById(sysRole);
        //先删除后新增
        QueryWrapper<TSysRoleRes> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id",sysRole.getId());
        sysRoleResMapper.delete(queryWrapper);

        //更新角色菜单权限关联
        sysRole.getMenuAuthList().forEach(value->{
            TSysRoleRes sysRoleRes = new TSysRoleRes().setRoleId(sysRole.getId()).setResId(Long.valueOf(value));
            sysRoleResMapper.insert(sysRoleRes);
        });
    }

    @Override
    public void removeRole(List<Long> ids) {
        sysRoleMapper.removeRole(ids);
    }

}

