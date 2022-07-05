package cn.com.wudskq.service.impl;

import cn.com.wudskq.mapper.SysInterfaceCallMapper;
import cn.com.wudskq.model.SysInterfaceCall;
import cn.com.wudskq.model.query.SysInterfaceCallQueryDTO;
import cn.com.wudskq.service.SysInterfaceCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenfangchao
 * @title: SysInterfaceCallServiceImpl
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/7/6 1:04 AM
 */
@Service
public class SysInterfaceCallServiceImpl implements SysInterfaceCallService {

    @Autowired
    private SysInterfaceCallMapper sysInterfaceCallMapper;

    @Override
    public List<SysInterfaceCall> getInterfaceCallData(SysInterfaceCallQueryDTO interfaceCallQuery) {
        return null;
    }
}
