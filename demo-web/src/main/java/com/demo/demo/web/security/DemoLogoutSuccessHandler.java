package com.demo.demo.web.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * Created by cb on 2017/4/10.
 */
@Component
public class DemoLogoutSuccessHandler implements LogoutSuccessHandler {
    private static final Logger logger = LoggerFactory.getLogger(DemoLogoutSuccessHandler.class);
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if (authentication == null) {
            redirectStrategy.sendRedirect(request, response, "/index");
            return;
        }
        logger.info("用户[{}]已退出", authentication.getPrincipal());
        //清除上下文
        SecurityContextHolder.clearContext();
        //删除session
        logger.debug("删除session");
        request.getSession().invalidate();
        //清空cookie
        logger.debug("清除cookies");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Stream.of(cookies).forEach(cookie -> {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            });
        }
        //重定向到主页
        redirectStrategy.sendRedirect(request, response, "/index");
    }
}
