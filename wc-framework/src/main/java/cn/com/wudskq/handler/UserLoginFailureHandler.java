package cn.com.wudskq.handler;

import cn.com.wudskq.vo.Response;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserLoginFailureHandler implements AuthenticationFailureHandler {
 
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) {
        Response.responseJson(response, Response.response(500, "登录失败", exception.getMessage()));
    }
}
