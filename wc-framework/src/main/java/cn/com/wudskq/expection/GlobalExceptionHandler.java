package cn.com.wudskq.expection;

import cn.com.wudskq.vo.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
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
        return Response.error(1000,"业务繁忙");
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
}
