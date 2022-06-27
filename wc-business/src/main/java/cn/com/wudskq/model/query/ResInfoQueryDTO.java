package cn.com.wudskq.model.query;

import cn.com.wudskq.model.common.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @title: ResInfoQueryDTO
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/27 11:19 AM
 */
@ApiModel("菜单信息查询模型")
@Data
public class ResInfoQueryDTO extends PageDTO implements Serializable {

    @ApiModelProperty("资源名称/菜单名称")
    private String resName;
}
