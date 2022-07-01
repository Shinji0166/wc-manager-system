package cn.com.wudskq.service.impl;

import cn.com.wudskq.mapper.SysOperatorLogMapper;
import cn.com.wudskq.model.SysOperatorLog;
import cn.com.wudskq.model.query.OperatorQueryDTO;
import cn.com.wudskq.service.SysOperatorLogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenfangchao
 * @title: SysOperatorLogServiceImpl
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/7/1 8:45 PM
 */
@Service
public class SysOperatorLogServiceImpl implements SysOperatorLogService {


    @Autowired
    private SysOperatorLogMapper sysOperatorLogMapper;

    @Override
    public List<SysOperatorLog> getOperatorLogList(OperatorQueryDTO operatorQuery) {
        PageHelper.startPage(operatorQuery.getPageNum(),operatorQuery.getPageSize());
        return sysOperatorLogMapper.getOperatorLogList(operatorQuery);
    }
}
