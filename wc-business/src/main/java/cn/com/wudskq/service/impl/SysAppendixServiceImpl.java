package cn.com.wudskq.service.impl;

import cn.com.wudskq.mapper.SysAppendixMapper;
import cn.com.wudskq.model.SysAppendix;
import cn.com.wudskq.service.SysAppendixService;
import cn.com.wudskq.utils.AliYunOSSUtil;
import cn.com.wudskq.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * @author chenfangchao
 * @title: SysAppendixServiceImpl
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/7/10 3:41 PM
 */
@Service
public class SysAppendixServiceImpl implements SysAppendixService {

    @Autowired
    private SysAppendixMapper sysAppendixMapper;

    @Autowired
    private AliYunOSSUtil aliYunOSSUtil;

    @Override
    public List<SysAppendix> getSysAppendixList(){
       return sysAppendixMapper.getSysAppendixList();
    }

    @Override
    public SysAppendix getSysAppendixDetail() {
        return sysAppendixMapper.getSysAppendixDetail();
    }

    @Override
    public SysAppendix uploadFile(MultipartFile multipartFile,Integer dataSource) {
        SysAppendix sysAppendix = new SysAppendix();
        File file = FileUtil.multipartFileToFile(multipartFile);
        //上传到OSS
        String accessUrl = aliYunOSSUtil.uploadFile(file, file.getName());
        //封装附件表数据
        sysAppendix.setName(file.getName());
        sysAppendix.setUrl(accessUrl);
        sysAppendix.setDataSource(dataSource);
        sysAppendixMapper.insert(sysAppendix);
        return sysAppendix;
    }

    @Override
    public SysAppendix queryFile(String id) {
        return sysAppendixMapper.selectById(id);
    }
}
