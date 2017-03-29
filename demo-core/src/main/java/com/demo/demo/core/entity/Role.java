package com.demo.demo.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by cb on 2017/3/29.
 */
@Table(name = "role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id",updatable = false,nullable = false)
    private Integer roleId;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "role_type")
    private Byte roleType;
    @Column(name = "role_state")
    private Byte roleState;
    @Column(name = "description")
    private String description;
    @Column(name = "create_time")
    private Date createTime;
}
