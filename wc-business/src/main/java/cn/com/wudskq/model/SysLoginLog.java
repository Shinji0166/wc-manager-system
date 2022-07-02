package cn.com.wudskq.model;

import cn.com.wudskq.common.CreateInfoModel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @title: SysLoginLog
 * @projectName wc-manager-system
 * @description: TODO 系统登录日志表模型
 * @date 2022/7/2 4:25 PM
 */

@ApiModel(value = "系统登录日志表模型")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_login_info")
public class SysLoginLog extends CreateInfoModel  implements Serializable {

    private static final long serialVersionUID = 5676393563140726127L;

    @TableId("id")
    private Long id;

    @ApiModelProperty(name = "浏览器名称")
    private String browserName;

    @ApiModelProperty(name = "浏览器版本")
    private String browserVersion;

    @ApiModelProperty(name = "操作系统")
    private String operatorSystem;

}
