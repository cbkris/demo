package com.demo.demo.core.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by cb on 2017/3/30.
 */
@Data
@Entity
@Table(name = "user_role", schema = "titan")
public class UserRole {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "user_id", nullable = false)
    private Integer userId;
    @Basic
    @Column(name = "role_id", nullable = false)
    private Integer roleId;
    @Basic
    @Column(name = "state", nullable = false)
    private Byte state;
    @Basic
    @Column(name = "create_time", nullable = false)
    private Timestamp createTime;

}
