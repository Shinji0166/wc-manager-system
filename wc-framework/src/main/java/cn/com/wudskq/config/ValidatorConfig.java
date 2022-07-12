package cn.com.wudskq.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author chenfangchao
 * @title: ValidatorConfig
 * @projectName wc-manager-system
 * @description: TODO 参数校验配置类
 * @date 2022/7/12 9:41 AM
 */
@Configuration
public class ValidatorConfig {

    /**
     * validation默认会校验完所有字段，然后返回所有的验证失败信息。
     * 可以通过一些简单的配置，开启Fail Fast模式，只要有一个验证失败就立即返回
     */
    @Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation
                .byProvider(HibernateValidator.class)
                .configure()
                .failFast(true)
                .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        return validator;
    }
}
