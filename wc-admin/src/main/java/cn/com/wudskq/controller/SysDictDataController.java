package cn.com.wudskq.controller;

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
    @PostMapping("/dict/data/list")
    public Response getDictDataList(@RequestBody SysDictQueryDTO sysDictQuery){
        List<SysDictVo> sysDictVoList = sysDictDataService.getDictDataList(sysDictQuery);
        if(null != sysDictVoList && 0 < sysDictVoList.size()){
            PageInfo<SysDictVo> pageInfo = new PageInfo<SysDictVo>(sysDictVoList);
            return Response.success(Collections.singletonList(pageInfo.getList()),pageInfo.getTotal());
        }
        return Response.success();
    }

    @ApiOperation(value = "新增字典数据")
    @PostMapping("/save/dict/data")
    public Response saveDictData(@RequestBody SysDictData sysDictData){
        sysDictDataService.saveDictData(sysDictData);
        return Response.success();
    }

    @ApiOperation(value = "更新字典数据")
    @PutMapping("/update/dict/data")
    public Response updateDictData(@RequestBody SysDictData sysDictData){
        sysDictDataService.updateDictData(sysDictData);
        return Response.success();
    }

    @ApiOperation(value = "删除字典数据")
    @DeleteMapping("/remove/dict/data")
    public Response removeDictData(@RequestParam("ids")List<Long> ids){
        sysDictDataService.removeDictData(ids);
        return Response.success();
    }



}
