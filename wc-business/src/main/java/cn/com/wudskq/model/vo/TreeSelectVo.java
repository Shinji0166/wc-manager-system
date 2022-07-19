package cn.com.wudskq.model.vo;

import cn.com.wudskq.model.SysDictType;
import cn.com.wudskq.model.TSysRes;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
    //防止数据失真
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "节点名称")
    private String label;

    @ApiModelProperty(value = "节点级别")
    private Integer level;

    @ApiModelProperty(value = "节点代码")
    private String  code;

    @ApiModelProperty(value = "类型")
    private Integer type;

    @ApiModelProperty(value = "资源路径")
    private String  path;

    @ApiModelProperty(value = "icon")
    private String  icon;

    @ApiModelProperty(value = "节点列表")
    private List<TreeSelectVo> children;

    public TreeSelectVo(){

    };

    //字典
    public TreeSelectVo(SysDictType sysDictType){
        this.id = sysDictType.getId();
        this.label = sysDictType.getLabel();
        this.code = sysDictType.getType();
    };

    //菜单
    public TreeSelectVo(TSysRes sysRes){
        this.id = sysRes.getId();
        this.label = sysRes.getName();
        this.code = sysRes.getPermission();
        this.type = sysRes.getResType();
        this.path = sysRes.getResUrl();
        this.icon = sysRes.getIcon();
    }


    public List<TreeSelectVo> getChildren() {
        return children;
    }

    public void setChildren(List<TreeSelectVo> children) {
        this.children = children;
    }

}
