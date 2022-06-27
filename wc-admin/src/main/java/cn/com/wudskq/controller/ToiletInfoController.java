package cn.com.wudskq.controller;


import cn.com.wudskq.model.ToiletInfo;
import cn.com.wudskq.model.query.ToiletInfoQueryDTO;
import cn.com.wudskq.service.ToiletInfoService;
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
 * @title: ToiletInfoController
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/28 2:59 AM
 */
@Api("公厕管理")
@RestController
@RequestMapping("/system")
public class ToiletInfoController {

    @Autowired
    private ToiletInfoService toiletInfoService;

    @ApiOperation(value = "获取公厕信息列表")
    @PostMapping("/toilet/list")
    public Response getToiletList(@RequestBody(required = false) ToiletInfoQueryDTO toiletInfoQuery){
        List<ToiletInfo> toiletList = toiletInfoService.getToiletList(toiletInfoQuery);
        if(null != toiletList && 0 < toiletList.size()){
            PageInfo<ToiletInfo> pageInfo = new PageInfo<ToiletInfo>(toiletList);
            return Response.success(Collections.singletonList(pageInfo.getList()),pageInfo.getTotal());
        }
        return Response.success();
    }


    @ApiOperation(value = "获取公厕详细信息")
    @GetMapping("/toilet/detail")
    public Response getToiletDetail(@RequestParam("id")Long id){
        ToiletInfo toiletDetail = toiletInfoService.getToiletDetail(id);
        return Response.success(toiletDetail);
    }

    @ApiOperation(value = "新增公厕信息")
    @PostMapping("/save/toilet")
    public Response saveToilet(@RequestBody ToiletInfo toiletInfo){
        toiletInfoService.saveToilet(toiletInfo);
        return Response.success();
    }

    @ApiOperation("更新公厕信息")
    @PutMapping("/update/toilet")
    public Response updateToilet(@RequestBody ToiletInfo toiletInfo){
        toiletInfoService.updateToilet(toiletInfo);
        return Response.success();
    }

    @ApiOperation("删除公厕信息(逻辑删除)")
    @DeleteMapping("/remove/toilet")
    public Response removeToilet(@RequestParam("ids")List<Long> ids){
        toiletInfoService.removeToilet(ids);
        return Response.success();
    }

}
