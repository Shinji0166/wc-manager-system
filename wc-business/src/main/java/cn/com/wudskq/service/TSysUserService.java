package cn.com.wudskq.service;

import cn.com.wudskq.model.TSysUser;

public interface TSysUserService {
 
    TSysUser findByUsername(String username);
 
}

