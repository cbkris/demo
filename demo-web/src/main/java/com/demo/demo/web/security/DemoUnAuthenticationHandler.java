package com.demo.demo.web.security;

import com.demo.demo.core.exception.ErrorEnum;
import com.demo.demo.web.config.DemoResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cb on 2017/4/6.
 * 认证入口点
 */
@Component
public class DemoUnAuthenticationHandler implements AuthenticationEntryPoint {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        //这个是返回错误信息
        response.setHeader(HttpHeaders.CONTENT_TYPE, "application/json;charset=utf8");
        response.getOutputStream().write(objectMapper.writeValueAsBytes(
                new DemoResponse(ErrorEnum.NOT_LOGIN.code(), ErrorEnum.NOT_LOGIN.message())
        ));
        //重定向到登录页
        //response.sendRedirect("/login");
    }
}
