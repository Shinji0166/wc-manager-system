package cn.com.wudskq.web;

import cn.com.wudskq.model.common.LoginDTO;
import org.springframework.stereotype.Service;

/**
 * @author chenfangchao
 * @title: LoginService
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/23 4:06 PM
 */
@Service
public interface LoginService {

    /** 登录 **/
    String doLogin(LoginDTO login);
}
