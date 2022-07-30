package cn.com.wudskq.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;


/**
 * @author chenfangchao
 * @title: SysUserDetails
 * @projectName wc-manager-system
 * @description: TODO 系统用户详情
 * @date 2022/6/23 10:56 AM
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserDetails extends TSysUser implements UserDetails, Serializable {

    private static final long serialVersionUID = 1L;

    /** 当前账号ID **/
    private String currentUserId;

    /** 多租户代码字符(为控制查询数据使用) **/
    private String tenantCodePermission;

    /** 账号 **/
    private String username;

    /** 密码 **/
    private String password;

    @ApiModelProperty("用户权限")
    private Collection <GrantedAuthority> authorities;

    @ApiModelProperty("账号是否过期")
    private boolean isAccountNonExpired = false;
 
    @ApiModelProperty("账号是否锁定")
    private boolean isAccountNonLocked = false;

    @ApiModelProperty("证书是否过期")
    private boolean isCredentialsNonExpired = false;
 
    @ApiModelProperty("账号是否有效(启用-禁用)")
    private boolean isEnabled = true;

    @ApiModelProperty(value = "jti")
    private String jti;

    @ApiModelProperty(value = "token过期时间")
    private Long expirationTime;
 
    @ApiModelProperty("获得用户权限")
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
 
    /**
     * 判断账号是否过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }
 
    /**
     * 判断账号是否锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }
 
    /**
     * 判断证书是否过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    /**
     * 判断账号是否有效
     */
    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
 
}

