package cn.com.wudskq.service.impl;

import cn.com.wudskq.annotation.DataSource;
import cn.com.wudskq.enums.DataSourceType;
import cn.com.wudskq.mapper.TSysResMapper;
import cn.com.wudskq.mapper.TSysRoleMapper;
import cn.com.wudskq.mapper.TSysRoleResMapper;
import cn.com.wudskq.model.TSysRes;
import cn.com.wudskq.model.TSysRole;
import cn.com.wudskq.model.query.ResInfoQueryDTO;
import cn.com.wudskq.service.TSysResService;
import cn.com.wudskq.snowflake.IdGeneratorSnowflake;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 

/**
 * @author wudskq
 */
@Service
public class TSysResServiceImpl implements TSysResService {
 
    @Resource
    private TSysResMapper tSysResMapper;
 
    @Resource
    private TSysRoleMapper tSysRoleMapper;
 
    @Resource
    private TSysRoleResMapper tSysRoleResMapper;

    @Autowired
    private IdGeneratorSnowflake idGeneratorSnowflake;


    /**
     * 根据用户id查询用户拥有的资源
     * [userId]
     * @return {@link List< TSysRes>}
     * @throws
     */
    @DataSource(DataSourceType.MASTER)
    @Override
    public List<TSysRes> findResByUserId(String userId) {
        //获取用户有的角色
        //根据当前登录用户获取角色
        List<TSysRole> roleList = tSysRoleMapper.findRoleByUserId(userId);
        if(roleList == null || roleList.size() == 0){ //如果用户没有角色返回没有权限
            return null;
        }
        //根据角色获取菜单资源id关系集合
        Map<String,Object> map = new HashMap<>();
        map.put("roleList",roleList);
        List<String> tSysRoleResList = tSysRoleResMapper.selectRoleResByMap(map);
        if(tSysRoleResList == null || tSysRoleResList.size() == 0){ //如果用户没有角色返回没有权限
            return null;
        }
        //根据资源id获取菜单资源
        return tSysResMapper.selectBatchIds(tSysRoleResList);
 
    }

    @Override
    @DataSource(DataSourceType.MASTER)
    public List<TSysRes> getResLIst(ResInfoQueryDTO resInfoQuery) {
        PageHelper.startPage(resInfoQuery.getPageNum(),resInfoQuery.getPageSize());
        return tSysResMapper.getResLIst(resInfoQuery);
    }

    @Override
    @DataSource(DataSourceType.MASTER)
    public TSysRes getResDetail(Long id) {
        return tSysResMapper.getResDetail(id);
    }

    @Override
    @DataSource(DataSourceType.SLAVE)
    public void saveRes(TSysRes sysRes) {
         sysRes.setId(idGeneratorSnowflake.snowflakeId());
         tSysResMapper.insert(sysRes);
    }

    @Override
    @DataSource(DataSourceType.SLAVE)
    public void updateRes(TSysRes sysRes) {
        tSysResMapper.updateById(sysRes);
    }

    @Override
    @DataSource(DataSourceType.SLAVE)
    public void removeRes(List<Long> ids) {
        tSysResMapper.removeRes(ids);
    }
}


