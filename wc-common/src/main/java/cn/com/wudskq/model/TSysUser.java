package cn.com.wudskq.model;

import cn.com.wudskq.common.CreateInfoModel;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
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
@ApiModel(value = "用户表模型")
public class TSysUser extends CreateInfoModel implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    @TableId
    @ApiModelProperty(value = "主键ID")
    //防止数据失真
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @Length(min = 5,max = 20,message = "账号长度必须在5～20之间")
    @NotBlank(message = "账号不能为空")
    @ApiModelProperty(value = "账号")
    private String userName;

    @NotBlank(message = "密码不能为空")
    @Length(min = 5,max = 20,message = "密码长度必须在5～20之间")
    @ApiModelProperty(value = "密码")
    private String passWord;

    @NotBlank(message = "用户名不能为空")
    @Length(min = 5,max = 20,message = "用户名长度必须在5～20之间")
    @ApiModelProperty(value = "用户名")
    private String nickName;

    @NotBlank(message = "手机号码不能为空")
    @Length(min = 0,max = 11,message = "手机号码长度必须在1～12之间")
    @ApiModelProperty(value = "电话")
    private String cellPhone;

    @Length(min = 0,max = 100,message = "邮件长度必须在0～100之间")
    @ApiModelProperty(value = "邮件")
    private String mail;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "生日")
    private Date birthday;

    @ApiModelProperty(value = "状态（0-正常，1-删除，2-禁用)")
    @TableField(fill = FieldFill.INSERT,value = "status")
    private Integer status;

    @ApiModelProperty(value = "账户类型 1管理员账号 2普通账号")
    private String accountType;

    @ApiModelProperty(value = "性别：0男 1女")
    private String sex;

    @Length(min = 0,max = 100,message = "地址长度必须在0～100之间")
    @ApiModelProperty(value = "地址")
    private String address;

    @Length(min = 0,max = 100,message = "个性签名长度必须在0～100之间")
    @ApiModelProperty(value = "个人签名")
    private String sign;

    @ApiModelProperty(value = "用户祖级ID")
    private String ancestorId;

    @ApiModelProperty(value = "用户头像")
    private String pictureId;

    @ApiModelProperty(value = "角色ID")
    //防止数据失真
    @JsonSerialize(using = ToStringSerializer.class)
    @TableField(exist = false)
    private Long roleId;
}

