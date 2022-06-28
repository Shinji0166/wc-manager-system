package cn.com.wudskq.model;

import cn.com.wudskq.common.CreateInfoModel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @title: Position
 * @projectName wc-manager-system
 * @description: TODO 坑位表模型
 * @date 2022/6/28 3:28 AM
 */
@Data
@ApiModel(value = "坑位表模型")
@TableName("pit_position_info")
public class Position extends CreateInfoModel implements Serializable {

    private static final long serialVersionUID = 113006967275606197L;

    @ApiModelProperty(name = "主键")
    //防止数据失真
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId("id")
    private Long id ;

    @ApiModelProperty(name = "坑位名称")
    private String name;

    @ApiModelProperty(name = "坑位序号")
    private String number;

    @ApiModelProperty(name = "关联公厕ID")
    private Integer toiletId;
}
