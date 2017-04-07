package com.demo.demo.web.constant;

/**
 * Created by cb on 2017/4/7.
 */
public class Constants {
    /**
     * session的属性
     */
    public static class Session {
        public static final String SESSION_NAME = "demo";
    }

    /**
     * cookie的属性,用来自动实现rememberMe功能
     */
    public static class Cookie {
        public static final String REMEMBER_ME = "remember_me";
        public static final int TOKEN_LENGTH = 15;
    }
}
