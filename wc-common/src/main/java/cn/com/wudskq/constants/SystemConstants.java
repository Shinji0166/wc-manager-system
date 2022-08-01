package cn.com.wudskq.constants;

/**
 * @author chenfangchao
 * @title: SystemConstants
 * @projectName wc-manager-system
 * @description: TODO 系统常量
 * @date 2022/7/2 9:04 PM
 */
public class SystemConstants {

    //系统登录接口
    public static final String SYSTEM_LOGIN_URI = "/system/doLogin";

    //用户新增接口
    public static final String USER_ADD_URI = "/system/save/user";

    //系统在线用户Key
    public static final String OLINE_USER_KEY = "online_user_#";

    //接口请求次数Key
    public static final String INTERFACE_ACTUATOR_KEY = "interface_call_count_#";

    //key过期时间
    public static final Long AVA_REDIS_TIMEOUT = 100000L;
}
