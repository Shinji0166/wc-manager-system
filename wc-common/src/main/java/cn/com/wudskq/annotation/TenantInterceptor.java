package cn.com.wudskq.annotation;

import java.lang.annotation.*;

/**
 * @author chenfangchao
 * @title: TenantInterceptor
 * @projectName wc-manager-system
 * @description: TODO 是否需要使用多租户代码查询
 * @date 2022/7/31 10:55 PM
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface TenantInterceptor {

}
