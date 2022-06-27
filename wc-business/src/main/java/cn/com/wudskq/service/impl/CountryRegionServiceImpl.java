package cn.com.wudskq.service.impl;

import cn.com.wudskq.annotation.DataSource;
import cn.com.wudskq.enums.DataSourceType;
import cn.com.wudskq.mapper.CountryRegionMapper;
import cn.com.wudskq.model.CountryRegion;
import cn.com.wudskq.model.query.RegionQueryDTO;
import cn.com.wudskq.service.CountryRegionService;
import cn.com.wudskq.snowflake.IdGeneratorSnowflake;
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

    @Autowired
    private IdGeneratorSnowflake idGeneratorSnowflake;

    @Override
    @DataSource(DataSourceType.MASTER)
    public List<CountryRegion> getRegionList(RegionQueryDTO regionQuery) {
        PageHelper.startPage(regionQuery.getPageNum(),regionQuery.getPageSize());
        return countryRegionMapper.getRegionList(regionQuery);
    }


    @Override
    @DataSource(DataSourceType.MASTER)
    public CountryRegion getRegionDetail(Long id) {
        return countryRegionMapper.getRegionDetail(id);
    }


    @Override
    @DataSource(DataSourceType.SLAVE)
    public void saveRegion(CountryRegion countryRegion) {
        countryRegion.setId(idGeneratorSnowflake.snowflakeId());
        countryRegion.setStatus(0);
        countryRegionMapper.insert(countryRegion);
    }

    @Override
    @DataSource(DataSourceType.SLAVE)
    public void updateRegion(CountryRegion countryRegion) {
        countryRegionMapper.updateById(countryRegion);
    }

    @Override
    @DataSource(DataSourceType.SLAVE)
    public void removeRegion(List<Long> ids) {
        countryRegionMapper.removeRegion(ids);
    }
}
