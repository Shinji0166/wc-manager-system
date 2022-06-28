package cn.com.wudskq.service.impl;

import cn.com.wudskq.mapper.SysDictTypeMapper;
import cn.com.wudskq.service.SysDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
