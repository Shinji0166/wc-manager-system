package cn.com.wudskq.model.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @title: TokenVo
 * @projectName wc-manager-system
 * @description: TODO 接收Token模型
 * @date 2022/8/1 11:44 AM
 */
@ApiModel(value = "接收Token模型")
@Data
public class TokenVo implements Serializable {

    private static final long serialVersionUID = -7845513776113871168L;

    private String token;
}
