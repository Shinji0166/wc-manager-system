package cn.com.wudskq.service.impl;

import cn.com.wudskq.mapper.SysDictTypeMapper;
import cn.com.wudskq.model.SysDictType;
import cn.com.wudskq.model.query.SysDictQueryDTO;
import cn.com.wudskq.model.vo.SysDictVo;
import cn.com.wudskq.model.vo.TreeSelectVo;
import cn.com.wudskq.service.SysDictTypeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenfangchao
 * @title: SysDictTypeServiceImpl
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/28 5:12 PM
 */
@Service
public class SysDictTypeServiceImpl implements SysDictTypeService {

    @Autowired
    private SysDictTypeMapper sysDictTypeMapper;


    @Override
    public List<TreeSelectVo> getDictTree() {
        //获取全部字典类型数据;
        QueryWrapper<SysDictType> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status",0);
        List<SysDictType> sysDictTypeList = sysDictTypeMapper.selectList(queryWrapper);
        //构建字典类型树
        return buildSysDictTypeTree(sysDictTypeList);
    }

    @Override
    public void saveDictType(SysDictType sysDictType) {
        sysDictTypeMapper.insert(sysDictType);
    }

    @Override
    public void updateDictType(SysDictType sysDictType) {
        sysDictTypeMapper.updateById(sysDictType);
    }

    @Override
    public void removeDictType(List<Long> ids) {
        sysDictTypeMapper.removeDictType(ids);
    }

    @Override
    public List<SysDictVo> getDictTypeTopData(SysDictQueryDTO sysDictQuery) {
        return sysDictTypeMapper.getDictTypeTopData(sysDictQuery);
    }


    //构建字典树
    private List<TreeSelectVo> buildSysDictTypeTree(List<SysDictType> dictTypes) {
        List<TreeSelectVo> resultList = new ArrayList<>(); //result
        //获取所有ID 顶级节点默认pid为0
        List<Long> idList = new ArrayList<>();
        for (SysDictType sysDictType : dictTypes) {
            //存储列表节点ID
            idList.add(sysDictType.getId());
        }
        //迭代判断是否为顶级节点
        for (Iterator<SysDictType> iterator= dictTypes.iterator(); iterator.hasNext();){
             SysDictType sysDictType = iterator.next();
             //判断是否为顶级节点
            if(!idList.contains(Long.valueOf(sysDictType.getPid()))){
                //生成顶级节点
                TreeSelectVo treeSelectNode = new TreeSelectVo(sysDictType);
                //递归查找顶级节点下属所有子节点
                recursionFn(dictTypes, treeSelectNode);
                //结果中添加顶级节点
                resultList.add(treeSelectNode);
            }
        }
        if (resultList.isEmpty())
        {
            List<TreeSelectVo> collect = dictTypes.stream().map(TreeSelectVo::new).collect(Collectors.toList());
            resultList = collect;
        }
        return resultList;
    };

    /**
     * 递归列表
     *
     * @param list
     * @param t
     */
    private void recursionFn(List<SysDictType> list, TreeSelectVo t)
    {
        // 得到子节点列表
        List<TreeSelectVo> childList = getChildList(list, t);
        t.setChildren(childList);
    }

    /**
     * 得到子节点列表
     */
    private List<TreeSelectVo> getChildList(List<SysDictType> list, TreeSelectVo t)
    {
        //结果集
        List<TreeSelectVo> tlist = new ArrayList<>();
        //迭代判断
        Iterator<SysDictType> it = list.iterator();
        while (it.hasNext())
        {
            SysDictType n = it.next();
            //节点列表中的节点PID等于顶级节点的ID
            //代表该节点为顶级节点的子节点
            if (n.getPid().longValue() == t.getId().longValue())
            {
                TreeSelectVo treeSelect = new TreeSelectVo(n);
                tlist.add(treeSelect);
            }
        }
        return tlist;
    }
}
