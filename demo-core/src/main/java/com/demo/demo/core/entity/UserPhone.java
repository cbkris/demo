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
@Table(name = "user_phone", schema = "titan")
public class UserPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "pwd")
    private String pwd;
    @Basic
    @Column(name = "phone_type")
    private Byte phoneType;
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
