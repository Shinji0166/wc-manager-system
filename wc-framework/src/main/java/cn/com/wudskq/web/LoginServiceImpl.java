package cn.com.wudskq.web;

import cn.com.wudskq.handler.UserLoginFailureHandler;
import cn.com.wudskq.handler.UserLoginSuccessHandler;
import cn.com.wudskq.handler.UserLogoutSuccessHandler;
import cn.com.wudskq.model.common.LoginDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chenfangchao
 * @title: LoginServiceImpl
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/23 4:06 PM
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private AuthenticationManager authenticationManager;

    //登录成功处理器
    @Resource
    private UserLoginSuccessHandler loginSuccessHandler;

    //登录失败处理器
    @Resource
    private UserLoginFailureHandler loginFailureHandler;

    //登出处理器
    @Resource
    private UserLogoutSuccessHandler logoutSuccessHandler;

    @Override
    public void doLogin(LoginDTO login, HttpServletRequest request, HttpServletResponse response) {
        // 用户验证
        try {
            // 该方法会去调用SpringSecurity配置的登录认证处理类
            Authentication authentication  = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(login.getUsername(),login.getPassword()));
            //认证成功
            loginSuccessHandler.onAuthenticationSuccess(request,response,authentication);
        } catch (AuthenticationException e) {
            //认证失败
            loginFailureHandler.onAuthenticationFailure(request,response,e);
        }
    }

    @Override
    public void doLogout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logoutSuccessHandler.onLogoutSuccess(request,response,authentication);

    }
}
