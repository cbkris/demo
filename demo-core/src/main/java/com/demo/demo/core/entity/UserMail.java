package com.demo.demo.core.entity;

import lombok.Data;
import org.hibernate.annotations.*;
import org.springframework.cache.annotation.*;

import javax.persistence.*;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by cb on 2017/3/30.
 */
@Data
@DynamicInsert
@DynamicUpdate
@Entity
//@Cacheable(true)
@Table(name = "user_mail", schema = "titan")
public class UserMail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "user_id",insertable = false,updatable = false)
    private User user;
    @Basic
    //@OneToOne
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
