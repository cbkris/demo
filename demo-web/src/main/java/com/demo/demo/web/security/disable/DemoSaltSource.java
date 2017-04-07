package com.demo.demo.web.security.disable;

import com.demo.demo.web.security.SecurityUser;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * Created by cb on 2017/4/7.
 * 实现自己的salt
 */
//@Component
public class DemoSaltSource implements SaltSource {
    /**
     * 从权限对象中获取salt
     * @param user
     * @return
     */
    @Override
    public Object getSalt(UserDetails user) {
        if (user instanceof SecurityUser) {
            SecurityUser securityUser = (SecurityUser) user;
            return securityUser.getSalt();
        }
        return null;
    }
}
