package cn.com.wudskq.controller;

import cn.com.wudskq.model.Device;
import cn.com.wudskq.model.query.DeviceQueryDTO;
import cn.com.wudskq.service.DeviceService;
import cn.com.wudskq.vo.Response;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * @author chenfangchao
 * @title: DeviceController
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/28 3:06 PM
 */
@Api(tags = "设备管理")
@RestController
@RequestMapping("/system")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;


    @ApiOperation(value = "获取设备信息列表")
    @PostMapping("/device/list")
    public Response getDeviceList(@RequestBody(required = false) DeviceQueryDTO deviceQuery){
        List<Device> deviceList = deviceService.getDeviceList(deviceQuery);
        if(null != deviceList && 0 < deviceList.size()){
            PageInfo<Device> pageInfo = new PageInfo<Device>(deviceList);
            return Response.success(Collections.singletonList(pageInfo.getList()),pageInfo.getTotal());
        }
        return Response.success();
    }


    @ApiOperation(value = "获取设备详细信息")
    @GetMapping("/device/detail")
    public Response getDeviceDetail(@RequestParam("id")Long id){
        Device deviceDetail = deviceService.getDeviceDetail(id);
        return Response.success(deviceDetail);
    }

    @ApiOperation(value = "新增设备信息")
    @PostMapping("/save/device")
    public Response saveDevice(@RequestBody Device deviceInfo){
        deviceService.saveDevice(deviceInfo);
        return Response.success();
    }

    @ApiOperation(value= "更新设备信息")
    @PutMapping("/update/device")
    public Response updateDevice(@RequestBody Device deviceInfo){
        deviceService.updateDevice(deviceInfo);
        return Response.success();
    }

    @ApiOperation(value= "删除设备信息(逻辑删除)")
    @DeleteMapping("/remove/device")
    public Response removeDevice(@RequestParam("ids")List<Long> ids){
        deviceService.removeDevice(ids);
        return Response.success();
    }
}
