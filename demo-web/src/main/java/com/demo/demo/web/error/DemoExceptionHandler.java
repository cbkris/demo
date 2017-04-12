package com.demo.demo.web.error;

import com.demo.demo.core.exception.DemoException;
import com.demo.demo.core.exception.ErrorEnum;
import com.demo.demo.web.config.DemoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by cb on 2017/3/23.
 * 统一异常处理
 */
@ControllerAdvice
public class DemoExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(DemoExceptionHandler.class);

    @ExceptionHandler(Throwable.class)
    //@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Throwable throwable) {
        logger.debug("请求异常路径{}",request.getRequestURL());
        /**
         * 如果是自定义异常,那么返回自定义的错误码
         */
        if (throwable instanceof DemoException) {
            DemoException exception = (DemoException) throwable;
            return new DemoResponse(exception.getCode(), exception.getMessage());
        }
        throwable.printStackTrace();
        return new DemoResponse(ErrorEnum.FAILED.code(), throwable.getMessage());
    }
}
