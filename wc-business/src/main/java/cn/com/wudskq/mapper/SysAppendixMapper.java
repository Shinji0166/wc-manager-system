package cn.com.wudskq.mapper;

import cn.com.wudskq.model.SysAppendix;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author chenfangchao
 * @title: SysAppendixMapper
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/7/10 3:28 PM
 */
public interface SysAppendixMapper extends BaseMapper<SysAppendix> {

    /**
     * 根据ID及数据来源获取附件列表
     * @return
     */
    List<SysAppendix> getSysAppendixList();


    /**
     * 根据ID及数据来源获取附件
     * @return
     */
    SysAppendix getSysAppendixDetail();
}
