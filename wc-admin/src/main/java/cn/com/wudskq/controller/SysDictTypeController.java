package cn.com.wudskq.controller;

import cn.com.wudskq.model.vo.TreeSelectVo;
import cn.com.wudskq.service.SysDictTypeService;
import cn.com.wudskq.vo.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


    @ApiOperation(value = "查询字典类型树")
    @GetMapping("/dict/type/tree")
    public Response getDictTree(){
        List<TreeSelectVo> dictTree = sysDictTypeService.getDictTree();
        return Response.success(dictTree);
    }

}

