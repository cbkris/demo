package com.demo.demo.web.security;

import com.demo.demo.core.utils.PwdEncoder;
import com.demo.demo.web.constant.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * Created by cb on 2017/4/6.
 * 实现RememberService接口
 */
@Component
public class DemoRememberMeService implements RememberMeServices {
    private static final Logger logger = LoggerFactory.getLogger(DemoRememberMeService.class);

    /**
     * 自动登录,获取rememberMe的cookie,生成一个RememberMeAuthenticationToken来访问
     * @param request
     * @param response
     * @return
     */
    @Override
    public Authentication autoLogin(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("尝试获得token");
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            logger.debug("cookie不存在");
            return null;
        }
        Optional<Cookie> rememberMe = Stream.of(cookies)
                .filter(cookie -> Constants.Cookie.REMEMBER_ME.equals(cookie.getName()))
                .findFirst();
        if (!rememberMe.isPresent()){
            logger.debug("cookie不存在");
            return null;
        }
        Cookie rmCookie = rememberMe.get();
        Authentication authentication = new RememberMeAuthenticationToken("remember_me",rmCookie.getValue(),null);
        return authentication;
    }

    /**
     * 登录失败,就删除所有context,
     * @param request
     * @param response
     */
    @Override
    public void loginFail(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextHolder.clearContext();
    }

    /**
     * 这个是在登录成功后调用的,发送一个cookie,用于下次登录
     *
     * @param request
     * @param response
     * @param successfulAuthentication
     */
    @Override
    public void loginSuccess(HttpServletRequest request, HttpServletResponse response, Authentication successfulAuthentication) {
        logger.debug("执行rememberService的登录成功");
        //生成一个cookie用来自动登录
        String token = PwdEncoder.genSalt();
        Cookie cookie = new Cookie(Constants.Cookie.REMEMBER_ME, "111111");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(Constants.Cookie.TOKEN_TIME);
        response.addCookie(cookie);
    }
}
