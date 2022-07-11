package cn.com.wudskq.service.impl;

import cn.com.wudskq.mapper.TSysUserMapper;
import cn.com.wudskq.model.TSysUser;
import cn.com.wudskq.model.query.UserInfoQueryDTO;
import cn.com.wudskq.service.TSysUserService;
import cn.com.wudskq.snowflake.IdGeneratorSnowflake;
import cn.com.wudskq.utils.Md5Util;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author wudskq
 */
@Service
public class TSysUserServiceImpl implements TSysUserService {

    @Resource
    private TSysUserMapper tSysUserMapper;

    @Resource
    private IdGeneratorSnowflake idGeneratorSnowflake;

    @Override
    public TSysUser findByUsername(String username) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name",username);
        queryWrapper.eq("status",0);
        return tSysUserMapper.selectOne(queryWrapper);
    }

    @Override
    public List<TSysUser> getUserInfoList(UserInfoQueryDTO userInfoQuery) {
        PageHelper.startPage(userInfoQuery.getPageNum(),userInfoQuery.getPageSize());
        return tSysUserMapper.getUserInfoList(userInfoQuery);
    }

    @Override
    public TSysUser getUserDetail(Long id) {
        return tSysUserMapper.getUserDetail(id);
    }

    @Override
    public void saveUser(TSysUser sysUser) {
        sysUser.setPassWord(Md5Util.MD5(sysUser.getPassWord()));
        tSysUserMapper.insert(sysUser);
    }

    @Override
    public void updateUser(TSysUser sysUser) {
        tSysUserMapper.updateById(sysUser);
    }

    @Override
    public void removeUser(List<String> ids) {
        tSysUserMapper.removeUser(ids);
    }
}

