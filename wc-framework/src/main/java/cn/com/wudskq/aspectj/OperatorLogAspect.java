package cn.com.wudskq.aspectj;

import cn.com.wudskq.annotation.OperatorLog;
import cn.com.wudskq.config.JWTConfig;
import cn.com.wudskq.expection.GlobalExceptionHandler;
import cn.com.wudskq.mapper.SysOperatorLogMapper;
import cn.com.wudskq.model.SysOperatorLog;
import cn.com.wudskq.model.SysUserDetails;
import cn.com.wudskq.model.TSysUser;
import cn.com.wudskq.snowflake.IdGeneratorSnowflake;
import cn.com.wudskq.utils.JWTTokenUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

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

    @Autowired
    private SysOperatorLogMapper sysOperatorLogMapper;

    //雪花ID
    @Autowired
    private IdGeneratorSnowflake idGeneratorSnowflake;

    //全局异常处理
    private GlobalExceptionHandler globalExceptionHandler;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("@annotation(cn.com.wudskq.annotation.OperatorLog)"
            + "|| @within(cn.com.wudskq.annotation.OperatorLog)")
    public void dsPointCut()
    {

    }

    //此处异常不可直接抛出,要捕获以判断方法是否执行成功后再抛出
    @Around("dsPointCut() && @annotation(operatorLog)")
    public Object around(ProceedingJoinPoint point, OperatorLog operatorLog)
    {
        SysOperatorLog sysOperatorLog = new SysOperatorLog();
        TSysUser tSysUser = new TSysUser();
        try {
            //获取HttpRequest
            ServletRequestAttributes attributes  = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            //获取当前操作的用户token
            String token = request.getHeader(JWTConfig.tokenHeader);
            if(null != token){
                //解析token
                SysUserDetails sysUserDetails = JWTTokenUtil.parseAccessToken(token);
                //是否为管理员,管理员直接跳过查询
                if(!"admin".equals(sysUserDetails.getUsername())){
                    //根据用户ID查询用户
                      tSysUser.setNickName(sysUserDetails.getNickName());
                }else {
                      tSysUser.setNickName("系统管理员");
                }
                sysOperatorLog = handleDataModule(operatorLog, tSysUser);
                //无异常代表请求成功
                sysOperatorLog.setResult("请求成功");
            }
            return point.proceed();
        } catch (Throwable e) {
            //异常代表请求失败
            sysOperatorLog.setResult("请求失败");
            sysOperatorLog.setFailureReason("异常:"+e + "异常位置:"+e.getStackTrace()[0].toString());
            return globalExceptionHandler.handle((Exception) e);
        }finally {
            //最后数据入库
            sysOperatorLogMapper.insert(sysOperatorLog);
        }
    }


    //封装系统操作数据
    public SysOperatorLog handleDataModule(OperatorLog operatorLog,TSysUser tSysUser){
        SysOperatorLog sysOperatorLog = new SysOperatorLog()
                .setId(idGeneratorSnowflake.snowflakeId())
                .setOperatorModule(operatorLog.module())
                .setOperatorFunction(operatorLog.function())
                .setOperatorAction(operatorLog.action())
                .setRequestMode(operatorLog.requestMode());
        if(null != tSysUser){
            sysOperatorLog.setCreateBy(tSysUser.getNickName());
        }
        sysOperatorLog.setCreateTime(new Date());
        return sysOperatorLog;
    }
}
