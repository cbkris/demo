package com.demo.demo.core.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by cb on 2017/3/30.
 */
@Data
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "user_mail", schema = "titan")
public class UserMail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "mail")
    private String mail;
    @Basic
    @Column(name = "pwd")
    private String pwd;
    @Basic
    @Column(name = "mail_type")
    private Byte mailType;
    @Basic
    @Column(name = "salt")
    private String salt;
    @Basic
    @Column(name = "token")
    private String token;
    @Basic
    @Column(name = "token_state")
    private Byte tokenState;
    @Basic
    @Column(name = "token_gen_time")
    private Timestamp tokenGenTime;
    @Basic
    @Column(name = "create_time")
    private Timestamp createTime;

}
