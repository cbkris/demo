package com.demo.demo.core.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by cb on 2017/3/30.
 */
@Data
@Entity
@Table(name = "user_mail", schema = "titan")
public class UserMail {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "user_id", nullable = false)
    private Integer userId;
    @Basic
    @Column(name = "mail", nullable = false, length = 32)
    private String mail;
    @Basic
    @Column(name = "pwd", nullable = false, length = 32)
    private String pwd;
    @Basic
    @Column(name = "mail_type", nullable = false)
    private Byte mailType;
    @Basic
    @Column(name = "salt", nullable = false, length = 10)
    private String salt;
    @Basic
    @Column(name = "token", nullable = false, length = 20)
    private String token;
    @Basic
    @Column(name = "token_state", nullable = false)
    private Byte tokenState;
    @Basic
    @Column(name = "token_gen_time", nullable = false)
    private Timestamp tokenGenTime;
    @Basic
    @Column(name = "create_time", nullable = false)
    private Timestamp createTime;

}
