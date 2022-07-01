package cn.com.wudskq.controller;

import cn.com.wudskq.annotation.OperatorLog;
import cn.com.wudskq.model.TSysUser;
import cn.com.wudskq.model.query.UserInfoQueryDTO;
import cn.com.wudskq.service.TSysUserService;
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
 * @title: UserController
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/23 2:32 PM
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/system")
public class UserController {

    /**
     * 用户组件
     **/
    @Autowired
    private TSysUserService sysUserService;

    @ApiOperation(value = "获取用户信息列表")
    @OperatorLog(module = "用户管理", function = "用户信息", action = "获取用户信息列表", requestMode = "POST")
    @PostMapping("/user/list")
    public Response getUserInfoList(@RequestBody(required = false) UserInfoQueryDTO userInfoQuery) {
        List<TSysUser> userInfoList = sysUserService.getUserInfoList(userInfoQuery);
        if (null != userInfoList && 0 < userInfoList.size()) {
            PageInfo<TSysUser> pageInfo = new PageInfo<TSysUser>(userInfoList);
            return Response.success(Collections.singletonList(pageInfo.getList()), pageInfo.getTotal());
        }
        return Response.success();
    }

    @ApiOperation(value = "获取用户详情信息")
    @OperatorLog(module = "用户管理", function = "用户信息", action = "获取用户详情信息", requestMode = "GET")
    @GetMapping("/user/detail")
    public Response getUserDetail(@RequestParam("id") Long id) {
        TSysUser userDetail = sysUserService.getUserDetail(id);
        return Response.success(userDetail);
    }

    @ApiOperation(value = "新增用户信息")
    @OperatorLog(module = "用户管理", function = "用户信息", action = "新增用户信息", requestMode = "POST")
    @PostMapping("/save/user")
    public Response saveUser(@RequestBody TSysUser sysUser) {
        sysUserService.saveUser(sysUser);
        return Response.success();
    }

    @ApiOperation(value = "更新用户信息")
    @OperatorLog(module = "用户管理", function = "用户信息", action = "更新用户信息", requestMode = "PUT")
    @PutMapping("/update/user")
    public Response updateUser(@RequestBody TSysUser sysUser) {
        sysUserService.updateUser(sysUser);
        return Response.success();
    }

    @ApiOperation(value = "删除用户信息(逻辑删除)")
    @OperatorLog(module = "用户管理", function = "用户信息", action = "删除用户信息", requestMode = "DELETE")
    @DeleteMapping("/remove/user")
    public Response removeUser(@RequestParam("ids") List<String> ids) {
        sysUserService.removeUser(ids);
        return Response.success();
    }

}
