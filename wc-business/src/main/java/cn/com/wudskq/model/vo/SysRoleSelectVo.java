package cn.com.wudskq.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @title: SysRoleSelectVo
 * @projectName wc-manager-system
 * @description: TODO 角色下拉框数据模型
 * @date 2022/7/20 2:13 AM
 */
@ApiModel(value = "角色下拉框数据模型")
@Data
@ToString
public class SysRoleSelectVo implements Serializable {

    private static final long serialVersionUID = -3192240632196013302L;

    @ApiModelProperty(value = "角色ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "角色名称")
    private String roleName;
}
