package cn.com.wudskq.mapper;

import cn.com.wudskq.annotation.TenantInterceptor;
import cn.com.wudskq.model.Device;
import cn.com.wudskq.model.query.DeviceQueryDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenfangchao
 * @title: DeviceMapper
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/28 3:07 PM
 */
public interface DeviceMapper extends BaseMapper<Device>{

    /**
     * 获取设备信息列表
     * @param deviceQuery
     * @return
     */
    @TenantInterceptor
    List<Device> getDeviceList(@Param("query") DeviceQueryDTO deviceQuery);

    /**
     * 获取设备详细信息
     * @param id
     * @return
     */
    Device getDeviceDetail(@Param("id") Long id);

    /**
     * 删除设备信息(逻辑删除)
     * @param ids
     */
    void removeDevice(@Param("ids") List<Long> ids);
}
