package com.demo.demo.core.exception;

/**
 * Created by cb on 2017/4/11.
 */
public class PasswordErrorException extends DemoException{
    public PasswordErrorException(){
        super(ErrorEnum.PASSWORD_ERROR_EXCEPTION.code(),ErrorEnum.PASSWORD_ERROR_EXCEPTION.message());
    }
}
