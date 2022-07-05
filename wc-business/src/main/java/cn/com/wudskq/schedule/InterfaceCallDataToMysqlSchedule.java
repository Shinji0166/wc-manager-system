package cn.com.wudskq.schedule;

import cn.com.wudskq.constants.SystemConstants;
import cn.com.wudskq.mapper.SysInterfaceCallMapper;
import cn.com.wudskq.model.SysInterfaceCall;
import cn.com.wudskq.utils.RedisUtil;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;


/**
 * @author chenfangchao
 * @title: InterfaceCallDataToMysql
 * @projectName wc-manager-system
 * @description: TODO 接口调用数据同步MySQL计划
 * @date 2022/7/6 1:17 AM
 */
@Component
public class InterfaceCallDataToMysqlSchedule {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private SysInterfaceCallMapper sysInterfaceCallMapper;


    /**
     * 定时更新Redis中的接口调用数据到Mysql中
     */
    @XxlJob(value = "InterfaceCallDataUpdateMysql")
    public void interfaceCallDataUpdateMysql(){
        try {
            synchronized (this) {
                    //获取redis中的接口调用数据
                    Map<String, SysInterfaceCall> interfaceCallMap = redisUtil.hGet(SystemConstants.INTERFACE_ACTUATOR_KEY);
                    if(!interfaceCallMap.isEmpty() && 0 < interfaceCallMap.size()){
                        List<SysInterfaceCall> collect = new ArrayList<>(interfaceCallMap.values());
                        collect.forEach(obj ->{
                            //数据入库
                            sysInterfaceCallMapper.insert(obj);
                        });
                    };
                    //删除接口调用数据
                    redisUtil.remove(SystemConstants.INTERFACE_ACTUATOR_KEY);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
