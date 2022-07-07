package cn.com.wudskq.model;

import cn.com.wudskq.common.CreateInfoModel;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @title: Device
 * @projectName wc-manager-system
 * @description: TODO 设备表模型
 * @date 2022/6/28 3:26 PM
 */
@Data
@Api(value = "设备表模型")
@TableName("device_info")
public class Device extends CreateInfoModel implements Serializable {

    @TableId("id")
    @ApiModelProperty(name = "主键")
    //解决数据失真问题
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id ;

    @ApiModelProperty(name = "设备名称")
    private String name;

    @ApiModelProperty(name = "设备编码")
    private  String code;

    @ApiModelProperty(name = "设备机器码")
    private  String indexCode;

    /** 状态(0启用 1禁用 2在线 3离线) */
    @ApiModelProperty(name = "状态(0启用 1禁用 2在线 3离线)")
    @TableField(fill = FieldFill.INSERT,value = "status")
    private  Integer status;
}
