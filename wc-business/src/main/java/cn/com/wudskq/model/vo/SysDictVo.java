package cn.com.wudskq.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import java.io.Serializable;

/**
 * @author chenfangchao
 * @title: SysDictDTO
 * @projectName wc-manager-system
 * @description: TODO 字典视图数据模型
 * @date 2022/6/29 4:37 PM
 */
@Data
@ApiModel(value = "字典视图数据模型")
public class SysDictVo implements Serializable {

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "字典名称")
    private String dictName;

    @ApiModelProperty(value = "字典代码")
    private String dictCode;

    @ApiModelProperty(value = "字典分类(0系统字典 1模块字典 2公共字典)")
    private Integer classify;

    @ApiModelProperty(value = "状态(0正常 1删除 2禁用)")
    private Integer status;
}
