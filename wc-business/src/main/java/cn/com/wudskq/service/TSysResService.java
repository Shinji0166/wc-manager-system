package cn.com.wudskq.service;

import cn.com.wudskq.model.TSysRes;
import cn.com.wudskq.model.TSysRole;
import cn.com.wudskq.model.query.ResInfoQueryDTO;

import java.util.List;

/**
 * @author wudskq
 */
public interface TSysResService {
 
    List<TSysRes> findResByUserId(String userId);

    /**
     * 获取资源/菜单信息列表
     * @param resInfoQuery
     * @return
     */
    List<TSysRes> getResLIst(ResInfoQueryDTO resInfoQuery);

    /**
     * 获取资源/菜单详细信息
     * @param id
     * @return
     */
    TSysRes getResDetail(Long id);

    /**
     * 新增资源/菜单信息
     * @param sysRes
     */
    void saveRes(TSysRes sysRes);

    /**
     * 更新资源/菜单信息
     * @param sysRes
     */
    void updateRes(TSysRes sysRes);

    /**
     * 删除资源/菜单信息(逻辑删除)
     * @param ids
     */
    void removeRes(List<Long> ids);
}

