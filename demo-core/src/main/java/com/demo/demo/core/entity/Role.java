package com.demo.demo.core.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by cb on 2017/3/30.
 */
@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id", nullable = false)
    private Integer roleId;
    @Basic
    @Column(name = "role_name", nullable = false, length = 64)
    private String roleName;
    @Basic
    @Column(name = "role_type", nullable = false)
    private Byte roleType;
    @Basic
    @Column(name = "role_state", nullable = false)
    private Byte roleState;
    @Basic
    @Column(name = "description", nullable = false, length = 128)
    private String description;
    @Basic
    @Column(name = "create_time", nullable = false)
    private Timestamp createTime;

}
