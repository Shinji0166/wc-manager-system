package cn.com.wudskq.model.query;

import cn.com.wudskq.model.common.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @title: ToiletInfoQueryDTO
 * @projectName wc-manager-system
 * @description: TODO 公厕信息查询模型
 * @date 2022/6/28 3:00 AM
 */
@Data
@ApiModel(value = "公厕信息查询模型")
public class ToiletInfoQueryDTO extends PageDTO implements Serializable {

    @ApiModelProperty(value = "公厕名称")
    private String toiletName;

    @ApiModelProperty(value = "公厕类型")
    private Integer toiletType;
}
