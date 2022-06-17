package cn.com.wudskq.mapper;


import cn.com.wudskq.model.TSysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface TSysRoleMapper extends BaseMapper<TSysRole> {

    @Select("SELECT r.* FROM t_sys_role r " +
            "LEFT JOIN t_sys_user_role ur ON ur.role_id = r.id " +
            "WHERE " +
            "ur.user_id = #{userId} ")
    List<TSysRole> findRoleByUserId(String userId);
 
 
}

