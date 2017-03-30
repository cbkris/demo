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
    private String labelName;
    private Byte labelType;
    private Byte labelState;
    private String description;
    private Date createTime;
}
