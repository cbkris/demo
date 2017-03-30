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
    @Column(name = "user_name")
    private String userName;
    @Column(name = "sso_id")
    private Integer ssoId;
    @Column(name = "user_state")
    private Byte userState;
    @Column(name = "auth_time")
    private Date authTime;
    @Column(name = "name")
    private String name;
    @Column(name = "identity_card")
    private String identityCard;
    @Column(name = "phone")
    private String phone;
    @Column(name = "agent_id")
    private String agentId;
    @Column(name = "agent_name")
    private String agentName;
    @Column(name = "description")
    private String description;
    @Column(name = "graduration_time")
    private Date gradurationTime;
    @Column(name = "education")
    private String education;
    @Column(name = "univercity")
    private String university;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "icon")
    private String icon;
}
