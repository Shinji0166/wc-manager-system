package cn.com.wudskq.service;

import cn.com.wudskq.model.SysOperatorLog;
import cn.com.wudskq.model.query.OperatorQueryDTO;

import java.util.List;

/**
 * @author chenfangchao
 * @title: SysOperatorLogService
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/7/1 8:44 PM
 */
public interface SysOperatorLogService {

    /**
     * 查询系统操作日志
     * @param operatorQuery
     * @return
     */
    List<SysOperatorLog> getOperatorLogList(OperatorQueryDTO operatorQuery);
}
