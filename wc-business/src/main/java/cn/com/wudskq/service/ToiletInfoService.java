package cn.com.wudskq.service;

import cn.com.wudskq.model.ToiletInfo;
import cn.com.wudskq.model.query.ToiletInfoQueryDTO;

import java.util.List;

/**
 * @author chenfangchao
 * @title: ToiletInfoService
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/28 2:56 AM
 */
public interface ToiletInfoService {

    /**
     * 获取公厕信息列表
     * @param toiletInfoQuery
     * @return
     */
    List<ToiletInfo> getToiletList(ToiletInfoQueryDTO toiletInfoQuery);

    /**
     * 获取公厕详细信息
     * @param id
     * @return
     */
    ToiletInfo getToiletDetail(Long id);

    /**
     * 新增公厕信息
     * @param toiletInfo
     */
    void saveToilet(ToiletInfo toiletInfo);

    /**
     * 更新公厕信息
     * @param toiletInfo
     */
    void updateToilet(ToiletInfo toiletInfo);

    /**
     * 删除公厕信息
     * @param ids
     */
    void removeToilet(List<Long> ids);
}
