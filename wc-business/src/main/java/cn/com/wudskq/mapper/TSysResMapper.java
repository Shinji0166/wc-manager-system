package cn.com.wudskq.mapper;
 

import cn.com.wudskq.model.TSysRes;
import cn.com.wudskq.model.query.ResInfoQueryDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wudskq
 */
public interface TSysResMapper extends BaseMapper<TSysRes> {


    /**
     * 获取资源/菜单信息列表
     * @param resInfoQuery
     * @return
     */
    List<TSysRes> getResLIst(@Param("query") ResInfoQueryDTO resInfoQuery);

    /**
     * 获取资源/菜单详细信息
     * @param id
     * @return
     */
    TSysRes getResDetail(@Param("id") Long id);

    /**
     * 删除资源/菜单详细信息(逻辑删除)
     * @param ids
     */
    void removeRes(@Param("ids") List<Long> ids);
}

