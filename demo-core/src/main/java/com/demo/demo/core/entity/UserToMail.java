package com.demo.demo.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by cb on 2017/3/29.
 */
@Table(name = "user_mail")
@Data
public class UserToMail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",updatable = false,nullable = false)
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "mail")
    private String mail;
    @Column(name = "pwd")
    private String pwd;
    @Column(name = "mail_type")
    private Byte mailType;
    @Column(name = "salt")
    private String salt;
    @Column(name = "token")
    private String token;
    @Column(name = "token_state")
    private Byte tokenState;
    @Column(name = "token_gen_time")
    private Date tokenGenTime;
    @Column(name = "create_time")
    private Date createTime;
}
