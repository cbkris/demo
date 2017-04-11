package com.demo.demo.core.exception;

/**
 * Created by cb on 2017/4/11.
 */
public class PasswordWrongException extends DemoException {
    public PasswordWrongException(){
        super(ErrorEnum.PASSWORD_WRONG_EXCEPTION.code(),ErrorEnum.PASSWORD_WRONG_EXCEPTION.message());
    }
}
