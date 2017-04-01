package com.demo.demo.core.exception;

/**
 * Created by cb on 2017/3/23.
 * 错误枚举类
 */
public enum ErrorEnum {
    SUCCESS(0, "success"),
    PERMISSION_DENIED(10001,"权限不足"),
    EMAIL_PARAM_ERROR(20001,"email param error"),

    FAILED(-1, "failed");

    private int code;
    private String message;

    ErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }
}
