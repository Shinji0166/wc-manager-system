package cn.com.wudskq.model.common;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @title: PageDTO
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/23 2:46 PM
 */
@Data
@ApiModel("分页模型")
public class PageDTO implements Serializable {

    private static final long serialVersionUID = 5830451287724971018L;

    /** 当前登录用户ID **/
    private Long currentLoginUserId;

    private Integer pageNum;

    private Integer pageSize;
}
