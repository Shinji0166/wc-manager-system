package cn.com.wudskq.controller;

import cn.com.wudskq.annotation.InterfaceCall;
import cn.com.wudskq.annotation.OperatorLog;
import cn.com.wudskq.model.TSysRes;
import cn.com.wudskq.model.query.ResInfoQueryDTO;
import cn.com.wudskq.model.vo.TreeSelectVo;
import cn.com.wudskq.service.TSysResService;
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
 * @title: ResController
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/27 11:17 AM
 */
@Api(tags = "菜单权限管理")
@RestController
@RequestMapping("/system")
public class SysResController {

    @Autowired
    private TSysResService sysResService;


    @ApiOperation(value = "查询菜单权限树")
    @InterfaceCall(interfaceName = "查询菜单权限树",requestMode = "GET")
    @OperatorLog(module = "菜单权限管理", function = "菜单信息", action = "查询菜单权限树", requestMode = "GET")
    @GetMapping("/res/tree")
    public Response getResTree() {
        List<TreeSelectVo> resTree = sysResService.getResTree();
        return Response.success(resTree);
    }

    @ApiOperation(value = "获取菜单权限列表")
    @InterfaceCall(interfaceName = "获取菜单权限列表",requestMode = "POST")
    @OperatorLog(module = "菜单管理", function = "菜单信息", action = "获取菜单权限列表", requestMode = "POST")
    @PostMapping("/res/list")
    public Response getResLIst(@RequestBody(required = false) ResInfoQueryDTO resInfoQuery) {
        List<TSysRes> resInfoList = sysResService.getResLIst(resInfoQuery);
        if (null != resInfoList && 0 < resInfoList.size()) {
            PageInfo<TSysRes> pageInfo = new PageInfo<TSysRes>(resInfoList);
            return Response.success(Collections.singletonList(pageInfo.getList()), pageInfo.getTotal());
        }
        return Response.success();
    }

    @ApiOperation(value = "获取菜单详细信息")
    @InterfaceCall(interfaceName = "获取菜单详细信息",requestMode = "GET")
    @OperatorLog(module = "菜单管理", function = "菜单信息", action = "获取菜单详细信息", requestMode = "GET")
    @GetMapping("/res/detail")
    public Response getResDetail(@RequestParam("id") Long id) {
        TSysRes roleDetail = sysResService.getResDetail(id);
        return Response.success(roleDetail);
    }

    @ApiOperation(value = "新增菜单信息")
    @InterfaceCall(interfaceName = "新增菜单信息",requestMode = "POST")
    @OperatorLog(module = "菜单管理", function = "菜单信息", action = "新增菜单信息", requestMode = "POST")
    @PostMapping("/save/res")
    public Response saveRes(@RequestBody TSysRes sysRes) {
        sysResService.saveRes(sysRes);
        return Response.success();
    }

    @ApiOperation(value = "更新菜单信息")
    @InterfaceCall(interfaceName = "更新菜单信息",requestMode = "PUT")
    @OperatorLog(module = "菜单管理", function = "菜单信息", action = "更新菜单信息", requestMode = "PUT")
    @PutMapping("/update/res")
    public Response updateRes(@RequestBody TSysRes sysRes) {
        sysResService.updateRes(sysRes);
        return Response.success();
    }

    @ApiOperation(value = "删除菜单信息(逻辑删除)")
    @InterfaceCall(interfaceName = "删除菜单信息",requestMode = "DELETE")
    @OperatorLog(module = "菜单管理", function = "菜单信息", action = "删除菜单信息", requestMode = "DELETE")
    @DeleteMapping("/remove/res")
    public Response removeRes(@RequestParam("ids") List<Long> ids) {
        sysResService.removeRes(ids);
        return Response.success();
    }

}
