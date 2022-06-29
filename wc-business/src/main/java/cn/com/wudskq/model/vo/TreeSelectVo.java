package cn.com.wudskq.model.vo;

import cn.com.wudskq.model.SysDictType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import java.io.Serializable;
import java.util.List;

/**
 * @author chenfangchao
 * @title: SysDictTreeVo
 * @projectName wc-manager-system
 * @description: TODO 树结构实体类
 * @date 2022/6/29 9:51 AM
 */
@Data
@ApiModel(value = "树结构实体类")
public class TreeSelectVo implements Serializable {

    private static final long serialVersionUID = 6001894065800097155L;

    @ApiModelProperty(value = "节点ID")
    private Long id;

    @ApiModelProperty(value = "节点名称")
    private String label;

    @ApiModelProperty(value = "节点级别")
    private String level;

    @ApiModelProperty(value = "冗余字段")
    private String colum;

    @ApiModelProperty(value = "节点列表")
    private List<TreeSelectVo> childrenList;

    public TreeSelectVo(){

    };

    //字典
    public TreeSelectVo(SysDictType sysDictType){
        this.id = sysDictType.getId();
        this.label = sysDictType.getLabel();
    };


}
