package cn.com.wudskq.controller;

import cn.com.wudskq.annotation.InterfaceCall;
import cn.com.wudskq.annotation.OperatorLog;
import cn.com.wudskq.service.SysAppendixService;
import cn.com.wudskq.vo.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author chenfangchao
 * @title: SysUploadController
 * @projectName wc-manager-system
 * @description: TODO 系统文件上传下载接口
 * @date 2022/7/10 2:41 AM
 */
@Api(tags = "系统文件上传下载接口")
@RestController
@RequestMapping("/system")
public class SysFileUploadDownController {

    @Autowired
    private SysAppendixService sysAppendixService;

    @ApiOperation(value = "上传文件")
    @InterfaceCall(interfaceName = "上传文件",requestMode = "POST")
    @OperatorLog(module = "附件管理", function = "附件信息", action = "上传文件", requestMode = "POST")
    @PostMapping("/upload/file")
    public Response uploadFile(@RequestParam("file") MultipartFile multipartFile,@RequestParam("dataSource")Integer dataSource ){
        return Response.success(sysAppendixService.uploadFile(multipartFile,dataSource));
    }

    @ApiOperation(value = "根据附件ID查询附件")
    @InterfaceCall(interfaceName = "根据附件ID查询附件",requestMode = "GET")
    @OperatorLog(module = "附件管理", function = "附件信息", action = "根据附件ID查询附件", requestMode = "GET")
    @GetMapping("/query/file")
    public Response queryFile(@RequestParam("id")String id){
        return Response.success(sysAppendixService.queryFile(id));
    }


    @ApiOperation(value = "下载文件")
    @InterfaceCall(interfaceName = "下载文件",requestMode = "POST")
    @OperatorLog(module = "附件管理", function = "附件信息", action = "下载文件", requestMode = "POST")
    @PostMapping("/download/file")
    public Response downloadFile(@RequestParam("fileName")String fileName){
        return Response.success();
    }

}
