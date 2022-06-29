package cn.com.wudskq.service;

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
}
