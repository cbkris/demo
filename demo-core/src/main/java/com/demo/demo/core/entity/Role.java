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
    private String roleName;
    private Byte roleType;
    private Byte roleState;
    private String description;
    private Date createTime;
}
