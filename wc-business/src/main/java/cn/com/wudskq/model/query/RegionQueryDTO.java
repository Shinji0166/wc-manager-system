package cn.com.wudskq.model.query;

import cn.com.wudskq.model.common.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @title: RegionQueryDTO
 * @projectName wc-manager-system
 * @description: TODO 地区信息查询模型
 * @date 2022/6/27 8:26 PM
 */
@Data
@ApiModel("地区信息查询模型")
public class RegionQueryDTO extends PageDTO implements Serializable {

    @ApiModelProperty("省份名称")
    private String  provinceName ;

    @ApiModelProperty("城市名称")
    private String cityName ;

    @ApiModelProperty("地区名称")
    private String regionName ;

}
