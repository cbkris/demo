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
public class Label {
    @Id
    @Column(name = "label_id", nullable = false)
    private Integer labelId;
    @Basic
    @Column(name = "label_name", nullable = false, length = 128)
    private String labelName;
    @Basic
    @Column(name = "label_type", nullable = false)
    private Byte labelType;
    @Basic
    @Column(name = "label_state", nullable = false)
    private Byte labelState;
    @Basic
    @Column(name = "description", nullable = false, length = 256)
    private String description;
    @Basic
    @Column(name = "create_time", nullable = false)
    private Timestamp createTime;

}
