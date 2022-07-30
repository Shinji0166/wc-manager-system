package cn.com.wudskq.web;

import cn.com.wudskq.mapper.TSysResMapper;
import cn.com.wudskq.model.SysUserDetails;
import cn.com.wudskq.model.TSysRes;
import cn.com.wudskq.model.TSysUser;

import cn.com.wudskq.service.TSysResService;
import cn.com.wudskq.service.TSysUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wudskq
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private TSysUserService tSysUserService;
 
    @Resource
    private TSysResMapper tSysResMapper;
 
    @Autowired
    private TSysResService tSysResService;
 
    /**
     * 说明：重写UserDetailsService中的loadUserByUsername，就是查询用户详细信息封装到 UserDetails
     * 业务：
     *      ①如果是admin会拥有全部权限
     *      ②如果不是admin就去查用户信息和用户拥有的权限
     * [username]
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<TSysRes> resList = null;
        //查询当前登录用户信息
        TSysUser tSysUser = tSysUserService.findByUsername(username);
        if (tSysUser != null)
        {
            SysUserDetails sysUserDetails = new SysUserDetails();
            BeanUtils.copyProperties(tSysUser, sysUserDetails);
            //处理账户名密码 昵称等
            sysUserDetails.setNickName(tSysUser.getNickName());
            sysUserDetails.setUsername(tSysUser.getUserName());
            sysUserDetails.setPassword(tSysUser.getPassWord());
            //用户的组级ID
            sysUserDetails.setAncestorId(tSysUser.getAncestorId());

            // 角色集合
            Set<GrantedAuthority> authorities = new HashSet<>();
            //管理员账户
            if("admin".equals(username))
            {
                //admin用户拥有全部系统资源权限
                resList = tSysResMapper.selectList(new QueryWrapper<>());
                for (TSysRes sysRes : resList) {
                    if (StringUtil.isNotEmpty(sysRes.getPermission())) {
                        authorities.add(new SimpleGrantedAuthority("res_" + sysRes.getPermission()));
                    }
                }
            }else
            {
                //当前用户有的资源集合
                resList = tSysResService.findResByUserId(String.valueOf(sysUserDetails.getId()));
                if(resList != null && 0 < resList.size()){
                    for (TSysRes sysRes : resList)
                    {
                        if (StringUtil.isNotEmpty(sysRes.getPermission()))
                        {
                            authorities.add(new SimpleGrantedAuthority("res_" + sysRes.getPermission()));
                        }
                    }
                }
            }
            sysUserDetails.setAuthorities(authorities);

            //获取用户租户代码字符串
            String tenantCodePermission = tSysUserService.getTenantCodeByUserId(tSysUser.getId());
            sysUserDetails.setTenantCodePermission(tenantCodePermission);
            return sysUserDetails;
        }
        return null;
    }
}

