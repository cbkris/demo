package com.demo.demo.web.login.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;

/**
 * Created by cb on 2017/3/30.
 */
@Data
public class UserRegisterVO {
    @NotNull
    @Email(regexp = "\\w+@\\w+\\.\\w+")
    private String mail;
    @NotNull
    private String pwd;
}
