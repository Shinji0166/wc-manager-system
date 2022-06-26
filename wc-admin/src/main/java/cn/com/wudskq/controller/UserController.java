package cn.com.wudskq.controller;

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
@Api("用户管理")
@RestController
@RequestMapping("/wc")
public class UserController {

    /** 用户组件 **/
    @Autowired
    private TSysUserService sysUserService;

    @ApiOperation("获取用户信息")
    @PostMapping("/user/list")
    public Response getUserInfoList(@RequestBody(required = false) UserInfoQueryDTO userInfoQuery){
        List<TSysUser> userInfoList = sysUserService.getUserInfoList(userInfoQuery);
        if(null != userInfoList && 0 < userInfoList.size()){
            PageInfo<TSysUser> pageInfo = new PageInfo<TSysUser>(userInfoList);
            return Response.success(Collections.singletonList(pageInfo.getList()),pageInfo.getTotal());
        }
        return Response.success();
    }

    @ApiOperation("获取用户详情信息")
    @GetMapping("/user/detail")
    public Response getUserDetail(@RequestParam("id") String id){
        TSysUser userDetail =sysUserService.getUserDetail(id);
        return Response.success(userDetail);
    }

    @ApiOperation("新增用户信息")
    @PostMapping("/save/user")
    public Response saveUser(@RequestBody TSysUser sysUser){
        sysUserService.saveUser(sysUser);
        return Response.success();
    }

    @ApiOperation("更新用户信息")
    @PutMapping("/update/user")
    public Response updateUser(@RequestBody TSysUser sysUser){
        sysUserService.updateUser(sysUser);
        return Response.success();
    }

    @ApiOperation("删除用户信息(逻辑删除)")
    @DeleteMapping("/remove/user")
    public Response removeUser(@RequestParam("ids")List<String> ids){
        sysUserService.removeUser(ids);
        return Response.success();
    }

}
