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
    private String permissionName;
    private Byte permissionType;
    private Byte permissionState;
    private String description;
    private Date createTime;
}
