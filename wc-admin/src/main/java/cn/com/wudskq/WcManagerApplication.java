package cn.com.wudskq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author chenfangchao
 * @title: WcManagerApplication
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/15 1:53 AM
 */
@EnableAspectJAutoProxy
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) //排除数据源自动配置
@MapperScan(basePackages = "cn.com.wudskq.mapper")
public class WcManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(WcManagerApplication.class,args);
        System.out.println("公厕管理系统启动成功");
    }
}
