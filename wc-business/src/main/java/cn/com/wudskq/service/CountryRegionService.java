package cn.com.wudskq.service;

import cn.com.wudskq.model.CountryRegion;
import cn.com.wudskq.model.query.RegionQueryDTO;

import java.util.List;

/**
 * @author chenfangchao
 * @title: CountryRegionService
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/27 8:06 PM
 */
public interface CountryRegionService {

    /**
     * 获取地区信息列表
     * @param regionQuery
     * @return
     */
    List<CountryRegion> getRegionList(RegionQueryDTO regionQuery);

    /**
     * 获取地区详细信息
     * @param id
     * @return
     */
    CountryRegion getRegionDetail(Long id);

    /**
     * 新增地区信息
     * @param countryRegion
     */
    void saveRegion(CountryRegion countryRegion);

    /**
     * 更新地区信息
     * @param countryRegion
     */
    void updateRegion(CountryRegion countryRegion);

    /**
     * 删除地区信息(逻辑删除)
     * @param ids
     */
    void removeRegion(List<Long> ids);
}
