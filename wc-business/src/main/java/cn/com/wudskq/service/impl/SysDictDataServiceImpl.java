package cn.com.wudskq.service.impl;

import cn.com.wudskq.mapper.SysDictDataMapper;
import cn.com.wudskq.model.SysDictData;
import cn.com.wudskq.model.query.SysDictQueryDTO;
import cn.com.wudskq.model.vo.SysDictVo;
import cn.com.wudskq.service.SysDictDataService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author chenfangchao
 * @title: SysDictDataServiceImpl
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/28 5:15 PM
 */
@Service
public class SysDictDataServiceImpl implements SysDictDataService {

    @Autowired
    private SysDictDataMapper sysDictDataMapper;


    @Override
    public List<SysDictVo> getDictDataList(SysDictQueryDTO sysDictQuery) {
        PageHelper.startPage(sysDictQuery.getPageNum(),sysDictQuery.getPageSize());
        return sysDictDataMapper.getDictDataList(sysDictQuery);
    }

    @Override
    public void saveDictData(SysDictData sysDictData) {
        sysDictDataMapper.insert(sysDictData);
    }

    @Override
    public void updateDictData(SysDictData sysDictData) {
        sysDictDataMapper.updateById(sysDictData);
    }

    @Override
    public void removeDictData(List<Long> ids) {
        sysDictDataMapper.removeDictData(ids);
    }

    @Override
    public SysDictVo getDictDataDetail(Long id) {
        return sysDictDataMapper.getDictDataDetail(id);
    }
}
