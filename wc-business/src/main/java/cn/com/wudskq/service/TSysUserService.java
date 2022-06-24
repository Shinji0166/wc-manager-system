package cn.com.wudskq.service;

import cn.com.wudskq.model.TSysUser;
import cn.com.wudskq.model.query.UserInfoQueryDTO;

import java.util.List;

public interface TSysUserService {

    /**
     * 根据账号查询用户是否存在
     * @param username
     * @return
     */
    TSysUser findByUsername(String username);

    /**
     * 获取用户信息列表
     * @param userInfoQuery
     * @return
     */
    List<TSysUser> getUserInfoList(UserInfoQueryDTO userInfoQuery);


    /**
     * 获取用户详情信息
     * @param id
     * @return
     */
    TSysUser getUserDetail(String id);
}

