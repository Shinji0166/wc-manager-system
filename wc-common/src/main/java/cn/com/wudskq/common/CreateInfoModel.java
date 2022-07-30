package cn.com.wudskq.common;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenfangchao
 * @title: CreateInfoModel
 * @projectName wc-manager-system
 * @description: TODO 通过模型(创建更新)
 * @date 2022/6/23 10:56 AM
 */
@Data
public class CreateInfoModel implements Serializable {

    private static final long serialVersionUID = -2450859791019986245L;

    @ApiModelProperty(value = "状态(0-正常,1-删除)")
    @TableField(fill = FieldFill.INSERT,value = "status")
    private Integer status;

    @ApiModelProperty(value = "系统多租户代码")
    @TableField(fill = FieldFill.INSERT,value = "tenant_code")
    private String tenantCode;

    @ApiModelProperty(value = "创建人")
    @TableField(fill = FieldFill.INSERT,value = "create_by")
    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT,value = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新人")
    @TableField(fill = FieldFill.UPDATE,value = "update_by")
    private String updateBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.UPDATE,value = "update_time")
    private Date updateTime;
}
