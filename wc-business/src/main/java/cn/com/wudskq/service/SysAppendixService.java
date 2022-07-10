package cn.com.wudskq.service;

import cn.com.wudskq.model.SysAppendix;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author chenfangchao
 * @title: SysAppendixService
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/7/10 3:41 PM
 */
public interface SysAppendixService {

    /**
     * 根据ID及数据来源获取附件列表
     * @return
     */
    List<SysAppendix> getSysAppendixList();


    /**
     * 根据ID及数据来源获取附件信息
     * @return
     */
    SysAppendix getSysAppendixDetail();

    /**
     * 上传文件
     * @param multipartFile
     * @param dataSource
     * @return
     */
    SysAppendix uploadFile(MultipartFile multipartFile,Integer dataSource);

    /**
     * 根据附件ID查询附件
     * @param id
     * @return
     */
    SysAppendix queryFile(String id);
}
