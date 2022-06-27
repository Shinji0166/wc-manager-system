package cn.com.wudskq.controller;

import cn.com.wudskq.model.CountryRegion;
import cn.com.wudskq.model.query.RegionQueryDTO;
import cn.com.wudskq.service.CountryRegionService;
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
 * @title: RegionController
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/27 7:58 PM
 */
@Api("地区管理")
@RestController
@RequestMapping("/system")
public class RegionController {

    @Autowired
    private CountryRegionService countryRegionService;

    @ApiOperation("获取地区信息列表")
    @PostMapping("/region/list")
    public Response getRegionList(@RequestBody(required = false) RegionQueryDTO regionQuery){
        List<CountryRegion> regionList = countryRegionService.getRegionList(regionQuery);
        if(null != regionList && 0 < regionList.size()){
            PageInfo<CountryRegion> pageInfo = new PageInfo<CountryRegion>(regionList);
            return Response.success(Collections.singletonList(pageInfo.getList()),pageInfo.getTotal());
        }
        return Response.success();
    }


    @ApiOperation("获取地区详细信息")
    @GetMapping("/region/detail")
    public Response getRegionDetail(@RequestParam("id")Long id){
        CountryRegion regionDetail = countryRegionService.getRegionDetail(id);
        return Response.success(regionDetail);
    }

    @ApiOperation("新增地区信息")
    @PostMapping("/save/region")
    public Response saveRegion(@RequestBody CountryRegion countryRegion){
        countryRegionService.saveRegion(countryRegion);
        return Response.success();
    }

    @ApiOperation("更新地区信息")
    @PutMapping("/update/region")
    public Response updateRegion(@RequestBody CountryRegion countryRegion){
        countryRegionService.updateRegion(countryRegion);
        return Response.success();
    }

    @ApiOperation("删除地区信息(逻辑删除)")
    @DeleteMapping("/remove/region")
    public Response removeRegion(@RequestParam("ids")List<Long> ids){
        countryRegionService.removeRegion(ids);
        return Response.success();
    }

}
