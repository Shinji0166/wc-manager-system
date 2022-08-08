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
 * @title: SysLoginLog
 * @projectName wc-manager-system
 * @description: TODO 系统登录日志表模型
 * @date 2022/7/2 4:25 PM
 */

@ApiModel(value = "系统登录日志表模型")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_login_info")
public class SysLoginLog extends CreateInfoModel  implements Serializable {

    private static final long serialVersionUID = 5676393563140726127L;

    @TableId("id")
    //防止ID失真
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "浏览器名称")
    private String browserName;

    @ApiModelProperty(value = "浏览器版本")
    private String browserVersion;

    @ApiModelProperty(value = "请求IP")
    private String requestIp;

    @ApiModelProperty(value = "操作系统")
    private String operatorSystem;

    @ApiModelProperty(name = "响应结果")
    private  String result;

    @ApiModelProperty("失败原因")
    private String failureReason;

}
