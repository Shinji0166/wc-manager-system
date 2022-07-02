package cn.com.wudskq.model;

import cn.com.wudskq.common.CreateInfoModel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenfangchao
 * @title: TSysUser
 * @projectName wc-manager-system
 * @description: TODO 用户表模型
 * @date 2022/6/23 10:56 AM
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_user")
@ApiModel("用户表模型")
public class TSysUser extends CreateInfoModel implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    @TableId
    @ApiModelProperty("主键ID")
    //防止数据失真
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("密码")
    private String passWord;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("电话")
    private String cellPhone;

    @ApiModelProperty("邮件")
    private String mail;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty("生日")
    private Date birthday;

    @ApiModelProperty("状态（0-正常，1-删除，2-禁用)")
    private Integer status;

    @ApiModelProperty("账户类型 1系统账号 2普通账号")
    private String accountType;

    @ApiModelProperty("邀请码")
    private String inviteCode;

    @ApiModelProperty("性别：0男 1女")
    private String sex;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("个人签名")
    private String sign;

    @ApiModelProperty("用户头像")
    private String pictureId;

}

