package com.demo.demo.core.exception;

/**
 * Created by cb on 2017/3/23.
 * 总异常类
 */
public class DemoException extends RuntimeException {
    private int code;

    public DemoException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
