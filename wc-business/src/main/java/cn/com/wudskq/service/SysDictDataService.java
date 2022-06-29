package cn.com.wudskq.service;

import cn.com.wudskq.model.SysDictData;
import cn.com.wudskq.model.query.SysDictQueryDTO;
import cn.com.wudskq.model.vo.SysDictVo;

import java.util.List;

/**
 * @author chenfangchao
 * @title: SysDictDataService
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/28 5:15 PM
 */
public interface SysDictDataService {

    /**
     * 根据字典类型查询字典数据列表
     * @param sysDictQuery
     * @return
     */
    List<SysDictVo> getDictDataList(SysDictQueryDTO sysDictQuery);

    /**
     * 新增字典数据
     * @param sysDictData
     */
    void saveDictData(SysDictData sysDictData);

    /**
     * 更新字典数据
     * @param sysDictData
     */
    void updateDictData(SysDictData sysDictData);

    /**
     * 删除字典数据(逻辑删除)
     * @param ids
     */
    void removeDictData(List<Long> ids);

    /**
     * 获取字典数据详情
     * @param id
     * @return
     */
    SysDictVo getDictDataDetail(Long id);
}
