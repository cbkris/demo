package com.demo.demo.web.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cb on 2017/4/6.
 * 实现RememberService接口
 */
public class DemoRememberMeService implements RememberMeServices {
    @Override
    public Authentication autoLogin(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @Override
    public void loginFail(HttpServletRequest request, HttpServletResponse response) {

    }

    /**
     * 这个是在登录成功后调用的,发送一个cookie,用于下次登录
     * @param request
     * @param response
     * @param successfulAuthentication
     */
    @Override
    public void loginSuccess(HttpServletRequest request, HttpServletResponse response, Authentication successfulAuthentication) {
        //生成一串字符串作为token

    }
}
