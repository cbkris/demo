package com.demo.demo.core.entity;

import lombok.*;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by cb on 2017/3/30.
 */
@Data
@Entity
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    private Integer userId;
    @Basic
    @Column(name = "user_name", nullable = false, length = 32)
    private String userName;
    @Basic
    @Column(name = "sso_id", nullable = false)
    private Integer ssoId;
    @Basic
    @Column(name = "user_state", nullable = false)
    private Byte userState;
    @Basic
    @Column(name = "auth_time", nullable = false)
    private Timestamp authTime;
    @Basic
    @Column(name = "name", nullable = false, length = 32)
    private String name;
    @Basic
    @Column(name = "identity_card", nullable = false, length = 18)
    private String identityCard;
    @Basic
    @Column(name = "phone", nullable = false, length = 12)
    private String phone;
    @Basic
    @Column(name = "agent_id", nullable = false, length = 128)
    private String agentId;
    @Basic
    @Column(name = "agent_name", nullable = false, length = 64)
    private String agentName;
    @Basic
    @Column(name = "description", nullable = false, length = 256)
    private String description;
    @Basic
    @Column(name = "graduration_time", nullable = false)
    private Date gradurationTime;
    @Basic
    @Column(name = "education", nullable = false, length = 32)
    private String education;
    @Basic
    @Column(name = "univercity", nullable = false, length = 128)
    private String univercity;
    @Basic
    @Column(name = "create_time", nullable = false)
    private Timestamp createTime;
    @Basic
    @Column(name = "icon", nullable = false, length = 128)
    private String icon;

}
