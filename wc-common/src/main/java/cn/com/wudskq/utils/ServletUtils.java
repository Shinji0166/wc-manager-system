package cn.com.wudskq.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenfangchao
 * @title: ServletUtil
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/7/29 11:22 PM
 */
public class ServletUtils {

    /**
     * 获取请求的URI
     * @return
     */
    public static String getRequestURI(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String requestURI = request.getRequestURI();
        return requestURI;
    }
}
