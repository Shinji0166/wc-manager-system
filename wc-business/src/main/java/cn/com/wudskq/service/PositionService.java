package cn.com.wudskq.service;

import cn.com.wudskq.model.Position;
import cn.com.wudskq.model.query.PositionQueryDTO;

import java.util.List;

/**
 * @author chenfangchao
 * @title: PositionService
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/6/28 3:33 AM
 */
public interface PositionService {

    /**
     * 获取坑位信息列表
     * @param positionQuery
     * @return
     */
    List<Position> getPositionList(PositionQueryDTO positionQuery);

    /**
     * 获取坑位详细信息
     * @param id
     * @return
     */
    Position getPositionDetail(Long id);

    /**
     * 保存坑位信息
     * @param positionInfo
     */
    void savePosition(Position positionInfo);

    /**
     * 更新坑位信息
     * @param positionInfo
     */
    void updatePosition(Position positionInfo);

    /**
     * 删除坑位信息
     * @param ids
     */
    void removePosition(List<Long> ids);
}
