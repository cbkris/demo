package com.demo.demo.core.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by cb on 2017/3/30.
 */
@Data
@Entity
@Table(name = "user_label", schema = "titan")
public class UserLabel {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "user_id", nullable = false)
    private Integer userId;
    @Basic
    @Column(name = "label_id", nullable = false)
    private Integer labelId;
    @Basic
    @Column(name = "state", nullable = false)
    private Byte state;
    @Basic
    @Column(name = "create_time", nullable = false)
    private Timestamp createTime;

}
