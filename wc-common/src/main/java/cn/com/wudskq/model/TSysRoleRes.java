package cn.com.wudskq.model;
 
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wudskq
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "系统角色权限关联模型")
@TableName("sys_role_res")
public class TSysRoleRes {
 
    @TableId
    //防止数据失真
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty("角色id")
    private Long roleId;

    @ApiModelProperty("资源id")
    private Long resId;
 
}

