package com.demo.demo.web.security;

import com.demo.demo.core.entity.UserMail;
import com.demo.demo.core.repository.user.UserMailRepository;
import com.demo.demo.web.security.disable.SecurityUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by cb on 2017/4/7.
 */
@Component
public class DemoRememberMeAuthenticationProvider implements AuthenticationProvider {
    private static final Logger logger = LoggerFactory.getLogger(DemoRememberMeAuthenticationProvider.class);
    @Autowired
    UserMailRepository userMailRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (authentication instanceof RememberMeAuthenticationToken){
            logger.debug("通过cookie自动登录");
            RememberMeAuthenticationToken token = (RememberMeAuthenticationToken) authentication;
            //获取token值
            String accessToken = (String) token.getPrincipal();
            //String token = "111111";
            if (StringUtils.isEmpty(accessToken)) {
                return null;
            }
            //查询对应用户
            UserMail userMail = userMailRepository.findByToken(accessToken);
            if (userMail == null) {
                throw new UsernameNotFoundException("自动登录失败");
            }
            UserDetails userDetails = new SecurityUser(userMail);
            //检查是账号否有异常状态
            DemoAuthenticationProvider.checkUser(userDetails);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails.getUsername(),userDetails.getPassword(),userDetails.getAuthorities());
            authenticationToken.setDetails(userDetails);
            return authenticationToken;
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return RememberMeAuthenticationToken.class.equals(authentication);
    }
}
