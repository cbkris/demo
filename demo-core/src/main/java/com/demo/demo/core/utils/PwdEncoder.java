package com.demo.demo.core.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * Created by cb on 2017/4/11.
 */
public class PwdEncoder {
    public static String encode(String rawPassword,String salt){
        String password = BCrypt.hashpw(rawPassword,salt);
        return password;
    }
    public static String genSalt(){
        return BCrypt.gensalt();
    }
}
