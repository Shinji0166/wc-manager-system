package cn.com.wudskq.plugins;

import cn.com.wudskq.config.JWTConfig;
import cn.com.wudskq.constants.SystemConstants;
import cn.com.wudskq.model.SysUserDetails;
import cn.com.wudskq.model.TSysUser;
import cn.com.wudskq.snowflake.IdGeneratorSnowflake;
import cn.com.wudskq.utils.JWTTokenUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author chenfangchao
 * @title: MybatisPlusPlugin
 * @projectName wc-manager-system
 * @description: TODO MybatisPlus插入及更新时公共字段处理
 * @date 2022/7/2 2:05 AM
 */
@Configuration
public class MybatisPlusPlugin implements MetaObjectHandler {

    @Resource
    private IdGeneratorSnowflake idGeneratorSnowflake;

    Logger logger = LoggerFactory.getLogger(getClass());

    //使用mp实现添加操作,这个方法会执行,metaObject元数据(表中的名字,表中的字段)
    @Override
    public void insertFill(MetaObject metaObject) {
        //获取HttpRequest
        ServletRequestAttributes attributes  = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = null;
        if(null != attributes){
            request = attributes.getRequest();
        }
        if(null != request){
            String requestURI = request.getRequestURI();
            //如果为登录操作则跳过以下逻辑
            if(!SystemConstants.SYSTEM_LOGIN_URI.equals(requestURI)){
                TSysUser currentOperatorUser = getCurrentOperatorUser();
                if(null != currentOperatorUser){
                    this.setFieldValByName("createBy",currentOperatorUser.getNickName(),metaObject);
                }
            }
        }
        //所有ID使用雪花算法
        this.setFieldValByName("id",idGeneratorSnowflake.snowflakeId(),metaObject);
        //新增时status默认为0(未删除状态)
        this.setFieldValByName("status",0,metaObject);
        this.setFieldValByName("createTime",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        TSysUser currentOperatorUser = getCurrentOperatorUser();
        if(null != currentOperatorUser){
            this.setFieldValByName("updateBy",currentOperatorUser.getNickName(),metaObject);
        }
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }

    //获取当前操作人信息
    public TSysUser getCurrentOperatorUser(){
        TSysUser tSysUser = new TSysUser();
        try {
            //获取HttpRequest
            ServletRequestAttributes attributes  = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = null;
            if(null != attributes){
                request = attributes.getRequest();
            }
            String token = null;
            if(null != request){
                //获取当前操作的用户token
                token = request.getHeader(JWTConfig.tokenHeader);
            }
            if(null != token){
                //解析token
                SysUserDetails sysUserDetails = JWTTokenUtil.parseAccessToken(token);
                //是否为管理员,管理员直接跳过查询
                if(!"admin".equals(sysUserDetails.getUsername())){
                    tSysUser.setNickName(sysUserDetails.getNickName());
                }else {
                    tSysUser.setNickName("系统管理员");
                }
            }else {
                tSysUser.setNickName("系统");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tSysUser;
    }
}
