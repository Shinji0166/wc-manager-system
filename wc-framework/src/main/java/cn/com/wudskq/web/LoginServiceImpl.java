package cn.com.wudskq.web;

import cn.com.wudskq.model.common.LoginDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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


    @Override
    public String doLogin(LoginDTO login) {
        // 用户验证
        // 该方法会去调用SpringSecurity配置的登录认证处理类
        Authentication authentication  = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getUsername(),login.getPassword()));
        return String.valueOf(authentication.getDetails());
    }
}
