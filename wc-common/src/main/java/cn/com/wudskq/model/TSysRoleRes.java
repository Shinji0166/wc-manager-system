package cn.com.wudskq.model;
 
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wudskq
 */
@Data
@TableName("sys_role_res")
@ApiModel("角色资源表模型")
public class TSysRoleRes {
 
    @TableId
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("角色id")
    private String roleId;

    @ApiModelProperty("资源id")
    private String resId;
 
}

