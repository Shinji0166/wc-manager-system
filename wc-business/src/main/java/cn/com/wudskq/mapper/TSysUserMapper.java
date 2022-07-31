package cn.com.wudskq.mapper;

import cn.com.wudskq.annotation.TenantInterceptor;
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
     * 根据用户ID获取系统租户代码列表
     * @param id
     * @return
     */
    List<String> getTenantCodeByUserId(@Param("id") Long id);

    /**
     * 获取用户信息列表
     * @param userInfoQuery
     * @param tenantCode
     * @return
     */
    @TenantInterceptor
    List<TSysUser> getUserInfoList(@Param("query") UserInfoQueryDTO userInfoQuery,@Param("tenantCode") String tenantCode);

    /**
     * 获取用户详细信息
     * @param id
     * @return
     */

    TSysUser getUserDetail(@Param("id") Long id);

    /**
     * 逻辑删除用户信息
     * @param ids
     */
    void removeUser(@Param("ids") List<String> ids);
}

