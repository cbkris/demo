package com.demo.demo.core.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

/**
 * Created by cb on 2017/3/30.
 */
@Data
@DynamicInsert
@DynamicUpdate
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    private Set<UserRole> userRole;

    //@Transient
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    //@JoinTable name是中间表的表明
    //@JoinColumn name是中间表中的字段名,reference是关联表中的字段名
    @JoinTable(name = "user_role",
            joinColumns = {
                @JoinColumn(name = "user_id",referencedColumnName = "user_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "role_id",referencedColumnName = "role_id")}
    )
    private Set<Role> roleList;
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
