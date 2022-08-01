package cn.com.wudskq.enums;

/**
 * @author chenfangchao
 * @title: SystemEnum
 * @projectName wc-manager-system
 * @description: TODO 系统枚举
 * @date 2022/8/1 3:36 PM
 */
public enum SystemEnum {

    //账户类型
    ADMIN_USER_TYPE("1","账户类型为管理员")
    ;

    private String value;

    private String  descriptions;

    SystemEnum(String value, String descriptions) {
        this.value = value;
        this.descriptions = descriptions;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
}
