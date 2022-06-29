package cn.com.wudskq.controller;

import cn.com.wudskq.model.SysDictType;
import cn.com.wudskq.model.query.SysDictQueryDTO;
import cn.com.wudskq.model.vo.SysDictVo;
import cn.com.wudskq.model.vo.TreeSelectVo;
import cn.com.wudskq.service.SysDictTypeService;
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

    @ApiOperation(value = "查询字典顶级节点下属字典数据")
    @PostMapping("/dict/type/top/data")
    public Response getDictTypeTopData(@RequestBody SysDictQueryDTO sysDictQuery){
        List<SysDictVo> sysDictVoList = sysDictTypeService.getDictTypeTopData(sysDictQuery);
        if(null != sysDictVoList && 0 < sysDictVoList.size()){
            PageInfo<SysDictVo> pageInfo = new PageInfo<SysDictVo>(sysDictVoList);
            return Response.success(Collections.singletonList(pageInfo.getList()),pageInfo.getTotal());
        }
        return Response.success();
    }

    @ApiOperation(value = "新增字典类型")
    @PostMapping("/save/dict/type")
    public Response saveDictType(@RequestBody SysDictType sysDictType){
        sysDictTypeService.saveDictType(sysDictType);
        return Response.success();
    }

    @ApiOperation(value = "更新字典类型")
    @PutMapping("/update/dict/type")
    public Response updateDictType(@RequestBody SysDictType sysDictType){
        sysDictTypeService.updateDictType(sysDictType);
        return Response.success();
    }

    @ApiOperation(value = "删除字典类型")
    @DeleteMapping("/remove/dict/type")
    public Response removeDictType(@RequestParam("ids")List<Long> ids){
        sysDictTypeService.removeDictType(ids);
        return Response.success();
    }
}

