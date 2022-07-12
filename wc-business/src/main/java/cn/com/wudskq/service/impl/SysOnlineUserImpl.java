package cn.com.wudskq.service.impl;

import cn.com.wudskq.constants.SystemConstants;
import cn.com.wudskq.model.SysOnlineUser;
import cn.com.wudskq.model.query.SysOnlineUserQueryDTO;
import cn.com.wudskq.service.SysOnlineUserServie;
import cn.com.wudskq.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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
    public Map<String,Object> getSysOnlineUserList(SysOnlineUserQueryDTO query) {

        HashMap<String,Object> resMap = new HashMap<>();

        //获取redis全量在线用户数据
        Integer zSetSize = redisUtil.getZSetSize(SystemConstants.OLINE_USER_KEY);
        Set<Object> result =redisUtil.rangeByLimit(SystemConstants.OLINE_USER_KEY,1,zSetSize);

        //转换为list
        List<SysOnlineUser> collect = result.stream().map(SysOnlineUser::new).collect(Collectors.toList());

        //进行条件查询
        List<SysOnlineUser> onlineUserList = collect.stream().filter((SysOnlineUser onlineUser) -> {
            if (StringUtils.isNotBlank(query.getNickName())&& StringUtils.isNotBlank(query.getIp()))
            {
                return onlineUser.getNickName().contains(query.getNickName()) && onlineUser.getLoginIp().contains(query.getIp());
            }
            //昵称为不空时
            if (StringUtils.isNotBlank(query.getNickName()))
            {
                return onlineUser.getNickName().contains(query.getNickName());
            }
            //登录IP不为空时
            if (StringUtils.isNotBlank(query.getIp()))
            {
                return onlineUser.getLoginIp().contains(query.getIp());
            }
            //过滤出在线用户
            return onlineUser.getStatus() == 0;
        }).sorted(Comparator.comparing(SysOnlineUser::getLoginTime).reversed()).collect(Collectors.toList());

        //分页
        int pageNum = query.getPageNum();
        int pageSize = query.getPageSize();
        //总数
        int total = onlineUserList.size();
        //总页数
        int pageTotal = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
        //当前页数大于总页数时
        if ( pageNum >= pageTotal){ pageNum = pageTotal;}
        //当总页数大于总数时
        if( pageSize >= total){ pageSize = total;}
        List<SysOnlineUser> onlineUserListRes = onlineUserList.stream().skip((long) (pageNum - 1) * pageSize).limit(pageSize).
                collect(Collectors.toList());
        resMap.put("total",onlineUserList.size());
        resMap.put("data",onlineUserListRes);
        return resMap;
    }
}
