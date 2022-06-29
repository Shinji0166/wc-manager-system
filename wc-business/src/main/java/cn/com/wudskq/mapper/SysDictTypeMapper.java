package cn.com.wudskq.mapper;

import cn.com.wudskq.model.SysDictType;
import cn.com.wudskq.model.query.SysDictQueryDTO;
import cn.com.wudskq.model.vo.SysDictVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenfangchao
 * @title: SysDictTypeMapper
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/28 5:13 PM
 */
public interface SysDictTypeMapper extends BaseMapper<SysDictType> {

    /**
     * 删除字典类型数据(逻辑删除）
     * @param ids
     */
    void removeDictType(@Param("ids") List<Long> ids);

    /**
     * 查询字典顶级节点下属数据
     * @param sysDictQuery
     * @return
     */
    List<SysDictVo> getDictTypeTopData(@Param("query") SysDictQueryDTO sysDictQuery);

    /**
     * 查询字典类型信息详情
     * @param id
     * @return
     */
    SysDictVo getDictTypeDetail(@Param("id") Long id);
}
