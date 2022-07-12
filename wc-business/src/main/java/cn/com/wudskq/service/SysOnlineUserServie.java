package cn.com.wudskq.service;

import cn.com.wudskq.model.query.SysOnlineUserQueryDTO;
import java.util.Map;

/**
 * @author chenfangchao
 * @title: SysOnlineUserServie
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/7/3 1:07 AM
 */
public interface SysOnlineUserServie {

    /**
     * 获取系统在线用户列表
     * @param sysOnlineUserQuery
     * @return
     */
    Map<String,Object> getSysOnlineUserList(SysOnlineUserQueryDTO sysOnlineUserQuery);
}
