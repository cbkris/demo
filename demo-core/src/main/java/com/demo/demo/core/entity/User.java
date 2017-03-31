package com.demo.demo.core.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by cb on 2017/3/30.
 */
@Data
@DynamicInsert
@DynamicUpdate
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "user_name")
    private String userName;
    @Basic
    @Column(name = "sso_id")
    private Integer ssoId;
    @Basic
    @Column(name = "user_state")
    private Byte userState;
    @Basic
    @Column(name = "auth_time")
    private Timestamp authTime;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "identity_card")
    private String identityCard;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "agent_id")
    private String agentId;
    @Basic
    @Column(name = "agent_name")
    private String agentName;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "graduate_time")
    private Date graduateTime;
    @Basic
    @Column(name = "education")
    private String education;
    @Basic
    @Column(name = "university")
    private String university;
    @Basic
    @Column(name = "create_time")
    private Timestamp createTime;
    @Basic
    @Column(name = "icon")
    private String icon;

}
