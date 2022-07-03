package cn.com.wudskq.handler;

import cn.com.wudskq.config.JWTConfig;
import cn.com.wudskq.constants.SystemConstants;
import cn.com.wudskq.model.SysOnlineUser;
import cn.com.wudskq.model.SysUserDetails;
import cn.com.wudskq.utils.JWTTokenUtil;
import cn.com.wudskq.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wudskq
 */
@Component
public class UserLogoutSuccessHandler implements LogoutSuccessHandler {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
    {
        try {
            SecurityContextHolder.clearContext();
            // 取出Token
            String token = request.getHeader(JWTConfig.tokenHeader);
            // 截取Token有效部分
            if (token != null && token.startsWith(JWTConfig.tokenPrefix)) {
                SysUserDetails sysUserDetails = JWTTokenUtil.parseAccessToken(token);
                if (sysUserDetails != null) {
                    String jti = sysUserDetails.getJti();
                    //获取总数
                    Integer zSetSize = redisUtil.getZSetSize(SystemConstants.OLINE_USER_KEY);
                    Set<Object> result =redisUtil.rangeByLimit(SystemConstants.OLINE_USER_KEY,1,zSetSize);
                    //删除原来的在线用户列表
                    redisUtil.remove(SystemConstants.OLINE_USER_KEY);
                    //当前在线用户列表
                    List<SysOnlineUser> collect = result.stream().map(SysOnlineUser::new).collect(Collectors.toList());
                    collect.forEach(obj ->{
                        boolean equals = obj.getJti().equals(jti);
                        if(equals){
                            //jwt设置为失效
                            obj.setStatus(1);
                        }
                        //重新添加在线用户列表
                        redisUtil.zAdd(SystemConstants.OLINE_USER_KEY,obj,obj.getLoginTime().getTime());
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}