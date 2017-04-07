package com.demo.demo.web.security.disable;

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
