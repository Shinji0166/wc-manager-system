package cn.com.wudskq.service.impl;

import cn.com.wudskq.annotation.DataSource;
import cn.com.wudskq.enums.DataSourceType;
import cn.com.wudskq.mapper.DeviceMapper;
import cn.com.wudskq.model.Device;
import cn.com.wudskq.model.query.DeviceQueryDTO;
import cn.com.wudskq.service.DeviceService;
import cn.com.wudskq.snowflake.IdGeneratorSnowflake;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenfangchao
 * @title: DeviceServiceImpl
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/28 3:07 PM
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Resource
    private IdGeneratorSnowflake idGeneratorSnowflake;

    @Override
//    @DataSource(DataSourceType.MASTER)
    public List<Device> getDeviceList(DeviceQueryDTO deviceQuery) {
        PageHelper.startPage(deviceQuery.getPageNum(),deviceQuery.getPageSize());
        return deviceMapper.getDeviceList(deviceQuery);
    }

    @Override
//    @DataSource(DataSourceType.MASTER)
    public Device getDeviceDetail(Long id) {
        return deviceMapper.getDeviceDetail(id);
    }

    @Override
//    @DataSource(DataSourceType.SLAVE)
    public void saveDevice(Device deviceInfo) {
        //新增状态为正常
        deviceInfo.setStatus(0);
        deviceInfo.setId(idGeneratorSnowflake.snowflakeId());
        deviceMapper.insert(deviceInfo);
    }

    @Override
//    @DataSource(DataSourceType.SLAVE)
    public void updateDevice(Device deviceInfo) {
        deviceMapper.updateById(deviceInfo);
    }

    @Override
//    @DataSource(DataSourceType.SLAVE)
    public void removeDevice(List<Long> ids) {
        deviceMapper.removeDevice(ids);
    }
}
