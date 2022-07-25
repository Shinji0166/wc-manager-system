package cn.com.wudskq.handler;

import cn.com.wudskq.model.SysUserDetails;
import cn.com.wudskq.web.UserDetailsServiceImpl;
import cn.com.wudskq.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


/**
 * @author wudskq
 */
@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
 
    /**
     * 身份验证
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取用户名
        String username = (String) authentication.getPrincipal();
        // 获取密码
        String password = (String) authentication.getCredentials();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new UsernameNotFoundException("用户名或密码不能为空");
        }
        SysUserDetails sysUserDetails = (SysUserDetails) userDetailsService.loadUserByUsername(username);
        if (sysUserDetails == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        if(!sysUserDetails.getPassword().equals(Md5Util.MD5(password))){
            throw new BadCredentialsException("用户名或密码错误");
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuthentication = new UsernamePasswordAuthenticationToken(sysUserDetails, sysUserDetails.getId(), sysUserDetails.getAuthorities());
        return usernamePasswordAuthentication;
    }
 
    /**
     * 支持指定的身份验证
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
 
}