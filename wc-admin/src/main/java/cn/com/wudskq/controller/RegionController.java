package cn.com.wudskq.controller;

import cn.com.wudskq.annotation.InterfaceCall;
import cn.com.wudskq.annotation.OperatorLog;
import cn.com.wudskq.model.CountryRegion;
import cn.com.wudskq.model.query.RegionQueryDTO;
import cn.com.wudskq.service.CountryRegionService;
import cn.com.wudskq.vo.Response;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * @author chenfangchao
 * @title: RegionController
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/27 7:58 PM
 */
@Api(tags = "地区管理")
@RestController
@RequestMapping("/system")
public class RegionController {

    @Autowired
    private CountryRegionService countryRegionService;

    @ApiOperation(value = "获取地区信息列表")
    @PreAuthorize(value = "hasPermission('/system/region/list','res_system:region:query')")
    @InterfaceCall(interfaceName = "获取地区信息列表",requestMode = "POST")
    @OperatorLog(module = "地区管理", function = "地区信息", action = "获取地区信息列表", requestMode = "POST")
    @PostMapping("/region/list")
    public Response getRegionList(@RequestBody(required = false) RegionQueryDTO regionQuery) {
        List<CountryRegion> regionList = countryRegionService.getRegionList(regionQuery);
        if (null != regionList && 0 < regionList.size()) {
            PageInfo<CountryRegion> pageInfo = new PageInfo<CountryRegion>(regionList);
            return Response.success(Collections.singletonList(pageInfo.getList()), pageInfo.getTotal());
        }
        return Response.success();
    }


    @ApiOperation(value = "获取地区详细信息")
    @PreAuthorize(value = "hasPermission('/system/region/detail','res_system:region:query')")
    @InterfaceCall(interfaceName = "获取地区详细信息",requestMode = "GET")
    @OperatorLog(module = "地区管理", function = "地区信息", action = "获取地区详细信息", requestMode = "GET")
    @GetMapping("/region/detail")
    public Response getRegionDetail(@RequestParam("id") Long id) {
        CountryRegion regionDetail = countryRegionService.getRegionDetail(id);
        return Response.success(regionDetail);
    }

    @ApiOperation(value = "新增地区信息")
    @PreAuthorize(value = "hasPermission('/system/save/region','res_system:region:add')")
    @InterfaceCall(interfaceName = "新增地区信息",requestMode = "POST")
    @OperatorLog(module = "地区管理", function = "地区信息", action = "新增地区信息", requestMode = "POST")
    @PostMapping("/save/region")
    public Response saveRegion(@RequestBody CountryRegion countryRegion) {
        countryRegionService.saveRegion(countryRegion);
        return Response.success();
    }

    @ApiOperation(value = "更新地区信息")
    @PreAuthorize(value = "hasPermission('/system/update/region','res_system:region:edit')")
    @InterfaceCall(interfaceName = "更新地区信息",requestMode = "PUT")
    @OperatorLog(module = "地区管理", function = "地区信息", action = "更新地区信息", requestMode = "PUT")
    @PutMapping("/update/region")
    public Response updateRegion(@RequestBody CountryRegion countryRegion) {
        countryRegionService.updateRegion(countryRegion);
        return Response.success();
    }

    @ApiOperation(value = "删除地区信息(逻辑删除)")
    @PreAuthorize(value = "hasPermission('/system/remove/region','res_system:region:delete')")
    @InterfaceCall(interfaceName = "删除地区信息",requestMode = "DELETE")
    @OperatorLog(module = "地区管理", function = "地区信息", action = "删除地区信息", requestMode = "DELETE")
    @DeleteMapping("/remove/region")
    public Response removeRegion(@RequestParam("ids") List<Long> ids) {
        countryRegionService.removeRegion(ids);
        return Response.success();
    }

}
