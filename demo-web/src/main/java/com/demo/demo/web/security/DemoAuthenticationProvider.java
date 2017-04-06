package com.demo.demo.web.security;

import com.demo.demo.core.entity.UserMail;
import com.demo.demo.core.repository.user.UserMailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by cb on 2017/4/1.
 * 认证的具体实现,查询数据库,配置权限
 */
@Component
public class DemoAuthenticationProvider implements AuthenticationProvider{
    @Autowired
    UserMailRepository userMailRepository;
    @Autowired
    DemoUserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //接收到的应该是由SecurityContextPersistenceFilter捕获的一个token,用来提供认证的凭证,可能有多种
        if (authentication instanceof UsernamePasswordAuthenticationToken){
            //用来处理用户名密码登录
            UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
            String mail = token.getPrincipal().toString();
            String password = token.getCredentials().toString();
            if (StringUtils.isEmpty(mail)) {
                throw new UsernameNotFoundException("用户名为空");
            }
            UserDetails userDetails = userDetailsService.loadUserByUsername(mail);
            if (!password.equals(userDetails.getPassword())){
                throw new BadCredentialsException("用户名或密码错误");
            }
            if(!userDetails.isEnabled()){
                throw new DisabledException("账号被禁用");
            }
            if (!userDetails.isAccountNonExpired()){
                throw new AccountExpiredException("账号已过期");
            }
            if (!userDetails.isAccountNonLocked()){
                throw new LockedException("账号被锁定");
            }
            if (!userDetails.isCredentialsNonExpired()){
                throw new BadCredentialsException("凭证已过期");
            }
            //加载所有权限
            return new UsernamePasswordAuthenticationToken(userDetails,userDetails.getPassword(),userDetails.getAuthorities());
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}
