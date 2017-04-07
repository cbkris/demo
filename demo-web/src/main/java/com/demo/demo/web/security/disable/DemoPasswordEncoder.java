package com.demo.demo.web.security.disable;

import com.demo.demo.web.security.SecurityUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

import java.security.SecureRandom;

/**
 * Created by cb on 2017/4/7.
 * 自定义密码加密
 */
public class DemoPasswordEncoder implements PasswordEncoder {
    private static final Logger logger = LoggerFactory.getLogger(DemoPasswordEncoder.class);

    /**
     * 加密方法
     * 使用BCrypt,进行两次hash运算
     * @param rawPassword
     * @return
     */
    @Override
    public String encode(CharSequence rawPassword) {
        String password = rawPassword.toString();
        SecurityUser securityUser = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String salt = securityUser.getSalt();
        if (StringUtils.isEmpty(salt)){
            //如果数据库没有就生成一个salt
            salt = BCrypt.gensalt();
            logger.debug("生成的salt:[{}]",salt);
        }
        //进行加密
        String hashed = BCrypt.hashpw(password,salt);
        logger.debug("加密计算后的结果:[{}]",hashed);
        return hashed;
    }

    /**
     * 判断方法
     * @param rawPassword
     * @param encodedPassword
     * @return
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (rawPassword == null) {
            logger.warn("输入的密码为空");
            return false;
        }
        //利用自带的方法进行判断
        //Boolean isRight = BCrypt.checkpw(password,hashed);
        //从数据库查出salt然后加密运算来判断
        //SecurityUser userDetails = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //String salt = userDetails.getSalt();
        //String hashed = BCrypt.hashpw(rawPassword.toString(),salt);
        //logger.debug("当前密码计算结果为:[{}]",hashed);
        //return hashed.equals(encodedPassword);
        return BCrypt.checkpw(rawPassword.toString(),encodedPassword);
}
}
