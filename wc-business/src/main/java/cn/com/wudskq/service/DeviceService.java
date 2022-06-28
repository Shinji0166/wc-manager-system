package cn.com.wudskq.service;

import cn.com.wudskq.model.Device;
import cn.com.wudskq.model.query.DeviceQueryDTO;

import java.util.List;

/**
 * @author chenfangchao
 * @title: DeviceService
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/28 3:07 PM
 */
public interface DeviceService {
    /**
     * 获取设备信息列表
     * @param deviceQuery
     * @return
     */
    List<Device> getDeviceList(DeviceQueryDTO deviceQuery);

    /**
     * 获取设备详情信息
     * @param id
     * @return
     */
    Device getDeviceDetail(Long id);

    /**
     * 保存设备信息
     * @param deviceInfo
     */
    void saveDevice(Device deviceInfo);

    /**
     * 更新设备信息
     * @param deviceInfo
     */
    void updateDevice(Device deviceInfo);

    /**
     * 删除设备信息(逻辑删除)
     * @param ids
     */
    void removeDevice(List<Long> ids);
}
