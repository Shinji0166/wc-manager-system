package cn.com.wudskq.service;

import cn.com.wudskq.model.SysInterfaceCall;
import cn.com.wudskq.model.query.SysInterfaceCallQueryDTO;

import java.util.List;

/**
 * @author chenfangchao
 * @title: SysInterfaceCallService
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/7/6 1:04 AM
 */
public interface SysInterfaceCallService {

    /**
     * 接口调用折线图
     * @param interfaceCallQuery
     * @return
     */
    List<SysInterfaceCall> getInterfaceCallData(SysInterfaceCallQueryDTO interfaceCallQuery);
}
