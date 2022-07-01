package cn.com.wudskq.service.impl;

import cn.com.wudskq.annotation.DataSource;
import cn.com.wudskq.enums.DataSourceType;
import cn.com.wudskq.mapper.ToiletInfoMapper;
import cn.com.wudskq.model.ToiletInfo;
import cn.com.wudskq.model.query.ToiletInfoQueryDTO;
import cn.com.wudskq.service.ToiletInfoService;
import cn.com.wudskq.snowflake.IdGeneratorSnowflake;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenfangchao
 * @title: ToiletInfoServiceImpl
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/28 2:56 AM
 */
@Service
public class ToiletInfoServiceImpl implements ToiletInfoService {

    @Autowired
    private ToiletInfoMapper toiletInfoMapper;

    @Resource
    private IdGeneratorSnowflake idGeneratorSnowflake;

    @Override
//    @DataSource(DataSourceType.MASTER)
    public List<ToiletInfo> getToiletList(ToiletInfoQueryDTO toiletInfoQuery) {
        PageHelper.startPage(toiletInfoQuery.getPageNum(),toiletInfoQuery.getPageSize());
        return toiletInfoMapper.getToiletList(toiletInfoQuery);
    }

    @Override
//    @DataSource(DataSourceType.MASTER)
    public ToiletInfo getToiletDetail(Long id) {
        return toiletInfoMapper.getToiletDetail(id);
    }

    @Override
//    @DataSource(DataSourceType.SLAVE)
    public void saveToilet(ToiletInfo toiletInfo) {
        toiletInfo.setStatus(0);
        toiletInfo.setId(idGeneratorSnowflake.snowflakeId());
        toiletInfoMapper.insert(toiletInfo);
    }

    @Override
//    @DataSource(DataSourceType.SLAVE)
    public void updateToilet(ToiletInfo toiletInfo) {
        toiletInfoMapper.updateById(toiletInfo);
    }

    @Override
//    @DataSource(DataSourceType.SLAVE)
    public void removeToilet(List<Long> ids) {
        toiletInfoMapper.removeToilet(ids);
    }
}
