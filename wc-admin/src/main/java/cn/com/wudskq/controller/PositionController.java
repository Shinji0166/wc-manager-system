package cn.com.wudskq.controller;

import cn.com.wudskq.annotation.InterfaceCall;
import cn.com.wudskq.annotation.OperatorLog;
import cn.com.wudskq.annotation.ProhibitResubmit;
import cn.com.wudskq.model.Position;
import cn.com.wudskq.model.query.PositionQueryDTO;
import cn.com.wudskq.service.PositionService;
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
 * @title: PositionController
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/28 3:22 AM
 */
@Api(tags = "坑位管理")
@RestController
@RequestMapping("/system")
public class PositionController extends BaseController{

    @Autowired
    private PositionService positionService;

    @ApiOperation(value = "获取坑位信息列表")
    @PreAuthorize(value = "hasPermission('/system/position/list','res_system:position:query')")
    @InterfaceCall(interfaceName = "获取坑位信息列表",requestMode = "POST")
    @OperatorLog(module = "坑位管理", function = "坑位信息", action = "获取坑位信息列表", requestMode = "POST")
    @PostMapping("/position/list")
    public Response getPositionList(@RequestBody(required = false) PositionQueryDTO positionQuery) {
        List<Position> positionList = positionService.getPositionList(positionQuery);
        if (null != positionList && 0 < positionList.size()) {
            PageInfo<Position> pageInfo = new PageInfo<Position>(positionList);
            return Response.success(Collections.singletonList(pageInfo.getList()), pageInfo.getTotal());
        }
        return Response.success();
    }


    @ApiOperation(value = "获取坑位详细信息")
    @PreAuthorize(value = "hasPermission('/system/position/detail','res_system:position:query')")
    @InterfaceCall(interfaceName = "获取坑位详细信息",requestMode = "GET")
    @OperatorLog(module = "坑位管理", function = "坑位信息", action = "获取坑位详细信息", requestMode = "GET")
    @GetMapping("/position/detail")
    public Response getPositionDetail(@RequestParam("id") Long id) {
        Position positionDetail = positionService.getPositionDetail(id);
        return Response.success(positionDetail);
    }

    @ApiOperation(value = "新增坑位信息")
    @ProhibitResubmit
    @PreAuthorize(value = "hasPermission('/system/save/position','res_system:position:add')")
    @InterfaceCall(interfaceName = "新增坑位信息",requestMode = "POST")
    @OperatorLog(module = "坑位管理", function = "坑位信息", action = "新增坑位信息", requestMode = "POST")
    @PostMapping("/save/position")
    public Response savePosition(@RequestBody Position positionInfo) {
        positionService.savePosition(positionInfo);
        return Response.success();
    }

    @ApiOperation(value = "更新坑位信息")
    @ProhibitResubmit
    @PreAuthorize(value = "hasPermission('/system/update/position','res_system:position:edit')")
    @InterfaceCall(interfaceName = "更新坑位信息",requestMode = "PUT")
    @OperatorLog(module = "坑位管理", function = "坑位信息", action = "更新坑位信息", requestMode = "PUT")
    @PutMapping("/update/position")
    public Response updatePosition(@RequestBody Position positionInfo) {
        positionService.updatePosition(positionInfo);
        return Response.success();
    }

    @ApiOperation(value = "删除坑位信息(逻辑删除)")
    @PreAuthorize(value = "hasPermission('/system/remove/position','res_system:position:delete')")
    @InterfaceCall(interfaceName = "删除坑位信息",requestMode = "DELETE")
    @OperatorLog(module = "坑位管理", function = "坑位信息", action = "删除坑位信息", requestMode = "DELETE")
    @DeleteMapping("/remove/position")
    public Response removePosition(@RequestParam("ids") List<Long> ids) {
        positionService.removePosition(ids);
        return Response.success();
    }

}
