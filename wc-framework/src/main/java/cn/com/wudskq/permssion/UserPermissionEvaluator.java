package cn.com.wudskq.permssion;

import cn.com.wudskq.expection.BusinessException;
import cn.com.wudskq.model.SysUserDetails;
import cn.com.wudskq.model.TSysRes;
import cn.com.wudskq.service.TSysResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wudskq
 */

@Configuration
@Component
public class UserPermissionEvaluator implements PermissionEvaluator {
 
    @Autowired
    private TSysResService tSysResService;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetUrl, Object permission) {
        SysUserDetails sysUserDetails = null;
        try {
            sysUserDetails = (SysUserDetails) authentication.getPrincipal();
        } catch (Exception e){
            throw new BusinessException(403,"权限不足");
        }

        Set<String> permissions = new HashSet<String>(); // 用户权限

        //admin拥有全部权限
        if("admin".equals(sysUserDetails.getUsername())){
             return true;
        }else {
            List<TSysRes> authList = tSysResService.findResByUserId(String.valueOf(sysUserDetails.getId()));
            for (int i = 0; i < authList.size() ; i++) {
                permissions.add("res_"+authList.get(i).getPermission());
            }
            // 判断是否拥有权限
            if (permissions.contains(permission.toString())) {
                return true;
            }
            return false;
        }
    }
 
    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
                                 Object permission) {
        return false;
    }
 
}