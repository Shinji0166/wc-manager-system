package cn.com.wudskq.annotation;

import java.lang.annotation.*;

/**
 * @author chenfangchao
 * @title: ProhibitResubmit
 * @projectName wc-manager-system
 * @description: TODO 防止重复提交
 * @date 2022/7/23 8:59 PM
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ProhibitResubmit {
}
