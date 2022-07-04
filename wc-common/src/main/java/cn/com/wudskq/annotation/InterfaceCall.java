package cn.com.wudskq.annotation;

import java.lang.annotation.*;

/**
 * @author chenfangchao
 * @title: InterfaceCall
 * @projectName wc-manager-system
 * @description: TODO 接口调用
 * @date 2022/7/4 12:20 AM
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface InterfaceCall {

    //接口名称
    String interfaceName();

    //请求的方式
    String requestMode();
}
