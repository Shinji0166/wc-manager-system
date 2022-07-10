package cn.com.wudskq.enums;

/**
 * @author chenfangchao
 * @title: AppendixDataSourceEnum
 * @projectName wc-manager-system
 * @description: TODO 附件数据来源枚举
 * @date 2022/7/10 3:46 PM
 */

public enum AppendixDataSourceEnum {

    DATASOURCE(0,"用户表")
    ;


    /** 数据来源值 **/
    private Integer dataSource;

    /** 来数据来源描述 **/
    private String  message;

    AppendixDataSourceEnum(Integer dataSource, String message) {
        this.dataSource = dataSource;
        this.message = message;
    }

    public Integer getDataSource() {
        return dataSource;
    }

    public void setDataSource(Integer dataSource) {
        this.dataSource = dataSource;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
