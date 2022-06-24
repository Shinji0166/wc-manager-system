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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/wc/user/")
public class UserController {

    /** 用户组件 **/
    @Autowired
    private TSysUserService sysUserService;

    @ApiOperation("获取用户信息")
    @PostMapping("/list")
    public Response getUserInfoList(@RequestBody(required = false) UserInfoQueryDTO userInfoQuery){
        List<TSysUser> userInfoList = sysUserService.getUserInfoList(userInfoQuery);
        if(null != userInfoList && 0 < userInfoList.size()){
            PageInfo<TSysUser> pageInfo = new PageInfo<TSysUser>(userInfoList);
            return Response.success(Collections.singletonList(pageInfo.getList()),pageInfo.getTotal());
        }
        return Response.success();
    }

}
