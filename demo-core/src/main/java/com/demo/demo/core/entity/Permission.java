package com.demo.demo.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by cb on 2017/3/29.
 */
@Table(name = "permission")
@Data
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "permission_id",updatable = false,nullable = false)
    private Integer permissionId;
    @Column(name = "permission_name")
    private String permissionName;
    @Column(name = "permission_type")
    private Byte permissionType;
    @Column(name = "permission_state")
    private Byte permissionState;
    @Column(name = "description")
    private String description;
    @Column(name = "create_time")
    private Date createTime;
}
