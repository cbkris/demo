package com.demo.demo.web.security.disable;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * Created by cb on 2017/4/1.
 * 不启用
 * 自定义AuthenticationManager
 */
//@Component
public class DemoAuthenticationManager implements AuthenticationManager{
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }
}