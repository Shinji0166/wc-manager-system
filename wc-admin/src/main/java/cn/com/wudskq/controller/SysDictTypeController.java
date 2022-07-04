package cn.com.wudskq.controller;

import cn.com.wudskq.annotation.InterfaceCall;
import cn.com.wudskq.annotation.OperatorLog;
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
    @InterfaceCall(interfaceName = "查询字典类型树",requestMode = "GET")
    @OperatorLog(module = "字典类型管理", function = "字典信息", action = "查询字典类型树", requestMode = "GET")
    @GetMapping("/dict/type/tree")
    public Response getDictTree() {
        List<TreeSelectVo> dictTree = sysDictTypeService.getDictTree();
        return Response.success(dictTree);
    }

    @ApiOperation(value = "查询字典顶级节点下属字典数据列表")
    @InterfaceCall(interfaceName = "查询字典顶级节点下属字典数据列表",requestMode = "POST")
    @OperatorLog(module = "字典类型管理", function = "字典信息", action = "查询字典顶级节点下属字典数据列表", requestMode = "POST")
    @PostMapping("/dict/type/top/data/list")
    public Response getDictTypeTopData(@RequestBody SysDictQueryDTO sysDictQuery) {
        List<SysDictVo> sysDictVoList = sysDictTypeService.getDictTypeTopData(sysDictQuery);
        if (null != sysDictVoList && 0 < sysDictVoList.size()) {
            PageInfo<SysDictVo> pageInfo = new PageInfo<SysDictVo>(sysDictVoList);
            return Response.success(Collections.singletonList(pageInfo.getList()), pageInfo.getTotal());
        }
        return Response.success();
    }

    @ApiOperation(value = "查看字典类型详情")
    @InterfaceCall(interfaceName = "查看字典类型详情",requestMode = "GET")
    @OperatorLog(module = "字典类型管理", function = "字典信息", action = "查看字典类型详情", requestMode = "GET")
    @GetMapping("/dict/type/detail")
    public Response getDictTypeDetail(@RequestParam("id") Long id) {
        SysDictVo sysDictDetail = sysDictTypeService.getDictTypeDetail(id);
        return Response.success(sysDictDetail);
    }

    @ApiOperation(value = "新增字典类型")
    @InterfaceCall(interfaceName = "新增字典类型",requestMode = "POST")
    @OperatorLog(module = "字典类型管理", function = "字典信息", action = "新增字典类型", requestMode = "POST")
    @PostMapping("/save/dict/type")
    public Response saveDictType(@RequestBody SysDictType sysDictType) {
        sysDictTypeService.saveDictType(sysDictType);
        return Response.success();
    }

    @ApiOperation(value = "更新字典类型")
    @InterfaceCall(interfaceName = "更新字典类型",requestMode = "PUT")
    @OperatorLog(module = "字典类型管理", function = "字典信息", action = "更新字典类型", requestMode = "PUT")
    @PutMapping("/update/dict/type")
    public Response updateDictType(@RequestBody SysDictType sysDictType) {
        sysDictTypeService.updateDictType(sysDictType);
        return Response.success();
    }

    @ApiOperation(value = "删除字典类型(逻辑删除)")
    @InterfaceCall(interfaceName = "删除字典类型",requestMode = "DELETE")
    @OperatorLog(module = "字典类型管理", function = "字典信息", action = "删除字典类型", requestMode = "DELETE")
    @DeleteMapping("/remove/dict/type")
    public Response removeDictType(@RequestParam("ids") List<Long> ids) {
        sysDictTypeService.removeDictType(ids);
        return Response.success();
    }
}

