package cn.com.wudskq.mapper;

import cn.com.wudskq.model.SysOperatorLog;
import cn.com.wudskq.model.query.OperatorQueryDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenfangchao
 * @title: SysOperatorLogMapper
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/7/1 8:43 PM
 */
public interface SysOperatorLogMapper extends BaseMapper<SysOperatorLog> {

    /**
     * 获取系统操作日志
     * @param operatorQuery
     * @return
     */
    List<SysOperatorLog> getOperatorLogList(@Param("query") OperatorQueryDTO operatorQuery);
}
