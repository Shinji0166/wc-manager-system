package cn.com.wudskq.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

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
@ToString
public class CreateInfoModel implements Serializable {

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新人")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private Date updateTime;
}
