package com.demo.demo.web.error;

import com.demo.demo.core.exception.DemoException;
import com.demo.demo.core.exception.ErrorEnum;
import com.demo.demo.web.config.DemoResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by cb on 2017/3/23.
 * 统一异常处理
 */
@ControllerAdvice
public class DemoExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Throwable throwable) {
        if (throwable instanceof DemoException) {
            DemoException exception = (DemoException) throwable;
            return new DemoResponse(exception.getCode(), exception.getMessage());
        }
        return new DemoResponse(ErrorEnum.FAILED.code(), throwable.getMessage());
    }
}
