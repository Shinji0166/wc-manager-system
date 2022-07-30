package cn.com.wudskq.model;

import cn.hutool.core.bean.BeanUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "登录时间")
    private Date loginTime;

    @ApiModelProperty(value = "过期时间戳")
    private Long expirationTime;

    @ApiModelProperty("状态(0在线,1注销)")
    private Integer status=0;

    @ApiModelProperty(value = "多租户代码")
    private String tenantCode;

    public SysOnlineUser(Object object) {
        SysOnlineUser source = (SysOnlineUser) object;
        this.setId(source.getId());
        this.setNickName(source.getNickName());
        this.setJti(source.getJti());
        this.setBrowserName(source.getBrowserName());
        this.setBrowserVersion(source.getBrowserVersion());
        this.setOperatorSystem(source.getOperatorSystem());
        this.setLoginIp(source.getLoginIp());
        this.setAddress(source.getAddress());
        this.setLoginTime(source.getLoginTime());
        this.setExpirationTime(source.getExpirationTime());
        this.setStatus(source.getStatus());
    }
}
