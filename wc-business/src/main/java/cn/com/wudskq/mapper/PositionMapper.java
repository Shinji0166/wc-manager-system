package cn.com.wudskq.mapper;

import cn.com.wudskq.annotation.TenantInterceptor;
import cn.com.wudskq.model.Position;
import cn.com.wudskq.model.query.PositionQueryDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenfangchao
 * @title: PositionMapper
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/28 3:33 AM
 */
public interface PositionMapper extends BaseMapper<Position> {

    /**
     * 获取坑位信息列表
     * @param positionQuery
     * @return
     */
    @TenantInterceptor
    List<Position> getPositionList(@Param("query") PositionQueryDTO positionQuery);

    /**
     * 获取坑位详细信息
     * @param id
     * @return
     */
    Position getPositionDetail(@Param("id") Long id);

    /**
     * 删除坑位信息(逻辑删除)
     * @param ids
     */
    void removePosition(@Param("ids") List<Long> ids);
}
