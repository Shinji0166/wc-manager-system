package cn.com.wudskq.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chenfangchao
 * @title: OncePerFilter
 * @projectName wc-manager-system
 * @description: TODO 防止同一请求重复执行
 * @date 2022/7/21 5:14 PM
 */
@Configuration
public class OncePerFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
         filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
