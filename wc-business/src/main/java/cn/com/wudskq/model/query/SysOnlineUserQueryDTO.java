package cn.com.wudskq.model.query;

import cn.com.wudskq.model.common.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @title: SysOnlineUserDTO
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/7/3 1:18 AM
 */
@ApiModel(value = "在线用户查询模型")
@Data
public class SysOnlineUserQueryDTO extends PageDTO implements Serializable {

    private static final long serialVersionUID = -1380445517965593882L;

    @ApiModelProperty(value = "在线用户昵称")
    private String nickName;

    @ApiModelProperty(value = "登录IP")
    private String ip;
}
