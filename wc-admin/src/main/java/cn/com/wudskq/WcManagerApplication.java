package cn.com.wudskq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chenfangchao
 * @title: WcManagerApplication
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/15 1:53 AM
 */
@SpringBootApplication
public class WcManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(WcManagerApplication.class,args);
        System.out.println("公厕原理系统启动成功");
    }
}
