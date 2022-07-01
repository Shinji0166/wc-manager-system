package cn.com.wudskq.service.impl;

import cn.com.wudskq.annotation.DataSource;
import cn.com.wudskq.enums.DataSourceType;
import cn.com.wudskq.mapper.TSysUserMapper;
import cn.com.wudskq.model.TSysUser;
import cn.com.wudskq.model.query.UserInfoQueryDTO;
import cn.com.wudskq.service.TSysUserService;
import cn.com.wudskq.snowflake.IdGeneratorSnowflake;
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
//    @DataSource(DataSourceType.MASTER)
    public TSysUser findByUsername(String username) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name",username);
        return tSysUserMapper.selectOne(queryWrapper);
    }

    @Override
//    @DataSource(DataSourceType.MASTER)
    public List<TSysUser> getUserInfoList(UserInfoQueryDTO userInfoQuery) {
        PageHelper.startPage(userInfoQuery.getPageNum(),userInfoQuery.getPageSize());
        return tSysUserMapper.getUserInfoList(userInfoQuery);
    }

    @Override
//    @DataSource(DataSourceType.MASTER)
    public TSysUser getUserDetail(Long id) {
        return tSysUserMapper.getUserDetail(id);
    }

    @Override
//    @DataSource(DataSourceType.SLAVE)
    public void saveUser(TSysUser sysUser) {
        tSysUserMapper.insert(sysUser);
    }

    @Override
//    @DataSource(DataSourceType.SLAVE)
    public void updateUser(TSysUser sysUser) {
        tSysUserMapper.updateById(sysUser);
    }

    @Override
//    @DataSource(DataSourceType.SLAVE)
    public void removeUser(List<String> ids) {
        tSysUserMapper.removeUser(ids);
    }
}

