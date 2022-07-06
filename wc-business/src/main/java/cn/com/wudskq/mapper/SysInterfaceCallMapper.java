package cn.com.wudskq.mapper;

import cn.com.wudskq.model.SysInterfaceCall;
import cn.com.wudskq.model.query.SysInterfaceCallQueryDTO;
import cn.com.wudskq.model.vo.InterfaceCallVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author chenfangchao
 * @title: SysInterfaceCallMapper
 * @projectName wc-manager-system
 * @description: TODO 接口调用次数
 * @date 2022/7/5 2:51 PM
 */
public interface SysInterfaceCallMapper extends BaseMapper<SysInterfaceCall> {

    /**
     * 获取接口调用次数折线,饼状图数据
     * @param interfaceName
     * @return
     */
    InterfaceCallVo getInterfaceCallData(@Param("interfaceName") String interfaceName);

    /**
     * 获取分组后的接口数据
     * @param interfaceCallQuery
     * @return
     */
    List<String> getInterfaceNameByGroup(@Param("query")SysInterfaceCallQueryDTO interfaceCallQuery);
}
