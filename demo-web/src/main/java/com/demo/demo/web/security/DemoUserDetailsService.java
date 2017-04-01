package com.demo.demo.web.security;

import com.demo.demo.core.user.service.RoleService;
import com.demo.demo.core.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;

/**
 * Created by cb on 2017/4/1.
 * 用在加载在SecurityContext的Authentication中的Principal对象
 * 加载GrantedAuthority对象数组
 */
//@Component
public class DemoUserDetailsService implements UserDetailsService{
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("用户名为空");
        }

        return null;
    }
}
