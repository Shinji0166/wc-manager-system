package cn.com.wudskq.config;

import cn.com.wudskq.intercrptor.SameUrlDataInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author chenfangchao
 * @title: MvcWebConfiguration
 * @projectName wc-manager-system
 * @description: TODO web相关配置
 * @date 2022/7/23 9:24 PM
 */
@Configuration
public class MvcWebConfiguration implements WebMvcConfigurer {

    /** 防止重复提交拦截器 **/
    @Autowired
    private SameUrlDataInterceptor sameUrlDataInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //通过register注册拦截器，通过addPathPatterns添加拦截路径
        registry.addInterceptor(sameUrlDataInterceptor).addPathPatterns("/**"); //拦截所有路径
    }
}
