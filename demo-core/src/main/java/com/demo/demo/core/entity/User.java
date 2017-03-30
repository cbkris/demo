package com.demo.demo.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by cb on 2017/3/29.
 */
@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id",updatable = false,nullable = false)
    private Integer userId;
    private String userName;
    private Integer ssoId;
    private Byte userState;
    private Date authTime;
    private String name;
    private String identityCard;
    private String phone;
    private String agentId;
    private String agentName;
    private String description;
    private Date gradurationTime;
    private String education;
    private String university;
    private Date createTime;
    private String icon;
}
