package com.demo.demo.core.exception;

/**
 * Created by cb on 2017/4/5.
 */
public class EmailExistsException extends DemoException {
    public EmailExistsException() {
        super(ErrorEnum.EMAIL_EXISTS_EXCEPTION.code(),ErrorEnum.EMAIL_EXISTS_EXCEPTION.message());
    }
}
