package com.demo.demo.core.exception;

/**
 * Created by cb on 2017/4/11.
 */
public class EmailNotFoundException extends DemoException{
    public EmailNotFoundException() {
        super(ErrorEnum.EMAIL_NOT_FOUND_EXCEPTION.code(), ErrorEnum.EMAIL_NOT_FOUND_EXCEPTION.message());
    }
}
