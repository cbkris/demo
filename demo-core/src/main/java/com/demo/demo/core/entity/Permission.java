package com.demo.demo.core.entity;

import lombok.*;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by cb on 2017/3/30.
 */
@Data
@Entity
public class Permission {
    @Id
    @Column(name = "permission_id", nullable = false)
    private Integer permissionId;
    @Basic
    @Column(name = "permission_name", nullable = false, length = 64)
    private String permissionName;
    @Basic
    @Column(name = "permission_type", nullable = false)
    private Byte permissionType;
    @Basic
    @Column(name = "permission_state", nullable = false)
    private Byte permissionState;
    @Basic
    @Column(name = "description", nullable = false, length = 256)
    private String description;
    @Basic
    @Column(name = "create_time", nullable = false)
    private Timestamp createTime;

}
