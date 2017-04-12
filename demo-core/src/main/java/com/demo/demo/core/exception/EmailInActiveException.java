package com.demo.demo.core.exception;

/**
 * Created by cb on 2017/4/12.
 */
public class EmailInActiveException extends DemoException {
    public EmailInActiveException() {
        super(ErrorEnum.EMAIL_INACTIVE_EXCEPTION.code(),ErrorEnum.EMAIL_INACTIVE_EXCEPTION.message());
    }
}
