package cn.com.wudskq.web;

import cn.com.wudskq.model.common.LoginDTO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chenfangchao
 * @title: LoginService
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/23 4:06 PM
 */
@Service
public interface LoginService {


    /**
     * 执行登录接口
     * @param login
     * @param request
     * @param response
     */
    void doLogin(LoginDTO login, HttpServletRequest request, HttpServletResponse response);

    /**
     * 执行登出操作
     * @param request
     * @param response
     */
    void doLogout(HttpServletRequest request, HttpServletResponse response);
}
