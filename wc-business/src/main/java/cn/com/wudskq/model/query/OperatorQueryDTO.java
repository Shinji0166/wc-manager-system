package cn.com.wudskq.model.query;

import cn.com.wudskq.model.common.PageDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @title: OperatorQueryDTO
 * @projectName wc-manager-system
 * @description: TODO 系统操作日志查询模型
 * @date 2022/7/1 8:48 PM
 */
@ApiModel(value = "系统操作日志查询模型")
@Data
public class OperatorQueryDTO extends PageDTO implements Serializable {

    private static final long serialVersionUID = 130109576946740606L;
}
