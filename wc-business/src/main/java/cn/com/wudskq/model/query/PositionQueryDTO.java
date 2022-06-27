package cn.com.wudskq.model.query;

import cn.com.wudskq.model.common.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @title: PositionQueryDTO
 * @projectName wc-manager-system
 * @description: TODO 坑位信息查询模型
 * @date 2022/6/28 3:31 AM
 */
@ApiModel(value = "坑位信息查询模型")
@Data
@EqualsAndHashCode(callSuper = false)
public class PositionQueryDTO extends PageDTO implements Serializable {

    private static final long serialVersionUID = 767106199516928179L;

    @ApiModelProperty(value = "隶属公厕")
    private String toiletName;

}
