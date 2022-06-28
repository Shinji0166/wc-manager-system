package cn.com.wudskq.model.query;

import cn.com.wudskq.model.common.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @title: DeviceQueryDTO
 * @projectName wc-manager-system
 * @description: TODO 设备查询模型
 * @date 2022/6/28 3:32 PM
 */
@ApiModel(value = "设备查询模型")
@Data
public class DeviceQueryDTO extends PageDTO implements Serializable {

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "设备编码")
    private String deviceCode;

    @ApiModelProperty(value = "设备状态")
    private Integer deviceStatus;
}
