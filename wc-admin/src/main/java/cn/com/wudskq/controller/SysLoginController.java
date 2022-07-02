package cn.com.wudskq.controller;

import cn.com.wudskq.annotation.OperatorLog;
import cn.com.wudskq.model.common.LoginDTO;
import cn.com.wudskq.web.LoginService;
import cn.com.wudskq.vo.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author chenfangchao
 * @title: LoginController
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/23 3:51 PM
 */
@Api(tags = "系统登录接口")
@RestController
@RequestMapping("/wc/system")
public class SysLoginController {

    @Autowired
    private LoginService loginService;

    @ApiModelProperty(value = "登录接口")
    @OperatorLog(module = "系统功能", function = "登录功能", action = "登录", requestMode = "POST")
    @PostMapping("/doLogin")
    public Response doLogin(@RequestBody LoginDTO login) {
        return Response.success(loginService.doLogin(login));
    }
}
