package com.demo.demo.web.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * Created by cb on 2017/4/1.
 * 自定义AuthenticationManager
 */
//@Component
public class DemoAuthenticationManager implements AuthenticationManager{
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }
}
