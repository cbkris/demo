package com.demo.demo.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by cb on 2017/3/29.
 */
@Table(name = "user_phone")
@Data
public class UserToPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",updatable = false,nullable = false)
    private Integer id;
    private Integer userId;
    private String phone;
    private String pwd;
    private Byte phoneType;
    private String salt;
    private String token;
    private Byte tokenState;
    private Date tokenGenTime;
    private Date createTime;
}








