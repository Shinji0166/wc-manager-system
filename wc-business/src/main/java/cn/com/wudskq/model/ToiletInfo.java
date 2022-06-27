package cn.com.wudskq.model;

import cn.com.wudskq.common.CreateInfoModel;
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
 * @title: ToiletInfo
 * @projectName wc-manager-system
 * @description: TODO 公厕表模型
 * @date 2022/6/28 2:52 AM
 */
@ApiModel("公厕表模型")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("toilet_info")
public class ToiletInfo extends CreateInfoModel implements Serializable {

    private static final long serialVersionUID = -220811400749080250L;

    @ApiModelProperty(name="主键")
    //防止数据失真
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id ;

    @ApiModelProperty(name="公厕名称")
    private String name ;

    @ApiModelProperty(name="公厕编码")
    private String code ;

    @ApiModelProperty(name="位置(wkt)")
    private  String location ;

    @ApiModelProperty(name="是否为公厕(0是 1否)")
    private Integer type ;
}

