package cn.com.wudskq.controller;

import cn.com.wudskq.annotation.OperatorLog;
import cn.com.wudskq.model.common.LoginDTO;
import cn.com.wudskq.web.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
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

    @ApiModelProperty(value = "登录接口")
    @OperatorLog(module = "系统功能", function = "登录功能", action = "登录", requestMode = "POST")
    @PostMapping("/doLogin")
    public void doLogin(@RequestBody LoginDTO login, HttpServletRequest request, HttpServletResponse response) {
        loginService.doLogin(login,request,response);
    }


    @ApiModelProperty(value = "登出接口")
    @OperatorLog(module = "系统功能", function = "登出功能", action = "登出", requestMode = "GET")
    @GetMapping("/doLogout")
    public void doLogOut(HttpServletRequest request, HttpServletResponse response) {
        loginService.doLogout(request,response);
    }


}
