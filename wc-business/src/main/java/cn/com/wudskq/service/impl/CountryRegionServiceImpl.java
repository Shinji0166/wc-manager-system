package cn.com.wudskq.service.impl;

import cn.com.wudskq.mapper.CountryRegionMapper;
import cn.com.wudskq.model.CountryRegion;
import cn.com.wudskq.model.query.RegionQueryDTO;
import cn.com.wudskq.service.CountryRegionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenfangchao
 * @title: CountryRegionServiceImpl
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/27 8:07 PM
 */
@Service
public class CountryRegionServiceImpl implements CountryRegionService {

    @Autowired
    private CountryRegionMapper countryRegionMapper;

    @Override
    public List<CountryRegion> getRegionList(RegionQueryDTO regionQuery) {
        PageHelper.startPage(regionQuery.getPageNum(),regionQuery.getPageSize());
        return countryRegionMapper.getRegionList(regionQuery);
    }

    @Override
    public CountryRegion getRegionDetail(Long id) {
        return countryRegionMapper.getRegionDetail(id);
    }

    @Override
    public void saveRegion(CountryRegion countryRegion) {
        countryRegionMapper.insert(countryRegion);
    }

    @Override
    public void updateRegion(CountryRegion countryRegion) {
        countryRegionMapper.updateById(countryRegion);
    }

    @Override
    public void removeRegion(List<Long> ids) {
        countryRegionMapper.removeRegion(ids);
    }
}
