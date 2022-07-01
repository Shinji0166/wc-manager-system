package cn.com.wudskq.web;


import cn.com.wudskq.annotation.DataSource;
import cn.com.wudskq.enums.DataSourceType;
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
//    @DataSource(DataSourceType.SLAVE)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<TSysRes> resList = null;
        //管理员账户
        if("admin".equals(username)){
            TSysUser tSysUser = new TSysUser();
            tSysUser.setId(0L);
            tSysUser.setUserName("admin");
            tSysUser.setNickName("系统管理员");
            SysUserDetails sysUserDetails = new SysUserDetails();
            BeanUtils.copyProperties(tSysUser, sysUserDetails);
            //处理账户名密码
            sysUserDetails.setUsername(tSysUser.getUserName());
            sysUserDetails.setPassword(tSysUser.getPassWord());
            // 角色集合
            Set<GrantedAuthority> authorities = new HashSet<>();
            //admin用户有的资源集合
            resList = tSysResMapper.selectList(new QueryWrapper<>());
            for (int i = 0; i < resList.size() ; i++) {
                if(StringUtil.isNotEmpty(resList.get(i).getPermission())){
                    authorities.add(new SimpleGrantedAuthority("ROLE_" + resList.get(i).getPermission()));
                }
            }
            sysUserDetails.setAuthorities(authorities);
            return sysUserDetails;
        }
        //普通用户账户
        TSysUser tSysUser = tSysUserService.findByUsername(username);
        if (tSysUser != null) {
            SysUserDetails sysUserDetails = new SysUserDetails();
            BeanUtils.copyProperties(tSysUser, sysUserDetails);
            //处理账户名密码
            sysUserDetails.setUsername(tSysUser.getUserName());
            sysUserDetails.setPassword(tSysUser.getPassWord());
            Set<GrantedAuthority> authorities = new HashSet<>(); // 角色集合
 
            resList = tSysResService.findResByUserId(String.valueOf(sysUserDetails.getId()));//当前用户有的资源集合
            if(resList != null){
                for (int i = 0; i < resList.size() ; i++) {
                    if(StringUtil.isNotEmpty(resList.get(i).getPermission())){
                        authorities.add(new SimpleGrantedAuthority("ROLE_" + resList.get(i).getPermission()));
                    }
                }
            }
            sysUserDetails.setAuthorities(authorities);
            return sysUserDetails;
        }
        return null;
    }
}

