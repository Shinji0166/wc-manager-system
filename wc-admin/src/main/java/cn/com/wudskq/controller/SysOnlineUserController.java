package cn.com.wudskq.controller;

import cn.com.wudskq.annotation.InterfaceCall;
import cn.com.wudskq.annotation.OperatorLog;
import cn.com.wudskq.model.SysOnlineUser;
import cn.com.wudskq.model.query.SysOnlineUserQueryDTO;
import cn.com.wudskq.service.SysOnlineUserServie;
import cn.com.wudskq.vo.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chenfangchao
 * @title: SysOnlineUserController
 * @projectName wc-manager-system
 * @description: TODO 系统在线用户管理
 * @date 2022/7/3 1:04 AM
 */
@Api(value = "系统在线用户管理")
@RestController
@RequestMapping("/system")
public class SysOnlineUserController {

    @Autowired
    private SysOnlineUserServie sysOnlineUserServie;

    @ApiOperation(value = "获取系统在线用户列表")
    @InterfaceCall(interfaceName = "获取系统在线用户列表",requestMode = "POST")
    @OperatorLog(module = "用户管理",function = "在线用户",action = "查询系统在线用户列表",requestMode = "POST")
    @PostMapping("/online/user/list")
    public Response getSysOnlineUserList(@RequestBody SysOnlineUserQueryDTO sysOnlineUserQuery){
        List<SysOnlineUser> sysOnlineUserList = sysOnlineUserServie.getSysOnlineUserList(sysOnlineUserQuery);
        if(null != sysOnlineUserList && 0 <sysOnlineUserList.size()){
            return Response.success(sysOnlineUserList);
        }
        return Response.success();
    }

}
