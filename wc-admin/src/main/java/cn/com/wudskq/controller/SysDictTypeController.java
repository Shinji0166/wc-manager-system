package cn.com.wudskq.controller;

import cn.com.wudskq.service.SysDictTypeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenfangchao
 * @title: SysDictTypeController
 * @projectName wc-manager-system
 * @description: TODO 字典类型管理
 * @date 2022/6/28 5:11 PM
 */
@Api(tags = "字典类型管理")
@RestController
@RequestMapping("/system")
public class SysDictTypeController {

    @Autowired
    private SysDictTypeService sysDictTypeService;
}

