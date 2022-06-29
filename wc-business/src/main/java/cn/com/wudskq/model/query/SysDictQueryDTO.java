package cn.com.wudskq.model.query;

import cn.com.wudskq.model.common.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @title: SysDictQueryDTO
 * @projectName wc-manager-system
 * @description: TODO 字典查询模型
 * @date 2022/6/29 4:34 PM
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "字典查询模型")
public class SysDictQueryDTO extends PageDTO implements Serializable {

    private static final long serialVersionUID = 8459060940745830949L;

    @ApiModelProperty(value = "字典ID")
    private Integer id;

    @ApiModelProperty(value = "字典名称")
    private String dictName;

    @ApiModelProperty(value = "字典代码")
    private String dictCode;
}
