package com.demo.demo.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by cb on 2017/3/29.
 */
@Table(name = "label")
@Data
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "label_id",updatable = false,nullable = false)
    private Integer labelId;
    @Column(name = "label_name")
    private String labelName;
    @Column(name = "label_type")
    private Byte labelType;
    @Column(name = "label_state")
    private Byte labelState;
    @Column(name = "description")
    private String description;
    @Column(name = "create_time")
    private Date createTime;
}
