package com.demo.demo.web.security;

import com.demo.demo.core.entity.UserMail;
import com.demo.demo.core.repository.user.UserMailRepository;
import com.demo.demo.core.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by cb on 2017/4/1.
 *
 * 用在加载在SecurityContext的Authentication中的具有权限的对象
 */
@Component
public class DemoUserDetailsService implements UserDetailsService {
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(mail)) {
            throw new UsernameNotFoundException("账号为空");
        }
        UserMail userMail = userService.findByMail(mail);
        if (userMail == null) {
            throw new UsernameNotFoundException("账号:"+mail+",不存在");
        }
        UserDetails securityUser = new SecurityUser(userMail);
        return securityUser;
    }
}
