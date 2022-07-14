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


/**
 * @author chenfangchao
 * @title: TSysRes
 * @projectName wc-manager-system
 * @description: TODO 菜单(权限)模型
 * @date 2022/6/23 10:56 AM
 */
@Data
@TableName("sys_res")
@ApiModel("菜单(权限)表模型")
public class TSysRes extends CreateInfoModel{
 
    @TableId
    //防止数据失真
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty("资源名称")
    private String name;

    @ApiModelProperty("资源路径")
    private String resUrl;

    @ApiModelProperty("权限标识")
    private String permission;

    @ApiModelProperty("资源类型(0目录 1菜单 2按钮)")
    private Integer resType;

    @ApiModelProperty("父级id 等于0时为系统顶级菜单")
    private Long pid;

    @ApiModelProperty("菜单图标")
    private String icon;

    @ApiModelProperty("是否有子节点 默认为false")
    @TableField(exist = false)
    private Boolean hasChildren=false;
}

