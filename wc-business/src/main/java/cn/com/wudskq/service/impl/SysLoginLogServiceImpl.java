package cn.com.wudskq.service.impl;

import cn.com.wudskq.mapper.SysLoginLogMapper;
import cn.com.wudskq.model.SysLoginLog;
import cn.com.wudskq.model.query.LoginLogQueryDTO;
import cn.com.wudskq.service.SysLoginLogService;
import cn.com.wudskq.utils.JWTTokenUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenfangchao
 * @title: SysLoginLogServiceImpl
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/7/2 4:33 PM
 */
@Service
public class SysLoginLogServiceImpl implements SysLoginLogService {

    @Autowired
    private SysLoginLogMapper sysLoginLogMapper;

    @Override
    public List<SysLoginLog> getLoginLogList(LoginLogQueryDTO loginLogQuery) {
        String tenantCode = JWTTokenUtil.getCurrentLoginUserTenantCode();
        PageHelper.startPage(loginLogQuery.getPageNum(),loginLogQuery.getPageSize());
        return sysLoginLogMapper.getLoginLogList(loginLogQuery,tenantCode);
    }

    @Override
    public SysLoginLog getLoginLogDetail(Long id) {
        return sysLoginLogMapper.getLoginLogDetail(id);
    }


    /**
     * 新增系统登录日志
     * @param sysLoginLog
     */
    @Override
    public void saveSysLoginLog(SysLoginLog sysLoginLog){
        sysLoginLogMapper.insert(sysLoginLog);
    }

}
