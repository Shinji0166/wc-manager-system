package cn.com.wudskq.service.impl;

import cn.com.wudskq.mapper.SysInterfaceCallMapper;
import cn.com.wudskq.model.query.SysInterfaceCallQueryDTO;
import cn.com.wudskq.model.vo.InterfaceCallVo;
import cn.com.wudskq.service.SysInterfaceCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<InterfaceCallVo> getInterfaceCallData(SysInterfaceCallQueryDTO interfaceCallQuery) {
        List<InterfaceCallVo> result = new ArrayList<>();
        //分组后的接口数据
        List<String> interfaceNameList  = sysInterfaceCallMapper.getInterfaceNameByGroup(interfaceCallQuery);
        interfaceNameList.forEach(value->{
            //通过分组的接口名称查询调用数据
             InterfaceCallVo interfaceCallVo = sysInterfaceCallMapper.getInterfaceCallData(value,interfaceCallQuery);
             interfaceCallVo.setInterfaceName(value);
             result.add(interfaceCallVo);
        });
        return  result;
    }
}
