package com.demo.demo.core.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by cb on 2017/3/30.
 */
@Data
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "user_role", schema = "titan")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
//    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
//    private User user;
//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JoinColumn(name = "role_id",referencedColumnName = "role_id")
//    private Role role;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "role_id")
    private Integer roleId;
    @Basic
    @Column(name = "state")
    private Byte state;
    @Basic
    @Column(name = "create_time")
    private Timestamp createTime;

}
