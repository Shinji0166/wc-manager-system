package cn.com.wudskq.mapper;

import cn.com.wudskq.model.TSysRole;
import cn.com.wudskq.model.TSysRoleRes;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wudskq
 */
public interface TSysRoleResMapper extends BaseMapper<TSysRoleRes> {


    /**
     * 根据角色查询资源
     * @param roleList
     * @return
     */
    List<String> selectRoleResByRoleIds(@Param("roleList") List<TSysRole> roleList);
}

