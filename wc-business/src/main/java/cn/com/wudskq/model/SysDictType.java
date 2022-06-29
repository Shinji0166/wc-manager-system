package cn.com.wudskq.model;

import cn.com.wudskq.common.CreateInfoModel;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @title: SysDictType
 * @projectName wc-manager-system
 * @description: TODO 系统字典类型表模型
 * @date 2022/6/28 5:01 PM
 */
@ApiModel(value = "系统字典类型表模型")
@Data
@TableName("sys_dict_type")
public class SysDictType extends CreateInfoModel implements Serializable {

    private static final long serialVersionUID = 8862901131940149379L;

    @ApiModelProperty(name = "主键")
    private Long id;

    @ApiModelProperty(name = "字典名称")
    private String label;

    @ApiModelProperty(name = "字典类型名称")
    private String type;

    @ApiModelProperty(name = "字典分类(0系统字典 1模块字典 2公共字典)")
    private Integer classify;

    @ApiModelProperty(name = "父级ID 顶级节点pid默认为0")
    private Integer pid;

    @ApiModelProperty(name = "状态(0正常 1删除 2禁用)")
    private Integer status;

}
