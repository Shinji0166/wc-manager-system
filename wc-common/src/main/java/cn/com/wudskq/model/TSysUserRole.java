package cn.com.wudskq.model;
 
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author chenfangchao
 * @title: TSysUserRole
 * @projectName wc-manager-system
 * @description: TODO 用户角色表模型
 * @date 2022/6/23 10:56 AM
 */
@Data
@TableName("t_sys_user_role")
@ApiModel("用户角色表模型")
public class TSysUserRole {
 
    @TableId
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("用户名id")
    private String userId;

    @ApiModelProperty("角色id")
    private String roleId;
}

