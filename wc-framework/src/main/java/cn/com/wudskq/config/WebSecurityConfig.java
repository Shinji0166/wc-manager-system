package cn.com.wudskq.config;

import cn.com.wudskq.expection.UserAccessDeniedHandler;
import cn.com.wudskq.filter.JWTAuthenticationFilter;
import cn.com.wudskq.handler.*;
import cn.com.wudskq.permssion.UserPermissionEvaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启方法权限注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 无权限处理类
     */
    @Autowired
    private UserAccessDeniedHandler userAccessDeniedHandler;

    /**
     * 用户未登录处理类
     */
    @Autowired
    private UserNotLoginHandler userNotLoginHandler;

    /**
     * 用户登录成功处理类
     */
    @Autowired
    private UserLoginSuccessHandler userLoginSuccessHandler;

    /**
     * 用户登录失败处理类
     */
    @Autowired
    private UserLoginFailureHandler userLoginFailureHandler;

    /**
     * 用户登出成功处理类
     */
    @Autowired
    private UserLogoutSuccessHandler userLogoutSuccessHandler;

    /**
     * 用户登录验证
     */
    @Autowired
    private UserAuthenticationProvider userAuthenticationProvider;

    /**
     * 用户权限注解
     */
    @Autowired
    private UserPermissionEvaluator userPermissionEvaluator;

    /**
     * 加密方式，没使用这种加密方式
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 注入自定义PermissionEvaluator
     */
    @Bean
    public DefaultWebSecurityExpressionHandler userSecurityExpressionHandler() {
        DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
        handler.setPermissionEvaluator(userPermissionEvaluator);
        return handler;
    }


    /**
     * 解决 无法直接注入 AuthenticationManager
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 用户登录验证
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(userAuthenticationProvider);
    }


    @Value("${jwt.antMatchers}")
    private String antMatchers;//白名单,这里是不做验证的方法

    /**
     * 安全权限配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 权限配置
        http.authorizeRequests()
                //获取白名单（不进行权限验证）
                .antMatchers(antMatchers.split(",")).permitAll()
                .antMatchers("/wc/system/doLogin").permitAll()
                // 其他的需要登陆后才能访问
                .anyRequest().authenticated()
                // 开启跨域 禁用跨站请求伪造防护
                .and().cors().and().csrf().disable();
        //配置登录处理器
        http.formLogin().successHandler(userLoginSuccessHandler).failureHandler(userLoginFailureHandler);
        //配置未登录处理器
        http.exceptionHandling().authenticationEntryPoint(userNotLoginHandler);
        //配置登出处理器
        http.logout().logoutUrl("/logout").logoutSuccessHandler(userLogoutSuccessHandler);
        //配置无权限处理器
        http.exceptionHandling().accessDeniedHandler(userAccessDeniedHandler);
        // 禁用session（使用Token认证）
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // 禁用缓存
        http.headers().cacheControl();
        //添加JWT过滤器
        http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
    }

}

