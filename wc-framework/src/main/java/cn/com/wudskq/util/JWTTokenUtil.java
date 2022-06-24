package cn.com.wudskq.util;

import cn.com.wudskq.config.JWTConfig;
import cn.com.wudskq.expection.BusinessException;
import cn.com.wudskq.model.SysUserDetails;
import cn.com.wudskq.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;
 

/**
 * @author wudskq
 */
@Slf4j
public class JWTTokenUtil {
 
    /**
     * 创建Token
     * @param sysUserDetails 用户信息
     * @return
     */
    public static String createAccessToken(SysUserDetails sysUserDetails) {
        String token =
                //设置JWT 用户Id
                Jwts.builder().setId(sysUserDetails.getId())//主题
                .setSubject(sysUserDetails.getUsername())
                .setIssuedAt(new Date()) // 签发时间
                .setIssuer("wudskq") // 签发者
                .setExpiration(new Date(System.currentTimeMillis() + JWTConfig.expiration)) // 过期时间
                .signWith(SignatureAlgorithm.HS512, JWTConfig.secret) // 签名算法、密钥
                .claim("authorities", JSON.toJSONString(sysUserDetails.getAuthorities())).compact(); // 自定义其他属性，如用户组织机构ID，用户所拥有的角色，用户权限信息等
        return JWTConfig.tokenPrefix + token;
    }
 
    /**
     * 解析Token
     * @param token Token信息
     * @return
     */
    public static SysUserDetails parseAccessToken(String token) {
        SysUserDetails sysUserDetails = null;
        if (StringUtils.isNotEmpty(token)) {
            try {
                // 去除JWT前缀
                token = token.substring(JWTConfig.tokenPrefix.length());
 
                // 解析Token
                Claims claims = Jwts.parser().setSigningKey(JWTConfig.secret).parseClaimsJws(token).getBody();

                //验证Token是否过期                              1656086556000
                long currentTimeMillis = System.currentTimeMillis();
                Date expiration = claims.getExpiration();
                if(currentTimeMillis > expiration.getTime()){
                    throw new BusinessException(500,"Token已过期!请重新登录");
                }

                // 获取用户信息
                sysUserDetails = new SysUserDetails();
                sysUserDetails.setId(claims.getId());
                sysUserDetails.setUsername(claims.getSubject());
                // 获取角色
                Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
                String authority = claims.get("authorities").toString();
                if (StringUtils.isNotEmpty(authority)) {
                    List<Map<String, String>> authorityList = JSON.parseObject(authority,
                            new TypeReference<List<Map<String, String>>>() {
                            });
                    for (Map<String, String> role : authorityList) {
                        if (!role.isEmpty()) {
                            authorities.add(new SimpleGrantedAuthority(role.get("authority")));
                        }
                    }
                }
                sysUserDetails.setAuthorities(authorities);
            } catch (Exception e) {
                log.error("解析Token异常：" + e);
            }
        }
        return sysUserDetails;
    }
 
}

