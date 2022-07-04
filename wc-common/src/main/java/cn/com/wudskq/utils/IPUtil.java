package cn.com.wudskq.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * @author chenfangchao
 * @title: IpUtils
 * @projectName wc-manager-system
 * @description: TODO 获取真实IP工具类
 * @date 2022/7/4 5:37 PM
 */
public class IPUtil {

    private static final String[] ADDR_HEADER = { "X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP",
            "X-Real-IP" };
    private static final String NUKNOWN = "unknown";


    /**
     * 获得真实IP地址。
     * 在使用了反向代理时，直接用HttpServletRequest.getRemoteAddr()无法获取客户真实的IP地址。
     * @param request
     * @return
     */
    public static String getRemoteAddr(ServletRequest request) {
        String addr = null;
        if (request instanceof HttpServletRequest) {
            HttpServletRequest hsr = (HttpServletRequest) request;
            for (String header : ADDR_HEADER) {
                if (StringUtils.isBlank(addr) || NUKNOWN.equalsIgnoreCase(addr)) {
                    addr = hsr.getHeader(header);
                } else {
                    break;
                }
            }
        }
        if (StringUtils.isBlank(addr) || NUKNOWN.equalsIgnoreCase(addr)) {
            addr = request.getRemoteAddr();
        } else {
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按','分割
            if (addr != null) {
                int i = addr.indexOf(",");
                if (i > 0) {
                    addr = addr.substring(0, i);
                }
            }

        }
        return addr;
    }
}

