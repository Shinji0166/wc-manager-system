package cn.com.wudskq.controller;

import cn.com.wudskq.service.SysAppendixService;
import cn.com.wudskq.utils.AliYunOSSUtil;
import cn.com.wudskq.utils.FileUtil;
import cn.com.wudskq.vo.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

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
    @PostMapping("/upload/file")
    public Response uploadFile(@RequestParam("file") MultipartFile multipartFile,@RequestParam("dataSource")Integer dataSource ){
        return Response.success(sysAppendixService.uploadFile(multipartFile,dataSource));
    }

    @PostMapping("/download/file")
    public Response downloadFile(@RequestParam("fileName")String fileName){
//        aliYunOSSUtil.downloadFile(fileName);
        return Response.success();
    }

}
