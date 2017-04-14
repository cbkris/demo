package com.demo.demo.web.security;

import com.demo.demo.core.entity.Permission;
import com.demo.demo.core.entity.Role;
import com.demo.demo.core.entity.UserMail;
import com.demo.demo.core.login.service.UserService;
import com.demo.demo.web.login.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cb on 2017/4/1.
 * 认证的具体实现,查询数据库,配置权限
 */
@Component
public class DemoAuthenticationProvider implements AuthenticationProvider {
    private static final Logger logger = LoggerFactory.getLogger(DemoAuthenticationProvider.class);

    @Autowired
    UserService userService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (authentication instanceof RememberMeAuthenticationToken) {
            logger.debug("通过cookie自动登录");
            //try {
            RememberMeAuthenticationToken token = (RememberMeAuthenticationToken) authentication;
            //获取token值
            String accessToken = token.getPrincipal().toString();
            if (StringUtils.isEmpty(accessToken)) {
                return null;
            }
            //查询对应用户
            UserMail userMail = userService.loginByToken(accessToken);
            //加载权限
            Set<GrantedAuthority> authorities = (Set<GrantedAuthority>) getAuthorities(userMail);
            UserVO vo = new UserVO();
            vo.setId(userMail.getId());
            vo.setUserId(userMail.getUserId());
            vo.setUsername(vo.getUsername());
            //传递token
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(userMail.getMail(), userMail.getPwd(), authorities);
            authenticationToken.setDetails(vo);
            return authenticationToken;
        }
        //接收到的应该是由SecurityContextPersistenceFilter捕获的一个token,用来提供认证的凭证,可能有多种
        if (authentication instanceof UsernamePasswordAuthenticationToken) {
            logger.debug("通过用户名密码登录");
            //try {
            //用来处理用户名密码登录
            UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
            String mail = token.getPrincipal().toString();
            String password = token.getCredentials().toString();
            //调用自己的service
            UserMail userMail = userService.loginByMail(mail, password);
            //加载权限
            Set<GrantedAuthority> authorities = (Set<GrantedAuthority>) getAuthorities(userMail);
            logger.debug("加载所有权限[{}]", authorities);

//                UserDetails userDetails = new User(mail,password,authorities);

//                UserDetails securityUser = new SecurityUser(userMail);
//              UserDetails userDetails = userDetailsService.loadUserByUsername(mail);
//              checkUser(userDetails);

            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(
                            authentication.getPrincipal(), authentication.getCredentials(), authorities);
            //把vo对象放进details里
            UserVO vo = new UserVO();
            vo.setId(userMail.getId());
            vo.setUserId(userMail.getUserId());
            vo.setUsername(userMail.getUser().getUserName());
            authToken.setDetails(vo);
            //authToken.setDetails(userDetails);
            return authToken;

//            } catch (DemoException e) {
//                return null;
//            } catch (Exception e) {
//                e.printStackTrace();
//                return null;
//            }

        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication)
                || RememberMeAuthenticationToken.class.equals(authentication);
    }

    public static Set<? extends GrantedAuthority> getAuthorities(UserMail userMail) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        Set<Role> roleList = userMail.getUser().getRoleList();
        if (roleList != null) {
            roleList.stream().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
                Set<Permission> permissions = role.getPermissionList();
                if (permissions != null) {
                    permissions.stream().forEach(permission ->
                            authorities.add(new SimpleGrantedAuthority(permission.getPermissionName())));
                }
            });
        }
        return authorities;
    }

//    /**
//     * 检查账号是否异常
//     *
//     * @param userDetails
//     */
//    public static void checkUser(UserDetails userDetails) {
//        if (!userDetails.isEnabled()) {
//            throw new DisabledException("账号被禁用");
//        }
//        if (!userDetails.isAccountNonExpired()) {
//            throw new AccountExpiredException("账号已过期");
//        }
//        if (!userDetails.isAccountNonLocked()) {
//            throw new LockedException("账号被锁定");
//        }
//        if (!userDetails.isCredentialsNonExpired()) {
//            throw new BadCredentialsException("凭证已过期");
//        }
//    }

}
