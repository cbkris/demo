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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;
    @Basic
    @Column(name = "product_name")
    private String productName;
    @Basic
    @Column(name = "product_type")
    private Byte productType;
    @Basic
    @Column(name = "product_state")
    private Byte productState;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "begin_time")
    private Timestamp beginTime;
    @Basic
    @Column(name = "create_time")
    private Timestamp createTime;

}
