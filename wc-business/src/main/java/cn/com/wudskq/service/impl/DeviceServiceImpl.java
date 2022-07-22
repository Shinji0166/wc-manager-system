package cn.com.wudskq.service.impl;

import cn.com.wudskq.mapper.DeviceMapper;
import cn.com.wudskq.model.Device;
import cn.com.wudskq.model.query.DeviceQueryDTO;
import cn.com.wudskq.service.DeviceService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<Device> getDeviceList(DeviceQueryDTO deviceQuery) {
        PageHelper.startPage(deviceQuery.getPageNum(),deviceQuery.getPageSize());
        return deviceMapper.getDeviceList(deviceQuery);
    }

    @Override
    public Device getDeviceDetail(Long id) {
        return deviceMapper.getDeviceDetail(id);
    }

    @Override
    public void saveDevice(Device deviceInfo) {
        deviceMapper.insert(deviceInfo);
    }

    @Override
    public void updateDevice(Device deviceInfo) {
        deviceMapper.updateById(deviceInfo);
    }

    @Override
    public void removeDevice(List<Long> ids) {
        deviceMapper.removeDevice(ids);
    }
}
