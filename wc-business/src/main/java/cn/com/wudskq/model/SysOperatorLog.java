package cn.com.wudskq.model;

import cn.com.wudskq.common.CreateInfoModel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @title: SysOperatorLog
 * @projectName wc-manager-system
 * @description: TODO 系统操作日志表模型
 * @date 2022/7/1 8:38 PM
 */

@Data
@Accessors(chain = true)
@ApiModel(value = "系统操作日志表模型")
@TableName("sys_operator_log")
public class SysOperatorLog extends CreateInfoModel implements Serializable {

    @ApiModelProperty(value = "ID")
    @TableId("id")
    private Long id ;

    @ApiModelProperty(name = "操作模块")
    private  String operatorModule;

    @ApiModelProperty(name = "操作功能")
    private  String operatorFunction;

    @ApiModelProperty(name = "执行动作")
    private  String operatorAction;

    @ApiModelProperty(name = "请求模式")
    private  String requestMode;

    @ApiModelProperty(name = "响应结果")
    private  String result;

    @ApiModelProperty("失败原因")
    private String failureReason;

}
