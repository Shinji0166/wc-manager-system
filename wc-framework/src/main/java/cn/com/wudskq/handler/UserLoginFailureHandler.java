package cn.com.wudskq.handler;

import cn.com.wudskq.mapper.TSysUserMapper;
import cn.com.wudskq.model.SysLoginLog;
import cn.com.wudskq.model.TSysUser;
import cn.com.wudskq.service.SysLoginLogService;
import cn.com.wudskq.vo.Response;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import nl.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author wudskq
 */
@Component
public class UserLoginFailureHandler implements AuthenticationFailureHandler {

    @Autowired
    private SysLoginLogService sysLoginLogService;

    @Autowired
    private TSysUserMapper tSysUserMapper;
 
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) {
        handleLoginLog(request,exception);
        Response.responseJson(response, Response.response(500, "登录失败", exception.getMessage()));
    }

    //处理登录日志数据
    public void handleLoginLog(HttpServletRequest request,AuthenticationException exception){
        //获取浏览器信息
        String ua = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(ua);

        //获取登录用户
        String username = (String) request.getAttribute("username");
        QueryWrapper<TSysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",username).eq("status",0);
        TSysUser loginUser = tSysUserMapper.selectOne(queryWrapper);

        //封装数据
        SysLoginLog sysLoginLog = new SysLoginLog();
        //判断是否存在该该用户
        if(null != loginUser){
            sysLoginLog.setCreateBy(loginUser.getNickName());
            sysLoginLog.setFailureReason(exception.getMessage());
        }else {
            sysLoginLog.setCreateBy("该条数据为系统创建");
            sysLoginLog.setFailureReason("系统中不存在该账户");
        }
        sysLoginLog.setBrowserName(userAgent.getBrowser().getName());
        sysLoginLog.setBrowserVersion(String.valueOf(userAgent.getBrowserVersion()));
        sysLoginLog.setOperatorSystem(userAgent.getOperatingSystem().getName());
        sysLoginLog.setResult("登录失败");
        sysLoginLogService.saveSysLoginLog(sysLoginLog);
    }
}
