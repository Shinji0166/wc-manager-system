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
 * @author chenfangchao
 * @title: TSysUserRole
 * @projectName wc-manager-system
 * @description: TODO 用户角色表模型
 * @date 2022/6/23 10:56 AM
 */
@Data
@Accessors(chain = true)
@TableName("sys_user_role")
@ApiModel("用户角色表模型")
public class TSysUserRole {
 
    @TableId
    //防止数据失真
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty("用户名id")
    private Long userId;

    @ApiModelProperty("角色id")
    private Long roleId;
}

