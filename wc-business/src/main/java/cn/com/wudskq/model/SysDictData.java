package cn.com.wudskq.model;

import cn.com.wudskq.common.CreateInfoModel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @title: SysDictData
 * @projectName wc-manager-system
 * @description: TODO 系统字典数据表模型
 * @date 2022/6/28 5:06 PM
 */
@ApiModel(value = "系统字典数据表模型")
@Data
@TableName("sys_dict_data")
public class SysDictData extends CreateInfoModel implements Serializable {

    private static final long serialVersionUID = 2686814784445338505L;

    @ApiModelProperty(name = "主键")
    @TableId("id")
    private Long id ;

    @ApiModelProperty(name = "字典标签")
    private String dictLabel;

    @ApiModelProperty(name = "字典值")
    private String dictValue;

    @ApiModelProperty(name = "字典类型")
    private String dictType;

    @ApiModelProperty(name = "状态(0启用 1禁用)")
    private Integer status;
}
