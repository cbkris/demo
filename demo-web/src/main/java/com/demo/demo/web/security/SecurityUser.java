package com.demo.demo.web.security;

import com.demo.demo.core.entity.UserMail;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by cb on 2017/4/5.
 */
public class SecurityUser extends UserMail implements UserDetails {

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
        return null;
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
