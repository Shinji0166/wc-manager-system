package cn.com.wudskq.service;

import cn.com.wudskq.model.TSysRes;
import java.util.List;

/**
 * @author wudskq
 */
public interface TSysResService {
 
    List<TSysRes> findResByUserId(String userId);
 
}

