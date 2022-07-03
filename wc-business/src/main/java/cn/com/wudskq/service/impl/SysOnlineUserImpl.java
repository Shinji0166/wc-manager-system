package cn.com.wudskq.service.impl;

import cn.com.wudskq.constants.SystemConstants;
import cn.com.wudskq.model.SysOnlineUser;
import cn.com.wudskq.model.query.SysOnlineUserQueryDTO;
import cn.com.wudskq.service.SysOnlineUserServie;
import cn.com.wudskq.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author chenfangchao
 * @title: SysOnlineUserImpl
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/7/3 1:07 AM
 */
@Service
public class SysOnlineUserImpl implements SysOnlineUserServie {

    @Autowired
    private RedisUtil redisUtil;


    @Override
    public List<SysOnlineUser> getSysOnlineUserList(SysOnlineUserQueryDTO query) {
        //分页获取redis在线用户数据
        Set<Object> result =redisUtil.rangeByLimit(SystemConstants.OLINE_USER_KEY, query.getPageNum(), query.getPageSize());

        List<SysOnlineUser> collect = result.stream().map(SysOnlineUser::new).collect(Collectors.toList());

        //进行条件查询
        List<SysOnlineUser> onlineUserList = collect.stream().filter((SysOnlineUser onlineUser) -> {
            //&&关系
            if (!"".equals(query.getNickName()) && null != query.getNickName()
                    && !"".equals(query.getIp()) && null != query.getIp()) {
                boolean equals = onlineUser.getNickName().contains(query.getNickName());
                boolean equals1 = onlineUser.getLoginIp().contains(query.getIp());
                if(equals && equals1){
                    return true;
                }else{
                    return false;
                }
            }
            if (!"".equals(query.getNickName()) && null != query.getNickName()) {
                boolean equals = onlineUser.getNickName().contains(query.getNickName());
                return equals;
            }
            if (!"".equals(query.getIp()) && null != query.getIp()) {
                boolean equals = onlineUser.getLoginIp().contains(query.getIp());
                return equals;
            }
            //过滤出在线用户
            return onlineUser.getStatus() == 0;
        }).collect(Collectors.toList());

        return onlineUserList;
    }
}
