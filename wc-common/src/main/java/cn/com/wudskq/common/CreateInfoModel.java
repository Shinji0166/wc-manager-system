package cn.com.wudskq.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

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

    @ApiModelProperty("状态(0-正常,1-删除)")
    private Integer status;

    @ApiModelProperty("创建人")
    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新人")
    private String updateBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("更新时间")
    private Date updateTime;
}
