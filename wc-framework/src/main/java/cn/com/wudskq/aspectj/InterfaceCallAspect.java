package cn.com.wudskq.aspectj;

import cn.com.wudskq.annotation.InterfaceCall;
import cn.com.wudskq.atomic.AtomicCounter;
import cn.com.wudskq.constants.SystemConstants;
import cn.com.wudskq.expection.GlobalExceptionHandler;
import cn.com.wudskq.model.SysInterfaceCall;
import cn.com.wudskq.utils.IPUtil;
import cn.com.wudskq.utils.JWTTokenUtil;
import cn.com.wudskq.utils.RedisUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chenfangchao
 * @title: InterfaceCallAspect
 * @projectName wc-manager-system
 * @description: TODO 接口调用次数处理(AOP)
 * @date 2022/7/4 1:04 AM
 */
@Aspect
@Component
public class InterfaceCallAspect {

    private static final Logger log = LoggerFactory.getLogger(InterfaceCallAspect.class);

    @Autowired
    private  RedisUtil redisUtil;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    //全局异常处理
    @Resource
    private GlobalExceptionHandler globalExceptionHandler;

    //本地线程
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    //计数并发Map
    ConcurrentHashMap<String, SysInterfaceCall> countMap = new ConcurrentHashMap<String,SysInterfaceCall>();

    //接口统计次数模型
    private SysInterfaceCall sysInterfaceCall;

    /**
     * 开启监控
     */
    @Pointcut("@annotation(cn.com.wudskq.annotation.InterfaceCall)"
            + "|| @within(cn.com.wudskq.annotation.InterfaceCall)")
    private void controllerPt() {

    }


    //此处异常不可直接抛出,要捕获以判断方法是否执行成功后再抛出
    @Around("controllerPt() && @annotation(interfaceCall)")
    public Object around(ProceedingJoinPoint joinPoint,InterfaceCall interfaceCall) {
        //设置开启时间
        startTime.set(System.currentTimeMillis());
        //接口名称
        String interfaceName = interfaceCall.interfaceName();
        //请求方式
        String requestMode = interfaceCall.requestMode();

        // 请求次数计数器 执行成功则计数加一
        int increase = AtomicCounter.getInstance().increase();

        try {
            synchronized (this) {
                //在项目启动时，需要在Redis中读取原有的接口请求次数
                if (countMap.size() == 0) {
                    Map<String, SysInterfaceCall> interfaceCallMap = redisUtil.hGet(SystemConstants.INTERFACE_ACTUATOR_KEY);
                    if(!interfaceCallMap.isEmpty() && 0 < interfaceCallMap.size()){
                        for (Map.Entry<String, SysInterfaceCall> entry : interfaceCallMap.entrySet()) {
                            String key = entry.getKey();
                            SysInterfaceCall value = entry.getValue();
                            countMap.put(key,value);
                        }
                    }
                }
            }
            //封装数据
            sysInterfaceCall = handleInterfaceCall(joinPoint, interfaceCall);

            // 如果此次访问的接口不在countMap，则放入countMap
            countMap.putIfAbsent(sysInterfaceCall.getInterfaceName(), sysInterfaceCall);
            //正常接口
            countMap.compute(interfaceName, (key, value) -> {
                return value.setInterfaceCallSuccessCount(value.getInterfaceCallSuccessCount()+1);
            });
            return joinPoint.proceed();
        } catch (Throwable e) {
            //异常接口 fix(如果失败需要在成功调用数的上减去错误加的1)
            countMap.compute(interfaceName, (key, value) -> {
                //成功调用数-失败调用数
                value.setInterfaceCallSuccessCount(value.getInterfaceCallSuccessCount()-1);
                return value.setInterfaceCallFailCount(value.getInterfaceCallFailCount()+1);
            });
            return globalExceptionHandler.handle((Exception) e);
        } finally {
            //接口请求时间 毫秒
            long interfaceRequestTime = System.currentTimeMillis() - startTime.get();

            //更新对应接口请求时常  计算总时间,平均时间,最小时间,最大时间
            countMap.compute(interfaceName,(key, value)->{

                //调用次数加一
                value.setInterfaceCallCount(value.getInterfaceCallCount() + 1);
                value.setInterfaceCallTime(interfaceRequestTime);

                //假设接口单次回调时间为最小时间
                value.setInterfaceCallMinTime(interfaceRequestTime);

                if(value.getInterfaceCallMinTime() > interfaceRequestTime){
                   value.setInterfaceCallMinTime(interfaceRequestTime);
                }else if(value.getInterfaceCallMaxTime() < interfaceRequestTime){
                    value.setInterfaceCallMaxTime(interfaceRequestTime);
                }
                //接口总回调时间
                value.setInterfaceCallTotalTime(value.getInterfaceCallTotalTime()+interfaceRequestTime);
                return value;
            });
            synchronized (this) {
                // 内存计数达到6 更新redis
                if (increase == 6) {
                    //map存入到redis
                    redisUtil.hSet(SystemConstants.INTERFACE_ACTUATOR_KEY,countMap);
                    //删除过期时间
                    stringRedisTemplate.persist(SystemConstants.INTERFACE_ACTUATOR_KEY);

                    //计数器置为0
                    AtomicCounter.getInstance().toZero();
                }
            }
        }
    };


    /**
     * 封装接口请求次数数据
     * @param joinPoint
     * @param interfaceCall
     */
    private SysInterfaceCall handleInterfaceCall(JoinPoint joinPoint,InterfaceCall interfaceCall){
        try {
            String tenantCode = JWTTokenUtil.getCurrentLoginUserTenantCode();
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            Signature signature = joinPoint.getSignature();
            String declaringName = signature.getDeclaringTypeName();
            String methodName = signature.getName();
            //接口名称
            String interfaceName = interfaceCall.interfaceName();
            //请求方式
            String requestMode = interfaceCall.requestMode();
            SysInterfaceCall sysInterfaceCall = new SysInterfaceCall().setInterfaceName(interfaceName)
                    .setDeclaringName(declaringName)
                    .setMethodName(methodName)
                    .setRequestMode(requestMode)
                    .setRequestIp(IPUtil.getRemoteAddr(request));
            //注入多租户代码
            sysInterfaceCall.setTenantCode(tenantCode);
            return sysInterfaceCall;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
