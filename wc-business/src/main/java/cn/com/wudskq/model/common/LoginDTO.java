package cn.com.wudskq.model.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @title: LoginDTO
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/23 4:02 PM
 */
@ApiModel("系统登录模型")
@Data
@ToString
public class LoginDTO implements Serializable {

    private static final long serialVersionUID = -7097015840530996207L;

    @ApiModelProperty("账户")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("验证码")
    private String verificationCode;

    @ApiModelProperty("验证码-uuid")
    private String  uuid;
}
