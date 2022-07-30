package cn.com.wudskq.mapper;

import cn.com.wudskq.model.SysLoginLog;
import cn.com.wudskq.model.query.LoginLogQueryDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenfangchao
 * @title: SysLoginLogMapper
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/7/2 4:28 PM
 */
public interface SysLoginLogMapper extends BaseMapper<SysLoginLog> {

    /**
     * 获取系统登录日志列表
     * @param loginLogQuery
     * @param tenantCode
     * @return
     */
    List<SysLoginLog> getLoginLogList(@Param("query") LoginLogQueryDTO loginLogQuery,@Param("tenantCode") String tenantCode);

    /**
     * 获取系统登录日志详情
     * @param id
     * @return
     */
    SysLoginLog getLoginLogDetail(@Param("id") Long id);
}
