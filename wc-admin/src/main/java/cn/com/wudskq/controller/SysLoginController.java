package cn.com.wudskq.controller;

import cn.com.wudskq.annotation.InterfaceCall;
import cn.com.wudskq.annotation.OperatorLog;
import cn.com.wudskq.model.common.LoginDTO;
import cn.com.wudskq.vo.Response;
import cn.com.wudskq.web.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chenfangchao
 * @title: LoginController
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/23 3:51 PM
 */
@Api(tags = "系统登录接口")
@RestController
@RequestMapping("/system")
public class SysLoginController {

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "登录接口")
    @InterfaceCall(interfaceName = "登录接口",requestMode = "POST")
    @PostMapping("/doLogin")
    public void doLogin(@RequestBody LoginDTO login, HttpServletRequest request, HttpServletResponse response) {
        loginService.doLogin(login,request,response);
    }


    @ApiOperation(value = "登出接口")
    @InterfaceCall(interfaceName = "登出接口",requestMode = "GET")
    @GetMapping("/doLogout")
    public Response doLogOut(HttpServletRequest request, HttpServletResponse response) {
        loginService.doLogout(request,response);
        return Response.success();
    }

    @ApiOperation(value = "强制退出")
    @PreAuthorize(value = "hasPermission('/system/force/logout','res_system:online:user:kickout')")
    @InterfaceCall(interfaceName = "强制退出",requestMode = "GET")
    @OperatorLog(module = "系统功能", function = "登出功能", action = "强制退出", requestMode = "GET")
    @GetMapping("/force/logout")
    public Response doForceLogout(@RequestParam("sessionId")String sessionId){
        loginService.doForceLogout(sessionId);
        return Response.success();
    }


}
