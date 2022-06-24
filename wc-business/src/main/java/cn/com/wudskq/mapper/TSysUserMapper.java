package cn.com.wudskq.mapper;


import cn.com.wudskq.model.TSysUser;
import cn.com.wudskq.model.query.UserInfoQueryDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author wudskq
 */
public interface TSysUserMapper extends BaseMapper<TSysUser> {

    /**
     * 获取用户信息列表
     * @param userInfoQuery
     * @return
     */
    List<TSysUser> getUserInfoList(@Param("query") UserInfoQueryDTO userInfoQuery);

    /**
     * 获取用户详细信息
     * @param id
     * @return
     */
    TSysUser getUserDetail(@Param("id") String id);
}

