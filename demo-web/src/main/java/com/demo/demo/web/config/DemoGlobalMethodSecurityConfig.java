package com.demo.demo.web.config;

import com.demo.demo.web.security.DemoPermissionEvaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * Created by cb on 2017/4/4.
 * 添加hasPermission实现逻辑,否则会默认返回false
 */
public class DemoGlobalMethodSecurityConfig extends GlobalMethodSecurityConfiguration {
   /*
    @Autowired
    DemoPermissionEvaluator permissionEvaluator;
    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(permissionEvaluator);
        return expressionHandler;
    }
    */
}
