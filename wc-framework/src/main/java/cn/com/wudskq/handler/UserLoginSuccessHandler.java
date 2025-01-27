package cn.com.wudskq.handler;

import cn.com.wudskq.constants.SystemConstants;
import cn.com.wudskq.model.SysLoginLog;
import cn.com.wudskq.model.SysOnlineUser;
import cn.com.wudskq.model.SysUserDetails;
import cn.com.wudskq.service.SysLoginLogService;
import cn.com.wudskq.utils.IPUtil;
import cn.com.wudskq.utils.JWTTokenUtil;
import cn.com.wudskq.utils.RedisUtil;
import cn.com.wudskq.vo.Response;
import nl.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;

/**
 * @author wudskq
 */
@Component
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private SysLoginLogService sysLoginLogService;

 
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) {
        SysUserDetails sysUserDetails = (SysUserDetails) authentication.getPrincipal();
        //创建token
        String token = JWTTokenUtil.createAccessToken(sysUserDetails);

        //存储redis一份,实现在线用户注销强退等功能
        handleOnlineUser(token);

        //新增登录日志
        handleLoginLog(token);
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("token",token);

        //处理敏感信息
        SysUserDetails sysUserDetailsResult = handleSensitiveData(sysUserDetails);

        resultMap.put("userInfo",sysUserDetailsResult);
        Response.responseJson(response, Response.response(200, "登录成功", resultMap));
    }

    //封装在线用户信息
    public void  handleOnlineUser(String token){
        //获取HttpRequest
        ServletRequestAttributes attributes  = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //认证成功后存储到redis 再解析token
        SysUserDetails loginUser = JWTTokenUtil.parseAccessToken(token);

        //获取浏览器信息
        String ua = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(ua);

        //在线用户信息
        SysOnlineUser sysOnlineUser = new SysOnlineUser();
        sysOnlineUser.setId(loginUser.getId()).setNickName(loginUser.getNickName())
                .setJti(loginUser.getJti())
                .setBrowserName(userAgent.getBrowser().getName())
                .setBrowserVersion(String.valueOf(userAgent.getBrowserVersion()))
                .setOperatorSystem(userAgent.getOperatingSystem().getName())
                .setLoginIp(IPUtil.getRemoteAddr(request))
                .setLoginTime(new Date())
                .setTenantCode(loginUser.getTenantCode()) //系统多租户代码
                .setExpirationTime(loginUser.getExpirationTime());
        //存入redis,zset集合中
        redisUtil.zAdd(SystemConstants.OLINE_USER_KEY,sysOnlineUser,sysOnlineUser.getLoginTime().getTime());
    }

    //处理登录日志数据
    public void handleLoginLog(String token){
        //获取HttpRequest
        ServletRequestAttributes attributes  = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //认证成功后存储到redis 再解析token
        SysUserDetails loginUser = JWTTokenUtil.parseAccessToken(token);

        //获取浏览器信息
        String ua = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(ua);

        //封装数据
        SysLoginLog sysLoginLog = new SysLoginLog();
        sysLoginLog.setCreateBy(loginUser.getNickName());
        sysLoginLog.setRequestIp(IPUtil.getRemoteAddr(request));
        sysLoginLog.setBrowserName(userAgent.getBrowser().getName());
        sysLoginLog.setBrowserVersion(String.valueOf(userAgent.getBrowserVersion()));
        sysLoginLog.setOperatorSystem(userAgent.getOperatingSystem().getName());
        sysLoginLog.setTenantCode(loginUser.getTenantCode()); //系统多租户代码
        sysLoginLog.setResult("登录成功");
        sysLoginLogService.saveSysLoginLog(sysLoginLog);
    }

    /**
     * 处理敏感数据
     * @param sysUserDetails
     * @return
     */
    private SysUserDetails  handleSensitiveData(SysUserDetails sysUserDetails){
        //账号及密码
        sysUserDetails.setUsername(null);sysUserDetails.setUserName(null);
        sysUserDetails.setPassword(null);sysUserDetails.setPassWord(null);

        //性别 电话号码
        sysUserDetails.setSex(null); sysUserDetails.setCellPhone(null);
        sysUserDetails.setCreateBy(null); sysUserDetails.setCreateTime(null);
        sysUserDetails.setUpdateBy(null); sysUserDetails.setUpdateTime(null);

        //后台权限代码(敏感信息)设置为空
        sysUserDetails.setAuthorities(null);

        sysUserDetails.setCurrentUserId(String.valueOf(sysUserDetails.getId()));
        return sysUserDetails;
    }
}