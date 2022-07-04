package cn.com.wudskq.model;

import cn.com.wudskq.common.CreateInfoModel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenfangchao
 * @title: SysInterfaceCall
 * @projectName wc-manager-system
 * @description: TODO 接口调用次数表模型
 * @date 2022/7/4 3:48 PM
 */

@ApiModel(value = "接口调用次数表模型")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("sys_interface_call")
public class SysInterfaceCall extends CreateInfoModel implements Serializable {

    @TableId("id")
    private Long id ;

    @ApiModelProperty(name = "接口名称")
    private  String interfaceName;

    @ApiModelProperty(name = "声明名称")
    private  String declaringName;

    @ApiModelProperty(name = "方法名称")
    private  String methodName;

    @ApiModelProperty(name = "请求方式")
    private String  requestMode;

    @ApiModelProperty(name = "请求IP")
    private String  requestIp;

    @ApiModelProperty(name = "接口调用次数 默认0")
    private Integer interfaceCallCount=0;

    @ApiModelProperty(name = "接口调用成功数 默认0")
    private Integer interfaceCallSuccessCount=0;

    @ApiModelProperty(name = "接口调用失败数 默认0")
    private Integer interfaceCallFailCount=0;

    @ApiModelProperty(name = "接口回调单次时间")
    private Long interfaceCallTime;

    @ApiModelProperty("接口回调总时间 默认0")
    private Long  interfaceCallTotalTime=0L;

    @ApiModelProperty("接口回调最小时间 默认0")
    private Long  interfaceCallMinTime =0L;

    @ApiModelProperty("接口回调最大时间 默认0")
    private Long  interfaceCallMaxTime =0L;

    @ApiModelProperty("接口平均最大时间 默认0")
    private Long  interfaceCallAvgTime =0L;

    @ApiModelProperty(name = "接口请求时间")
    private Date interfaceRequestTime;
}
