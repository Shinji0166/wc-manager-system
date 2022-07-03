package cn.com.wudskq.web;

import cn.com.wudskq.constants.SystemConstants;
import cn.com.wudskq.handler.UserLoginFailureHandler;
import cn.com.wudskq.handler.UserLoginSuccessHandler;
import cn.com.wudskq.handler.UserLogoutSuccessHandler;
import cn.com.wudskq.model.SysOnlineUser;
import cn.com.wudskq.model.common.LoginDTO;
import cn.com.wudskq.utils.RedisUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    //redis工具类
    @Resource
    private RedisUtil redisUtil;

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
            request.setAttribute("username",login.getUsername());
            loginFailureHandler.onAuthenticationFailure(request,response,e);
        }
    }

    @Override
    public void doLogout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logoutSuccessHandler.onLogoutSuccess(request,response,authentication);

    }

    @Override
    public void doForceLogout(String sessionId) {
        //获取总数
        Integer zSetSize = redisUtil.getZSetSize(SystemConstants.OLINE_USER_KEY);
        Set<Object> result =redisUtil.rangeByLimit(SystemConstants.OLINE_USER_KEY,1,zSetSize);
        //删除原来的在线用户列表
        redisUtil.remove(SystemConstants.OLINE_USER_KEY);
        //当前在线用户列表
        List<SysOnlineUser> collect = result.stream().map(SysOnlineUser::new).collect(Collectors.toList());
        collect.forEach(obj ->{
            boolean equals = obj.getJti().equals(sessionId);
            if(equals){
                //jwt设置为失效
                obj.setStatus(1);
            }
            //重新添加在线用户列表
            redisUtil.zAdd(SystemConstants.OLINE_USER_KEY,obj,obj.getLoginTime().getTime());
        });

    }
}
