package com.demo.demo.web.security;

import com.demo.demo.web.utils.IPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cb on 2017/4/5.
 * 登录成功处理,拿到具有权限的authentication,将这个放入SecurityContext中,并显示登录信息
 */
@Component
public class DemoLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private static final Logger logger = LoggerFactory.getLogger(DemoLoginSuccessHandler.class);
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        logger.debug("执行LoginSuccessHandler的认证成功");
        //将认证后的信息存入上下文,以便于其他地方使用
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //显示登录信息
        //UserDetails securityUser = (UserDetails) authentication.getPrincipal();

        logger.info("用户:[{}]已登录,IP地址:{}", authentication.getPrincipal(), IPUtil.getIp(request));
        //重定向到另一个页面
        //redirectStrategy.sendRedirect(request, response, request.getPathInfo());
        response.sendRedirect("/user/index");
        //super.onAuthenticationSuccess(request,response,authentication);
    }

}
