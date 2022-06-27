package cn.com.wudskq.model;

import cn.com.wudskq.common.CreateInfoModel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @title: countryRegion
 * @projectName wc-manager-system
 * @description: TODO 地域表模型
 * @date 2022/6/27 8:02 PM
 */

@ApiModel("地域表模型")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("country_region")
public class CountryRegion extends CreateInfoModel implements Serializable {

    @TableId("id")
    //防止数据失真
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id ;

    @ApiModelProperty("省份名称")
    private String  provinceName ;

    @ApiModelProperty("城市名称")
    private String cityName ;

    @ApiModelProperty("地区名称")
    private String regionName ;

    @ApiModelProperty("地理位置")
    private String location;

}
