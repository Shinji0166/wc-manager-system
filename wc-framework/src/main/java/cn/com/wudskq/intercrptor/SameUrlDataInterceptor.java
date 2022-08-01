package cn.com.wudskq.intercrptor;

import cn.com.wudskq.annotation.ProhibitResubmit;
import cn.com.wudskq.config.JWTConfig;
import cn.com.wudskq.utils.ServletUtils;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author chenfangchao
 * @title: SameUrlDataInterceptor
 * @projectName wc-manager-system
 * @description: TODO 防止重复提交拦截器
 * @date 2022/7/23 9:01 PM
 */
@Component
public class SameUrlDataInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    /**
     * 是否阻止提交,false阻止,true放行
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            ProhibitResubmit annotation = method.getAnnotation(ProhibitResubmit.class);
            if (annotation != null) {
                if(repeatDataValidator(request)){
                    //请求数据相同
                    logger.warn("please don't repeat submit,url:"+ request.getServletPath());
                    JSONObject result = new JSONObject();
                    result.put("statusCode","500");
                    result.put("message","请勿重复请求");
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("application/json; charset=utf-8");
                    response.getWriter().write(result.toString());
                    response.getWriter().close();
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * 验证同一个url数据是否相同提交,相同返回true
     * @param httpServletRequest
     * @return
     */
    public boolean repeatDataValidator(HttpServletRequest httpServletRequest){
        //获取请求参数map
        String bodyParams = ServletUtils.getRequestBodyParams(httpServletRequest);
        //token
        String token = httpServletRequest.getHeader(JWTConfig.tokenHeader);
        //请求URI
        String url = httpServletRequest.getRequestURI();
        Map<String,String> map = new HashMap<>(10);
        //key为接口，value为参数
        map.put(url, bodyParams);
        //当前的参数
        String nowUrlParams = map.toString();
        //key
        String redisKey = url+"::"+token;
        String preUrlParams = stringRedisTemplate.opsForValue().get(redisKey);
        //如果上一个数据为null,表示还没有访问页面
        if(preUrlParams == null)
        {
            //存放并且设置有效期，6秒
            stringRedisTemplate.opsForValue().set(redisKey, nowUrlParams, 6, TimeUnit.SECONDS);
            return false;
        }else
        {
            // 如果上次url+数据和本次url+数据相同，则表示重复添加数据
            if(preUrlParams.equals(nowUrlParams)){
                return true;
            }else{
                //如果上次 url+数据 和本次url加数据不同，则不是重复提交
                stringRedisTemplate.opsForValue().set(redisKey, nowUrlParams, 6, TimeUnit.SECONDS);
                return false;
            }
        }
    }
}
