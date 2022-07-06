package cn.com.wudskq.controller;

import cn.com.wudskq.annotation.InterfaceCall;
import cn.com.wudskq.annotation.OperatorLog;
import cn.com.wudskq.model.SysOperatorLog;
import cn.com.wudskq.model.query.OperatorQueryDTO;
import cn.com.wudskq.service.SysOperatorLogService;
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
 * @title: SysOperatorLogController
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/7/1 8:45 PM
 */
@Api(tags = "系统操作日志管理")
@RestController
@RequestMapping("/system")
public class SysOperatorLogController {

    @Autowired
    private SysOperatorLogService sysOperatorLogService;


    @ApiOperation(value = "系统操作日志列表")
    @InterfaceCall(interfaceName = "系统操作日志列表",requestMode = "POST")
    @PostMapping("/operator/log/list")
    public Response getOperatorLogList(@RequestBody OperatorQueryDTO operatorQuery){
        List<SysOperatorLog> operatorLogList = sysOperatorLogService.getOperatorLogList(operatorQuery);
        if (null != operatorLogList && 0 < operatorLogList.size()) {
            PageInfo<SysOperatorLog> pageInfo = new PageInfo<SysOperatorLog>(operatorLogList);
            return Response.success(Collections.singletonList(pageInfo.getList()), pageInfo.getTotal());
        }
        return Response.success();
    }


}
