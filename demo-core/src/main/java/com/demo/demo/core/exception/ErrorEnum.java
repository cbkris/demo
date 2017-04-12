package com.demo.demo.core.exception;

/**
 * Created by cb on 2017/3/23.
 * 错误枚举类
 */
public enum ErrorEnum {
    SUCCESS(0, "success"),

    PERMISSION_DENIED(10001,"权限不足"),
    EMAIL_PARAM_ERROR(20001,"邮箱参数错误"),
    EMAIL_EXISTS_EXCEPTION(20002,"邮箱已存在"),
    EMAIL_NOT_FOUND_EXCEPTION(20003,"用户名不存在"),
    PASSWORD_ERROR_EXCEPTION(20004,"密码异常"),
    PASSWORD_WRONG_EXCEPTION(20005,"密码错误"),
    TOKEN_INVALID_EXCEPTION(20006,"token无效"),


    NOT_LOGIN(30001,"未登录"),

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
