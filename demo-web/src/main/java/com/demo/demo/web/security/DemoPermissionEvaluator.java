package com.demo.demo.web.security;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by cb on 2017/4/1.
 * 为了给hasPermission()提供实现逻辑,先不写
 */
//@Component
public class DemoPermissionEvaluator implements PermissionEvaluator {
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        authentication.getAuthorities().contains("ADMIN_AUTHORITY");
        return false;
    }

    /**
     * 通过目标ID来判断
     * 不使用
     * @param authentication
     * @param targetId
     * @param targetType
     * @param permission
     * @return
     */
    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}
