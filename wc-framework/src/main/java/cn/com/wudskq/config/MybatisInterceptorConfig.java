package cn.com.wudskq.config;

import cn.com.wudskq.intercrptor.SQLInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author chenfangchao
 * @title: MybatisInterceptorConfig
 * @projectName wc-manager-system
 * @description: TODO mybatis配置
 * @date 2022/7/31 3:59 PM
 */
@Configuration
public class MybatisInterceptorConfig {

    /**
     * 注册拦截器
     */
    @Bean
    public SQLInterceptor mybatisInterceptor() {
        SQLInterceptor interceptor = new SQLInterceptor();
        return interceptor;
    }
}
