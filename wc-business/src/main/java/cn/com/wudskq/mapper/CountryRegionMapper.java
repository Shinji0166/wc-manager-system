package cn.com.wudskq.mapper;

import cn.com.wudskq.model.CountryRegion;
import cn.com.wudskq.model.query.RegionQueryDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author chenfangchao
 * @title: CountryRegionMapper
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/27 8:07 PM
 */
public interface CountryRegionMapper extends BaseMapper<CountryRegion> {

    /**
     * 获取地区信息列表
     * @param regionQuery
     * @return
     */
    List<CountryRegion> getRegionList(@Param("query") RegionQueryDTO regionQuery);

    /**
     * 获取地区详细信息
     * @param id
     * @return
     */
    CountryRegion getRegionDetail(@Param("id") Long id);

    /**
     * 删除地区信息(逻辑删除)
     * @param ids
     */
    void removeRegion(@Param("ids") List<Long> ids);
}
