package cn.com.wudskq.aspectj;

import cn.com.wudskq.annotation.OperatorLog;
import cn.com.wudskq.config.JWTConfig;
import cn.com.wudskq.model.SysUserDetails;
import cn.com.wudskq.util.JWTTokenUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenfangchao
 * @title: OperatorLogAspect
 * @projectName wc-manager-system
 * @description: TODO 系统操作日志处理
 * @date 2022/7/1 4:50 PM
 */
@Aspect
@Component
public class OperatorLogAspect {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("@annotation(cn.com.wudskq.annotation.OperatorLog)"
            + "|| @within(cn.com.wudskq.annotation.OperatorLog)")
    public void dsPointCut()
    {

    }

    @Around("dsPointCut() && @annotation(operatorLog)")
    public Object around(ProceedingJoinPoint point, OperatorLog operatorLog) throws Throwable
    {
        //获取HttpRequest
        ServletRequestAttributes attributes  = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //获取当前操作的用户token
        String token = request.getHeader(JWTConfig.tokenHeader);
        if(null != token){
            //解析token
            SysUserDetails sysUserDetails = JWTTokenUtil.parseAccessToken(token);
            logger.info(sysUserDetails.toString());
            System.out.println(operatorLog.toString());
        }
        return point.proceed();
    }
}
