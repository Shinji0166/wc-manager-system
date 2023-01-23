package cn.com.wudskq.filter;

import cn.com.wudskq.config.JWTConfig;
import cn.com.wudskq.constants.SystemConstants;
import cn.com.wudskq.expection.BusinessException;
import cn.com.wudskq.model.SysOnlineUser;
import cn.com.wudskq.model.SysUserDetails;
import cn.com.wudskq.service.TSysUserService;
import cn.com.wudskq.utils.JWTTokenUtil;
import cn.com.wudskq.utils.RedisUtil;
import cn.com.wudskq.utils.spring.SpringContextUtils;
import cn.com.wudskq.wapper.RequestWrapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wudskq
 */
@Component
public class JWTAuthenticationFilter extends BasicAuthenticationFilter {

 
    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        //请求参数对象
        ServletRequest requestWrapper = null;

        //得到RedisUtil对象
        RedisUtil redisUtil = SpringContextUtils.getBean("redisUtil");
        // 取出Token
        String token = request.getHeader(JWTConfig.tokenHeader);

        // 截取Token有效部分
        if (token != null && token.startsWith(JWTConfig.tokenPrefix))
        {
            SysUserDetails sysUserDetails = JWTTokenUtil.parseAccessToken(token);
            if (sysUserDetails != null) {
                //判断用户登录状态
                Integer zSetSize = redisUtil.getZSetSize(SystemConstants.OLINE_USER_KEY);
                Set<Object> result =redisUtil.rangeByLimit(SystemConstants.OLINE_USER_KEY,1,zSetSize);

                //当前在线用户列表
                List<SysOnlineUser> collect = result.stream().map(SysOnlineUser::new).collect(Collectors.toList());

                if(null != collect && 0 <collect.size())
                {
                    collect.forEach(obj -> {
                        if (sysUserDetails.getJti().equals(obj.getJti()) && obj.getStatus() == 1) {
                            throw new BusinessException(200, "当前登录状态已过期,请重新登录!");
                        }
                    });
                }
               UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(sysUserDetails, sysUserDetails.getId(), sysUserDetails.getAuthorities());
               // 将Authentication对象（用户信息、已认证状态、权限信息）存入 SecurityContextHolder
               SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        String requestURI = request.getRequestURI();
        //如果为登录操作则跳过以下逻辑
        if(!SystemConstants.SYSTEM_LOGIN_URI.equals(requestURI))
        {
            if(null != token && !"".equals(token)){
                //查询当前操作用户所拥有的系统多租户代码权限
                SysUserDetails sysUserDetails = JWTTokenUtil.parseAccessToken(token);
                //为admin时拥有最高权限
                if(!SystemConstants.SUPER_ADMINISTRATOR.equals(sysUserDetails.getUsername()))
                {
                    TSysUserService tSysUserServiceImpl = SpringContextUtils.getBean("TSysUserServiceImpl");
                    String tenantCodePermission = tSysUserServiceImpl.getTenantCodeByUserId(sysUserDetails.getId());
                    request.setAttribute(SystemConstants.TENANT_CODE_PERMISSION,tenantCodePermission);
                }
            }
        }
        // filter层封装传递post参数
        if(request instanceof HttpServletRequest)
        {
            requestWrapper = new RequestWrapper(request);
        }
        if(requestWrapper == null)
        {
            filterChain.doFilter(request, response);
        } else {
            filterChain.doFilter(requestWrapper, response);
        }
    }
 
}

