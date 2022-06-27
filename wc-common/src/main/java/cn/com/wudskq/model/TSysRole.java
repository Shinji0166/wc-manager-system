package cn.com.wudskq.model;

import cn.com.wudskq.common.CreateInfoModel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author chenfangchao
 * @title: TSysRole
 * @projectName wc-manager-system
 * @description: TODO 角色表模型
 * @date 2022/6/23 10:56 AM
 */
@Data
@TableName("sys_role")
@ApiModel("角色表模型")
public class TSysRole extends CreateInfoModel {
 
    @TableId
    //防止数据失真
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色代码")
    private String roleCode;

    @ApiModelProperty("角色描述")
    private String roleExplain;
}

