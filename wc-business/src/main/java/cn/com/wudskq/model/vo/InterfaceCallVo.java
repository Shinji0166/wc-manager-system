package cn.com.wudskq.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @title: InterfaceCallVO
 * @projectName wc-manager-system
 * @description: TODO 接口调用次数视图模型
 * @date 2022/7/6 11:10 AM
 */
@ApiModel(value = "接口调用次数视图模型")
@Data
public class InterfaceCallVo implements Serializable {

    private static final long serialVersionUID = -2914887595418755400L;

    @ApiModelProperty(value = "接口名称")
    private String interfaceName;

    @ApiModelProperty(value = "调用成功次数")
    private Long interfaceCallSuccessCount;

    @ApiModelProperty(value = "调用失败次数")
    private Long interfaceCallFailCount;

}
