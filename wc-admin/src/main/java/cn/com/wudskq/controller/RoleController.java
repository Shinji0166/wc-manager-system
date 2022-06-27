package cn.com.wudskq.controller;

import cn.com.wudskq.model.TSysRole;
import cn.com.wudskq.model.query.RoleInfoQueryDTO;
import cn.com.wudskq.service.TSysRoleService;
import cn.com.wudskq.vo.Response;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api("角色管理")
@RestController
@RequestMapping("/system")
public class RoleController {

    @Autowired
    private TSysRoleService sysRoleService;


    @ApiOperation("获取角色信息列表")
    @PostMapping("/role/list")
    public Response getRoleInfoList(@RequestBody(required = false) RoleInfoQueryDTO roleInfoQuery){
        List<TSysRole> roleInfoList = sysRoleService.getRoleInfoList(roleInfoQuery);
        if(null != roleInfoList && 0 < roleInfoList.size()){
            PageInfo<TSysRole> pageInfo = new PageInfo<TSysRole>(roleInfoList);
            return Response.success(Collections.singletonList(pageInfo.getList()),pageInfo.getTotal());
        }
        return Response.success();
    }

    @ApiOperation("获取角色详细信息")
    @GetMapping("/role/detail")
    public Response getRoleDetail(@RequestParam("id")Long id){
        TSysRole roleDetail = sysRoleService.getRoleDetail(id);
        return Response.success(roleDetail);
    }

    @ApiOperation("新增角色信息")
    @PostMapping("/save/role")
    public Response saveRole(@RequestBody TSysRole sysRole){
        sysRoleService.saveRole(sysRole);
        return Response.success();
    }

    @ApiOperation("更新角色信息")
    @PutMapping("/update/role")
    public Response updateRole(@RequestBody TSysRole sysRole){
        sysRoleService.updateRole(sysRole);
        return Response.success();
    }

    @ApiOperation("删除角色信息(逻辑删除)")
    @DeleteMapping("/remove/role")
    public Response removeRole(@RequestParam("ids")List<Long> ids){
        sysRoleService.removeRole(ids);
        return Response.success();
    }
}
