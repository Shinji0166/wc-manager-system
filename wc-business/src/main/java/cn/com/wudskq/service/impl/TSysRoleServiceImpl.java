package cn.com.wudskq.service.impl;

import cn.com.wudskq.annotation.DataSource;
import cn.com.wudskq.enums.DataSourceType;
import cn.com.wudskq.mapper.TSysRoleMapper;
import cn.com.wudskq.model.TSysRole;
import cn.com.wudskq.model.query.RoleInfoQueryDTO;
import cn.com.wudskq.service.TSysRoleService;
import cn.com.wudskq.snowflake.IdGeneratorSnowflake;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wudskq
 */
@Service
public class TSysRoleServiceImpl implements TSysRoleService {

    @Autowired
    private TSysRoleMapper sysRoleMapper;

    @Autowired
    private IdGeneratorSnowflake idGeneratorSnowflake;

    @Override
    @DataSource(DataSourceType.MASTER)
    public List<TSysRole> getRoleInfoList(RoleInfoQueryDTO roleInfoQuery) {
        PageHelper.startPage(roleInfoQuery.getPageNum(),roleInfoQuery.getPageSize());
        return sysRoleMapper.getRoleInfoList(roleInfoQuery);
    }

    @Override
    @DataSource(DataSourceType.MASTER)
    public TSysRole getRoleDetail(Long id) {
        return sysRoleMapper.getRoleDetail(id);
    }


    @Override
    @DataSource(DataSourceType.SLAVE)
    public void saveRole(TSysRole sysRole) {
        sysRole.setId(idGeneratorSnowflake.snowflakeId());
        sysRoleMapper.insert(sysRole);
    }

    @Override
    @DataSource(DataSourceType.SLAVE)
    public void updateRole(TSysRole sysRole) {
        sysRoleMapper.updateById(sysRole);
    }

    @Override
    @DataSource(DataSourceType.SLAVE)
    public void removeRole(List<Long> ids) {
        sysRoleMapper.removeRole(ids);
    }

}

