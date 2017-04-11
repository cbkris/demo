package com.demo.demo.web.security.disable;

import com.demo.demo.core.entity.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

/**
 * Created by cb on 2017/4/5.
 * 权限对象,包含了账户当前状态和具体权限信息,在SecurityContext中存的就是他
 */
public class SecurityUser extends UserMail implements UserDetails {

    public SecurityUser(){

    }

    public SecurityUser(UserMail userMail) {
        if (userMail != null) {
            this.setId(userMail.getId());
            this.setUserId(userMail.getUserId());
            this.setUser(userMail.getUser());
            this.setMail(userMail.getMail());
            this.setPwd(userMail.getPwd());
            this.setMailType(userMail.getMailType());
            this.setSalt(userMail.getSalt());
            this.setToken(userMail.getToken());
            this.setTokenState(userMail.getTokenState());
            this.setTokenGenTime(userMail.getTokenGenTime());
            this.setCreateTime(userMail.getCreateTime());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        Set<Role> roleList = this.getUser().getRoleList();
        if (roleList != null) {
            roleList.stream().forEach(role -> {
                //添加角色,只认识ROLE_开头的
                SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + role.getRoleName());
                authorities.add(grantedAuthority);
                //添加权限
                Set<Permission> permissionList = role.getPermissionList();
                if (permissionList != null) {
                    permissionList.stream().forEach(permission -> authorities.add(new SimpleGrantedAuthority(permission.getPermissionName())));
                }
            });
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return super.getPwd();
    }

    @Override
    public String getUsername() {
        return super.getUser().getUserName();
    }

    /**
     * 账户没有过期
     *
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账户没有锁定
     *
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 账户凭证没有过期
     *
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 账户没有禁用
     *
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
