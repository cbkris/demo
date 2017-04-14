package com.demo.demo.web.login.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by cb on 2017/4/10.
 */
@Data
public class UserLoginVO {
    @NotNull
    String mail;
    @NotNull
    String pwd;
}
