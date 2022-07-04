package cn.com.wudskq.controller;

import cn.com.wudskq.annotation.InterfaceCall;
import cn.com.wudskq.annotation.OperatorLog;
import cn.com.wudskq.model.SysLoginLog;
import cn.com.wudskq.model.query.LoginLogQueryDTO;
import cn.com.wudskq.service.SysLoginLogService;
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
 * @title: SysLoginLogController
 * @projectName wc-manager-system
 * @description: TODO 系统登录日志管理
 * @date 2022/7/2 4:34 PM
 */
@Api(tags = "系统登录日志管理")
@RestController
@RequestMapping("/system")
public class SysLoginLogController {

    @Autowired
    private SysLoginLogService sysLoginLogService;

    @ApiOperation(value = "获取登录日志信息列表")
    @InterfaceCall(interfaceName = "获取登录日志信息列表",requestMode = "POST")
    @OperatorLog(module = "登录日志管理", function = "登录日志信息", action = "获取登录日志信息列表", requestMode = "POST")
    @PostMapping("/login/log/list")
    public Response getLoginLogList(@RequestBody(required = false) LoginLogQueryDTO loginLogQuery) {
        List<SysLoginLog> sysLoginLogList = sysLoginLogService.getLoginLogList(loginLogQuery);
        if (null != sysLoginLogList && 0 < sysLoginLogList.size()) {
            PageInfo<SysLoginLog> pageInfo = new PageInfo<SysLoginLog>(sysLoginLogList);
            return Response.success(Collections.singletonList(pageInfo.getList()), pageInfo.getTotal());
        }
        return Response.success();
    }

    @ApiOperation(value = "获取登录日志详细信息")
    @InterfaceCall(interfaceName = "获取登录日志详细信息",requestMode = "GET")
    @OperatorLog(module = "登录日志管理", function = "登录日志信息", action = "获取登录日志详细信息", requestMode = "GET")
    @GetMapping("/login/log/detail")
    public Response getLoginLogDetail(@RequestParam("id") Long id) {
        SysLoginLog sysLoginLogDetail = sysLoginLogService.getLoginLogDetail(id);
        return Response.success(sysLoginLogDetail);
    }
}
