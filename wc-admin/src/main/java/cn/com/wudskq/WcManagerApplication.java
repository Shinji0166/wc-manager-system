package cn.com.wudskq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author chenfangchao
 * @title: WcManagerApplication
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/15 1:53 AM
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) //排除数据源自动配置
public class WcManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(WcManagerApplication.class,args);
        System.out.println("公厕原理系统启动成功");
    }
}
