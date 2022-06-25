package cn.com.wudskq.mapper;


import cn.com.wudskq.model.TSysRoleRes;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
 


/**
 * @author wudskq
 */
public interface TSysRoleResMapper extends BaseMapper<TSysRoleRes> {
 
    List<String> selectRoleResByMap(Map<String, Object> map);
    
}

