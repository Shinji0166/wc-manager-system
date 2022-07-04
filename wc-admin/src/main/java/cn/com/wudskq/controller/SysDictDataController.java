package cn.com.wudskq.controller;

import cn.com.wudskq.annotation.InterfaceCall;
import cn.com.wudskq.annotation.OperatorLog;
import cn.com.wudskq.model.SysDictData;
import cn.com.wudskq.model.query.SysDictQueryDTO;
import cn.com.wudskq.model.vo.SysDictVo;
import cn.com.wudskq.service.SysDictDataService;
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
 * @title: SysDictDataController
 * @projectName wc-manager-system
 * @description: TODO 字典数据管理
 * @date 2022/6/28 5:14 PM
 */
@Api(tags = "字典数据管理")
@RestController
@RequestMapping("/system")
public class SysDictDataController {

    @Autowired
    private SysDictDataService sysDictDataService;

    @ApiOperation(value = "根据字典类型查询字典数据列表")
    @InterfaceCall(interfaceName = "根据字典类型查询字典数据列表",requestMode = "POST")
    @OperatorLog(module = "字典管理", function = "字典信息", action = "根据字典类型查询字典数据列表", requestMode = "POST")
    @PostMapping("/dict/data/list")
    public Response getDictDataList(@RequestBody SysDictQueryDTO sysDictQuery) {
        List<SysDictVo> sysDictVoList = sysDictDataService.getDictDataList(sysDictQuery);
        if (null != sysDictVoList && 0 < sysDictVoList.size()) {
            PageInfo<SysDictVo> pageInfo = new PageInfo<SysDictVo>(sysDictVoList);
            return Response.success(Collections.singletonList(pageInfo.getList()), pageInfo.getTotal());
        }
        return Response.success();
    }


    @ApiOperation(value = "获取字典数据详情")
    @InterfaceCall(interfaceName = "获取字典数据详情",requestMode = "GET")
    @OperatorLog(module = "字典管理", function = "字典信息", action = "获取字典数据详情", requestMode = "GET")
    @GetMapping("/dict/data/detail")
    public Response getDictDataDetail(@RequestParam("id") Long id) {
        SysDictVo sysDictDetail = sysDictDataService.getDictDataDetail(id);
        return Response.success(sysDictDetail);
    }

    @ApiOperation(value = "新增字典数据")
    @InterfaceCall(interfaceName = "新增字典数据",requestMode = "POST")
    @OperatorLog(module = "字典管理", function = "字典信息", action = "新增字典数据", requestMode = "POST")
    @PostMapping("/save/dict/data")
    public Response saveDictData(@RequestBody SysDictData sysDictData) {
        sysDictDataService.saveDictData(sysDictData);
        return Response.success();
    }

    @ApiOperation(value = "更新字典数据")
    @InterfaceCall(interfaceName = "更新字典数据",requestMode = "PUT")
    @OperatorLog(module = "字典管理", function = "字典信息", action = "更新字典数据", requestMode = "PUT")
    @PutMapping("/update/dict/data")
    public Response updateDictData(@RequestBody SysDictData sysDictData) {
        sysDictDataService.updateDictData(sysDictData);
        return Response.success();
    }

    @ApiOperation(value = "删除字典数据")
    @InterfaceCall(interfaceName = "删除字典数据",requestMode = "DELETE")
    @OperatorLog(module = "字典管理", function = "字典信息", action = "删除字典数据", requestMode = "DELETE")
    @DeleteMapping("/remove/dict/data")
    public Response removeDictData(@RequestParam("ids") List<Long> ids) {
        sysDictDataService.removeDictData(ids);
        return Response.success();
    }


}
