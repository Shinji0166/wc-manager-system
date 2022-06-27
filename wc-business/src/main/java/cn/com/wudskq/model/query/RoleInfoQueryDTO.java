package cn.com.wudskq.model.query;

import cn.com.wudskq.model.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @title: RoleInfoQueryDTO
 * @projectName wc-manager-system
 * @description: TODO 角色信息查询模型
 * @date 2022/6/27 8:56 AM
 */
@Data
@ApiModel("角色信息查询模型")
public class RoleInfoQueryDTO extends PageDTO implements Serializable {

    private static final long serialVersionUID = 8037083030037968380L;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色代码")
    private String roleCode;

}
