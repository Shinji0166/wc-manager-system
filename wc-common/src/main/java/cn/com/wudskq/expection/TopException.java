package cn.com.wudskq.expection;

import cn.com.wudskq.vo.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class TopException {
 
    private Logger logger = LoggerFactory.getLogger(this.getClass());
 
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response handle(Exception e){
 
        if(e instanceof BusinessException){
            logger.error("业务日志",e);
            BusinessException myException = (BusinessException) e;
            return  Response.error(myException.getCode(),myException.getMessage());
        }else if(e instanceof AccessDeniedException){
            return  Response.error(403,"访问权限不足");
        }
 
        logger.error("系统日志",e);
        return Response.error(1000,"业务繁忙");
    }
}

