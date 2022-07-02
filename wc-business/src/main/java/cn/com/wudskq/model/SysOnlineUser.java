package cn.com.wudskq.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenfangchao
 * @title: SysOnlineUser
 * @projectName wc-manager-system
 * @description: TODO 系统在线用户模型
 * @date 2022/7/2 9:21 PM
 */
@ApiModel(value = "系统在线用户模型")
@Data
@Accessors(chain = true)
public class SysOnlineUser implements Serializable {

    @ApiModelProperty(value = "用户ID")
    private Long id;

    @ApiModelProperty("登录用户昵称")
    private String nickName;

    @ApiModelProperty(value = "会话编号")
    private String jti;

    @ApiModelProperty(value = "浏览器名称")
    private String browserName;

    @ApiModelProperty(value = "浏览器版本")
    private String browserVersion;

    @ApiModelProperty(value = "操作系统")
    private String operatorSystem;

    @ApiModelProperty(value = "登录主机")
    private String loginIp;

    @ApiModelProperty(value = "地点")
    private String address;

    @ApiModelProperty(value = "登录时间")
    private Date loginTime;

}
