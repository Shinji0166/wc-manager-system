package cn.com.wudskq.mapper;


import cn.com.wudskq.model.TSysRole;
import cn.com.wudskq.model.query.RoleInfoQueryDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.parameters.P;

import java.util.List;


/**
 * @author wudskq
 */
public interface TSysRoleMapper extends BaseMapper<TSysRole> {

    @Select("SELECT r.* FROM  sys_role r " +
            "LEFT JOIN sys_user_role ur ON ur.role_id = r.id " +
            "WHERE " +
            "ur.user_id = #{userId} ")
    List<TSysRole> findRoleByUserId(String userId);

    /**
     * 获取角色信息列表
     * @param roleInfoQuery
     * @return
     */
    List<TSysRole> getRoleInfoList(@Param("query") RoleInfoQueryDTO roleInfoQuery);

    /**
     * 获取角色详细信息
     * @param id
     * @return
     */
    TSysRole getRoleDetail(@Param("id") Long id);

    /**
     * 删除角色信息(逻辑删除)
     * @param ids
     */
    void removeRole(@Param("ids") List<Long> ids);
}


