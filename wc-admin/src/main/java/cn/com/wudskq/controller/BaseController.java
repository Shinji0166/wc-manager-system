package cn.com.wudskq.controller;

import cn.com.wudskq.expection.DemoModeException;
import cn.com.wudskq.utils.ServletUtils;
import cn.com.wudskq.utils.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chenfangchao
 * @title: BaseController
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/7/29 11:20 PM
 */
@Component
public class BaseController {

    //启动环境
    @Value("${spring.profiles.active}")
    private String profilesActive;

    //代表为查询列表操作
    private static final String LIST_URI = "/list";

    //代表为查询详情操作
    private static final String DETAIL_URI = "/detail";

    //代表为下拉框查询操作
    private static final String SELECT_URI = "/select";

    //代表为树查询操作
    private static final String TREE_URI = "/tree";

    //代表根据字典类型查询下属字典列表
    private static final String DICT_URI = "/dict/data/by/type";

    //该注解作用会在controller每个方法被执行前执行
    @ModelAttribute
    public void init(HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException
    {
        if("demo".equals(profilesActive)) {

            String url = ServletUtils.getRequestURI();

            // 需要放开的url
            if (StringUtils.isNotEmpty(url)) {
                //判断是否包含演示模式可以执行的URI
                if (url.contains(LIST_URI) || url.contains(DETAIL_URI) || url.contains(SELECT_URI) || url.contains(TREE_URI) || url.contains(DICT_URI)) {
                    return;
                }
            }

            // 增删改请求
            if ("DELETE".equals(httpServletRequest.getMethod()) || "POST".equals(httpServletRequest.getMethod())
                    || "PUT".equals(httpServletRequest.getMethod())) {
                throw new DemoModeException(500, "当前环境为演示模式！禁止操作");
            }
        }
    }
}
