package com.demo.demo.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by cb on 2017/3/29.
 */
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id",updatable = false,nullable = false)
    private Integer productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_type")
    private Byte productType;
    @Column(name = "product_state")
    private Byte productState;
    @Column(name = "description")
    private String description;
    @Column(name = "begin_time")
    private Date beginTime;
    @Column(name = "create_time")
    private Date createTime;
}
