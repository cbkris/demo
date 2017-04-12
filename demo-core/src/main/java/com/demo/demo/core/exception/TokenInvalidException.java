package com.demo.demo.core.exception;

/**
 * Created by cb on 2017/4/11.
 */
public class TokenInvalidException extends DemoException {
    public TokenInvalidException() {
        super(ErrorEnum.TOKEN_INVALID_EXCEPTION.code(),ErrorEnum.TOKEN_INVALID_EXCEPTION.message());
    }
}
