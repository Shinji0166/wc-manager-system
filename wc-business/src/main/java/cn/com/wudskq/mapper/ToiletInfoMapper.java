package cn.com.wudskq.mapper;

import cn.com.wudskq.model.ToiletInfo;
import cn.com.wudskq.model.query.ToiletInfoQueryDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenfangchao
 * @title: ToiletInfoMapper
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/28 2:56 AM
 */
public interface ToiletInfoMapper extends BaseMapper<ToiletInfo> {

    /**
     * 获取公厕信息列表
     * @param toiletInfoQuery
     * @return
     */
    List<ToiletInfo> getToiletList(@Param("query") ToiletInfoQueryDTO toiletInfoQuery);

    /**
     * 获取公厕详细信息
     * @param id
     * @return
     */
    ToiletInfo getToiletDetail(@Param("id") Long id);

    /**
     * 删除公厕信息(逻辑删除)
     * @param ids
     */
    void removeToilet(@Param("ids") List<Long> ids);
}
