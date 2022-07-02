package cn.com.wudskq.filter;


import cn.com.wudskq.config.JWTConfig;
import cn.com.wudskq.model.SysUserDetails;
import cn.com.wudskq.utils.JWTTokenUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author wudskq
 */
public class JWTAuthenticationFilter extends BasicAuthenticationFilter {
 
    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }
 
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        // 取出Token
        String token = request.getHeader(JWTConfig.tokenHeader);
        // 截取Token有效部分
        if (token != null && token.startsWith(JWTConfig.tokenPrefix)) {
            SysUserDetails sysUserDetails = JWTTokenUtil.parseAccessToken(token);
            if (sysUserDetails != null) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        sysUserDetails, sysUserDetails.getId(), sysUserDetails.getAuthorities());
                // 将Authentication对象（用户信息、已认证状态、权限信息）存入 SecurityContextHolder
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        //放行
        filterChain.doFilter(request, response);
    }
 
}

