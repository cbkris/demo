package com.demo.demo.web.security;

import com.demo.demo.core.exception.ErrorEnum;
import com.demo.demo.web.config.DemoResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cb on 2017/4/1.
 * 自定义
 * 访问拒绝,权限不足Handler
 */
@Component
public class DemoAccessDeniedHandler implements AccessDeniedHandler {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setHeader(HttpHeaders.CONTENT_TYPE, "application/json;charset=utf8");
        response.getOutputStream().write(objectMapper.writeValueAsBytes(
                new DemoResponse(ErrorEnum.PERMISSION_DENIED.code(), ErrorEnum.PERMISSION_DENIED.message())
        ));
    }
}
