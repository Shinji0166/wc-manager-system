package cn.com.wudskq.controller;

import cn.com.wudskq.annotation.InterfaceCall;
import cn.com.wudskq.annotation.OperatorLog;
import cn.com.wudskq.annotation.ProhibitResubmit;
import cn.com.wudskq.model.TSysRole;
import cn.com.wudskq.model.query.RoleInfoQueryDTO;
import cn.com.wudskq.model.vo.SysRoleSelectVo;
import cn.com.wudskq.service.TSysRoleService;
import cn.com.wudskq.vo.Response;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * @author chenfangchao
 * @title: RoleController
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/27 8:51 AM
 */
@Api(tags = "角色管理")
@RestController
@RequestMapping("/system")
public class SysRoleController {

    @Autowired
    private TSysRoleService sysRoleService;

    @ApiOperation(value = "获取角色信息下拉框数据")
    @InterfaceCall(interfaceName = "获取角色信息下拉框数据",requestMode = "POST")
    @OperatorLog(module = "角色管理", function = "角色信息", action = "获取角色信息下拉框数据", requestMode = "POST")
    @PostMapping("/role/select")
    public Response getRoleSelect(@RequestBody(required = false) RoleInfoQueryDTO roleInfoQuery) {
        List<SysRoleSelectVo> roleSelect = sysRoleService.getRoleSelect(roleInfoQuery);
        return Response.success(roleSelect);
    }


    @ApiOperation(value = "获取角色信息列表")
    @PreAuthorize(value = "hasPermission('/system/role/list','res_system:role:query')")
    @InterfaceCall(interfaceName = "获取角色信息列表",requestMode = "POST")
    @OperatorLog(module = "角色管理", function = "角色信息", action = "获取角色信息列表", requestMode = "POST")
    @PostMapping("/role/list")
    public Response getRoleInfoList(@RequestBody(required = false) RoleInfoQueryDTO roleInfoQuery) {
        List<TSysRole> roleInfoList = sysRoleService.getRoleInfoList(roleInfoQuery);
        if (null != roleInfoList && 0 < roleInfoList.size()) {
            PageInfo<TSysRole> pageInfo = new PageInfo<TSysRole>(roleInfoList);
            return Response.success(Collections.singletonList(pageInfo.getList()), pageInfo.getTotal());
        }
        return Response.success();
    }

    @ApiOperation(value = "获取角色详细信息")
    @PreAuthorize(value = "hasPermission('/system/role/detail','res_system:role:query')")
    @InterfaceCall(interfaceName = "获取角色详细信息",requestMode = "GET")
    @OperatorLog(module = "角色管理", function = "角色信息", action = "获取角色详细信息", requestMode = "GET")
    @GetMapping("/role/detail")
    public Response getRoleDetail(@RequestParam("id") Long id) {
        TSysRole roleDetail = sysRoleService.getRoleDetail(id);
        return Response.success(roleDetail);
    }

    @ApiOperation(value = "新增角色信息")
    @ProhibitResubmit
    @PreAuthorize(value = "hasPermission('/system/save/role','res_system:role:add')")
    @InterfaceCall(interfaceName = "新增角色信息",requestMode = "POST")
    @OperatorLog(module = "角色管理", function = "角色信息", action = "新增角色信息", requestMode = "POST")
    @PostMapping("/save/role")
    public Response saveRole(@Validated @RequestBody TSysRole sysRole) {
        sysRoleService.saveRole(sysRole);
        return Response.success();
    }

    @ApiOperation(value = "更新角色信息")
    @ProhibitResubmit
    @PreAuthorize(value = "hasPermission('/system/update/role','res_system:role:edit')")
    @InterfaceCall(interfaceName = "更新角色信息",requestMode = "PUT")
    @OperatorLog(module = "角色管理", function = "角色信息", action = "更新角色信息", requestMode = "PUT")
    @PutMapping("/update/role")
    public Response updateRole(@Validated @RequestBody TSysRole sysRole) {
        sysRoleService.updateRole(sysRole);
        return Response.success();
    }

    @ApiOperation(value = "删除角色信息(逻辑删除)")
    @PreAuthorize(value = "hasPermission('/system/remove/role','res_system:role:delete')")
    @InterfaceCall(interfaceName = "删除角色信息",requestMode = "DELETE")
    @OperatorLog(module = "角色管理", function = "角色信息", action = "删除角色信息", requestMode = "DELETE")
    @DeleteMapping("/remove/role")
    public Response removeRole(@RequestParam("ids") List<Long> ids) {
        sysRoleService.removeRole(ids);
        return Response.success();
    }
}
