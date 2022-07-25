package cn.com.wudskq.service;

import cn.com.wudskq.model.TSysUser;
import cn.com.wudskq.model.query.UserInfoQueryDTO;
import cn.com.wudskq.vo.Response;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author wudskq
 */
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
    TSysUser getUserDetail(Long id);

    /**
     * 保存用户信息
     * @param sysUser
     */
    Response saveUser(TSysUser sysUser);

    /**
     * 更新用户信息
     * @param sysUser
     */
    Response updateUser(TSysUser sysUser);


    /**
     * 删除用户信息
     * @param ids
     */
    void removeUser(List<String> ids);
}

