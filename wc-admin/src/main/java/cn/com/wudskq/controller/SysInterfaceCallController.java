package cn.com.wudskq.controller;

import cn.com.wudskq.annotation.InterfaceCall;
import cn.com.wudskq.annotation.OperatorLog;
import cn.com.wudskq.model.SysInterfaceCall;
import cn.com.wudskq.model.SysOperatorLog;
import cn.com.wudskq.model.query.OperatorQueryDTO;
import cn.com.wudskq.model.query.SysInterfaceCallQueryDTO;
import cn.com.wudskq.service.SysInterfaceCallService;
import cn.com.wudskq.vo.Response;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * @author chenfangchao
 * @title: SysInterfaceCallController
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/7/6 1:05 AM
 */
@Api(tags = "系统接口调用情况管理")
@RestController
@RequestMapping("/system")
public class SysInterfaceCallController {

    @Autowired
    private SysInterfaceCallService sysInterfaceCallService;

    @ApiOperation(value = "接口调用分析")
    @InterfaceCall(interfaceName = "接口调用分析",requestMode = "POST")
    @OperatorLog(module = "公共模块",function = "接口调用分析",action = "接口调用分析",requestMode = "POST")
    @PostMapping("/interface/call/data")
    public Response getInterfaceCallData(@RequestBody SysInterfaceCallQueryDTO interfaceCallQuery){
        List<SysInterfaceCall> sysInterfaceCallList = sysInterfaceCallService.getInterfaceCallData(interfaceCallQuery);
        if (null != sysInterfaceCallList && 0 < sysInterfaceCallList.size()) {

        }
        return Response.success();
    }

}
