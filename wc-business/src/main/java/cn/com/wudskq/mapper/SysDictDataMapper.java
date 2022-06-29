package cn.com.wudskq.mapper;

import cn.com.wudskq.model.SysDictData;
import cn.com.wudskq.model.query.SysDictQueryDTO;
import cn.com.wudskq.model.vo.SysDictVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenfangchao
 * @title: SysDictDataMapper
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/28 5:16 PM
 */
public interface SysDictDataMapper extends BaseMapper<SysDictData> {

    /**
     * 根据字典类型查询字典数据列表
     * @param sysDictQuery
     * @return
     */
    List<SysDictVo> getDictDataList(@Param("query") SysDictQueryDTO sysDictQuery);

    /**
     * 删除字典数据(逻辑删除)
     * @param ids
     */
    void removeDictData(@Param("ids") List<Long> ids);

    /**
     * 获取字典数据详情
     * @param id
     * @return
     */
    SysDictVo getDictDataDetail(@Param("id") Long id);
}
