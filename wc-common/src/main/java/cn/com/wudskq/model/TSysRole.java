package cn.com.wudskq.model;

import cn.com.wudskq.common.CreateInfoModel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

/**
 * @author chenfangchao
 * @title: TSysRole
 * @projectName wc-manager-system
 * @description: TODO 角色表模型
 * @date 2022/6/23 10:56 AM
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "角色表模型")
@TableName("sys_role")
public class TSysRole extends CreateInfoModel {
 
    @TableId
    //防止数据失真
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @Length(min = 5,max = 10,message = "角色名称长度在5～10之间")
    @NotBlank(message = "角色名称不能为空")
    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @Length(min = 5,max = 10,message = "角色代码长度在5～10之间")
    @NotBlank(message = "角色代码不能为空")
    @ApiModelProperty(value = "角色代码")
    private String roleCode;

    @ApiModelProperty(value = "角色描述")
    private String roleExplain;

    @ApiModelProperty(value = "菜单权限ID列表")
    @TableField(exist = false)
    private List<String> menuAuthList;

}

