package cn.com.wudskq.model.query;

import cn.com.wudskq.model.common.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @title: ResInfoQueryDTO
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/27 11:19 AM
 */
@Data
@ApiModel(value = "菜单信息查询模型")
public class ResInfoQueryDTO extends PageDTO implements Serializable {

    @ApiModelProperty(value = "资源名称/菜单名称")
    private String resName;

    @ApiModelProperty(value = "权限代码")
    private String permission;

    @ApiModelProperty(value = "资源类型(0目录 1菜单 2按钮)")
    private Integer resType;

    @ApiModelProperty(value = "状态(0启用,1禁用)")
    private Integer status;

    @ApiModelProperty(value = "上级菜单ID")
    private Long pid;
}
