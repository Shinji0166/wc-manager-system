package cn.com.wudskq.service.impl;

import cn.com.wudskq.annotation.DataSource;
import cn.com.wudskq.enums.DataSourceType;
import cn.com.wudskq.mapper.TSysUserMapper;
import cn.com.wudskq.model.TSysUser;
import cn.com.wudskq.model.query.UserInfoQueryDTO;
import cn.com.wudskq.service.TSysUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TSysUserServiceImpl implements TSysUserService {

    @Resource
    private TSysUserMapper tSysUserMapper;
 

    @Override
    public TSysUser findByUsername(String username) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name",username);
        return tSysUserMapper.selectOne(queryWrapper);
    }

    @Override
    @DataSource(DataSourceType.SLAVE)
    public List<TSysUser> getUserInfoList(UserInfoQueryDTO userInfoQuery) {
        PageHelper.startPage(userInfoQuery.getPageNum(),userInfoQuery.getPageSize());
        return tSysUserMapper.getUserInfoList(userInfoQuery);
    }
}

