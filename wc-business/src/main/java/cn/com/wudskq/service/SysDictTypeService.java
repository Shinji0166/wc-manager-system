package cn.com.wudskq.service;

import cn.com.wudskq.model.SysDictType;
import cn.com.wudskq.model.query.SysDictQueryDTO;
import cn.com.wudskq.model.vo.SysDictVo;
import cn.com.wudskq.model.vo.TreeSelectVo;

import java.util.List;

/**
 * @author chenfangchao
 * @title: SysDictTypeService
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/28 5:12 PM
 */
public interface SysDictTypeService {

    /**
     * 查询字典类型树
     * @return
     */
    List<TreeSelectVo> getDictTree();


    /**
     * 查询字典类型列表数据
     * @param sysDictQuery
     * @return
     */
    List<SysDictVo> getDictList(SysDictQueryDTO sysDictQuery);

    /**
     * 新增字典类型
     * @param sysDictType
     */
    void saveDictType(SysDictType sysDictType);

    /**
     * 更新字典类型
     * @param sysDictType
     */
    void updateDictType(SysDictType sysDictType);

    /**
     * 删除字典类型
     * @param ids
     */
    void removeDictType(List<Long> ids);

    /**
     * 查询字典顶级节点下属数据
     * @param sysDictQuery
     * @return
     */
    List<SysDictVo> getDictTypeTopData(SysDictQueryDTO sysDictQuery);

    /**
     * 查看字典类型详情信息
     * @param id
     * @return
     */
    SysDictVo getDictTypeDetail(Long id);
}
