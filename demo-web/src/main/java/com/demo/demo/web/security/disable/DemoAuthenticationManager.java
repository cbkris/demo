package com.demo.demo.web.security.disable;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Created by cb on 2017/4/1.
 * 不启用
 * 自定义AuthenticationManager
 */
//@Component
public class DemoAuthenticationManager implements AuthenticationManager{
    List<AuthenticationProvider> providers = Collections.emptyList();;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        return null;
    }
}
