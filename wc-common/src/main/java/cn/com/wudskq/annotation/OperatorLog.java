package cn.com.wudskq.annotation;

import java.lang.annotation.*;

/**
 * @author chenfangchao
 * @title: OperatorLog
 * @projectName wc-manager-system
 * @description: TODO 系统操作日志注解
 * @date 2022/7/1 4:49 PM
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface OperatorLog {

    //操作的模块
    String module();

    //操作的功能
    String function();

    //执行的动作
    String action();


    //请求的方式
    String requestMode();


}
