package cn.com.wudskq.service;

import cn.com.wudskq.model.TSysRole;
import cn.com.wudskq.model.query.RoleInfoQueryDTO;

import java.util.List;

/**
 * @author wudskq
 */
public interface TSysRoleService {

    /**
     * 获取角色信息列表
     * @param roleInfoQuery
     * @return
     */
    List<TSysRole> getRoleInfoList(RoleInfoQueryDTO roleInfoQuery);

    /**
     * 获取角色详细信息
     * @param id
     * @return
     */
    TSysRole getRoleDetail(Long id);

    /**
     * 新增角色信息
     * @param sysRole
     */
    void saveRole(TSysRole sysRole);

    /**
     * 更新用户信息
     * @param sysRole
     */
    void updateRole(TSysRole sysRole);

    /**
     * 删除角色信息(逻辑删除)
     * @param ids
     */
    void removeRole(List<Long> ids);
}

