package com.demo.demo.core.exception;

/**
 * Created by cb on 2017/3/30.
 */
public class EmailParamErrorException extends DemoException {

    public EmailParamErrorException() {
        super(ErrorEnum.EMAIL_PARAM_ERROR.code(), ErrorEnum.EMAIL_PARAM_ERROR.message());
    }
}
