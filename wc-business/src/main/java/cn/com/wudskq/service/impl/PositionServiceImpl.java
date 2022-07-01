package cn.com.wudskq.service.impl;

import cn.com.wudskq.annotation.DataSource;
import cn.com.wudskq.enums.DataSourceType;
import cn.com.wudskq.mapper.PositionMapper;
import cn.com.wudskq.model.Position;
import cn.com.wudskq.model.query.PositionQueryDTO;
import cn.com.wudskq.service.PositionService;
import cn.com.wudskq.snowflake.IdGeneratorSnowflake;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenfangchao
 * @title: PositionServiceImpl
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/28 3:33 AM
 */
@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionMapper positionMapper;

    @Resource
    private IdGeneratorSnowflake idGeneratorSnowflake;

    @Override
//    @DataSource(DataSourceType.MASTER)
    public List<Position> getPositionList(PositionQueryDTO positionQuery) {
        PageHelper.startPage(positionQuery.getPageNum(),positionQuery.getPageSize());
        return positionMapper.getPositionList(positionQuery);
    }

    @Override
//    @DataSource(DataSourceType.MASTER)
    public Position getPositionDetail(Long id) {
        return positionMapper.getPositionDetail(id);
    }

    @Override
//    @DataSource(DataSourceType.SLAVE)
    public void savePosition(Position positionInfo) {
        positionInfo.setStatus(0);
        positionInfo.setId(idGeneratorSnowflake.snowflakeId());
        positionMapper.insert(positionInfo);
    }

    @Override
//    @DataSource(DataSourceType.SLAVE)
    public void updatePosition(Position positionInfo) {
        positionMapper.updateById(positionInfo);
    }

    @Override
//    @DataSource(DataSourceType.SLAVE)
    public void removePosition(List<Long> ids) {
        positionMapper.removePosition(ids);
    }
}
