package cn.com.wudskq.model;

import cn.com.wudskq.common.CreateInfoModel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @title: SysAppendix
 * @projectName wc-manager-system
 * @description: TODO 系统附件表模型
 * @date 2022/7/10 3:21 PM
 */

@ApiModel(value = "系统附件表模型")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_appendix")
public class SysAppendix extends CreateInfoModel implements Serializable {

    private static final long serialVersionUID = 3895364719442875280L;

    @TableId("id")
    @ApiModelProperty(value = "ID")
    //防止ID失真
    @JsonSerialize(using = ToStringSerializer.class)
    private  Long id;

    @ApiModelProperty(value = "附件名")
    private  String name;

    @ApiModelProperty(value = "附件地址")
    private  String url;

    @ApiModelProperty(value = "附件来源(来自什么表)")
    private Integer dataSource;
}
