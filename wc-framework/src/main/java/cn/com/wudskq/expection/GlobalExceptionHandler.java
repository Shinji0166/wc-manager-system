package cn.com.wudskq.expection;

import cn.com.wudskq.vo.Response;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chenfangchao
 * @title: GlobalExpectionHandler
 * @projectName wc-manager-system
 * @description: TODO 全局异常处理
 * @date 2022/6/24 10:47 AM
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(value = Exception.class)
    public Response handle(Exception e){
        logger.error("系统日志",e);
        return Response.error(500,"业务繁忙");
    }

    //业务异常
    @ExceptionHandler(value = BusinessException.class)
    public Response handleBusinessException(BusinessException e){
        logger.error("业务日志",e);
        BusinessException businessException = e;
        return  Response.error(businessException.getCode(),businessException.getMessage());
    }

    //访问权限不足异常
    @ExceptionHandler(value = AccessDeniedException.class)
    public Response handlePermissionDenied(AccessDeniedException e){
        return  Response.error(403,"访问权限不足");
    }

    //用户名或密码错误
    @ExceptionHandler(value = BadCredentialsException.class)
    public Response handleBadCredentialsException(BadCredentialsException e){
        return  Response.error(500,"用户名或密码错误");
    }

    //空指针异常
    @ExceptionHandler(value = NullPointerException.class)
    public Response handleNullPointerException(NullPointerException e){
        return  Response.error(500,"空指针异常");
    }

    //数据库字段超长
    @ExceptionHandler(value = MysqlDataTruncation.class)
    public Response handleMysqlDataTruncation(MysqlDataTruncation e){
        return  Response.error(500,"数据库字段超长");
    }
}
