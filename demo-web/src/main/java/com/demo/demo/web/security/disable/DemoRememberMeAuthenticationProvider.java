package com.demo.demo.web.security.disable;

import com.demo.demo.core.login.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * Created by cb on 2017/4/7.
 * 通过cookie自动登录的Provider
 */
//@Component
public class DemoRememberMeAuthenticationProvider implements AuthenticationProvider {
    private static final Logger logger = LoggerFactory.getLogger(DemoRememberMeAuthenticationProvider.class);
    @Autowired
    UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        if (authentication instanceof RememberMeAuthenticationToken) {
//            logger.debug("通过cookie自动登录");
//            //try {
//                RememberMeAuthenticationToken token = (RememberMeAuthenticationToken) authentication;
//                //获取token值
//                String accessToken = token.getPrincipal().toString();
//                if (StringUtils.isEmpty(accessToken)) {
//                    return null;
//                }
//                //查询对应用户
//                UserMail userMail = userService.loginByToken(accessToken);
//                //加载权限
//                Set<GrantedAuthority> authorities = (Set<GrantedAuthority>) DemoAuthenticationProvider.getAuthorities(userMail);
//                UserVO vo = new UserVO();
//                vo.setId(userMail.getId());
//                vo.setUserId(userMail.getUserId());
//                vo.setUsername(vo.getUsername());
//                //传递token
//                UsernamePasswordAuthenticationToken authenticationToken =
//                        new UsernamePasswordAuthenticationToken(userMail.getMail(), userMail.getPwd(), authorities);
//                authenticationToken.setDetails(vo);
//                return authenticationToken;
//            } catch (DemoException e) {
//                return null;
//            } catch (Exception e) {
//                e.printStackTrace();
//                return null;
//            }

            //UserDetails userDetails = new SecurityUser(userMail);
            //检查是账号否有异常状态
//            DemoAuthenticationProvider.checkUser(userDetails);
//            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails.getUsername(),userDetails.getPassword(),userDetails.getAuthorities());
//            authenticationToken.setDetails(userDetails);
//            return authenticationToken;
//        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return RememberMeAuthenticationToken.class.equals(authentication);
    }
}
