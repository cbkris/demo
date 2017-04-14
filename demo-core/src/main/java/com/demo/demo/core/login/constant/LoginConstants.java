package com.demo.demo.core.login.constant;

import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.TimeUnit;

/**
 * Created by cb on 2017/4/11.
 */
public class LoginConstants {
    public static class SESSION {
        //保存的用户的地址
        public static final String EMAIL_ADDRESS = "EMAIL_ADDRESS";
        //上次发送的时间
        public static final String EMAIL_LAST_SEND_ACTIVE_TIME = "EMAIL_LAST_SEND_ACTIVE_TIME";
        //邮箱激活code长度
        public static final int ACTIVE_CODE_LENGTH = 20;
        //邮箱激活时间
        public static final long ACTIVE_TIMEOUT = TimeUnit.MINUTES.toSeconds(2);
        //邮箱激活的URL
        public static final String ACTIVE_URL = "http://127.0.0.1:8080/active/";
    }
    public static class REDIS{
        //redis中邮箱激活的key
        public static final String REDIS_ACTIVE_CODE = "active:code:";
    }

    public static class UserMailState {
        public static final byte ACTIVE = 1;
        public static final byte INACTIVE = 0;
    }

    public static class TokenState {
        public static final byte VALID = 1;
        public static final byte INVALID = 0;
    }
}
