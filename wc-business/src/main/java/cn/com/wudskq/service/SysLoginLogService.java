package cn.com.wudskq.service;

import cn.com.wudskq.model.SysLoginLog;
import cn.com.wudskq.model.query.LoginLogQueryDTO;

import java.util.List;

/**
 * @author chenfangchao
 * @title: SysLoginLogService
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/7/2 4:33 PM
 */
public interface SysLoginLogService {

    /**
     * 获取系统登录日志信息列表
     * @param loginLogQuery
     * @return
     */
    List<SysLoginLog> getLoginLogList(LoginLogQueryDTO loginLogQuery);

    /**
     * 获取登录日志详情
     * @param id
     * @return
     */
    SysLoginLog getLoginLogDetail(Long id);


    /**
     *  新增系统登录日志
     * @param sysLoginLog
     */
    public void saveSysLoginLog(SysLoginLog sysLoginLog);
}

