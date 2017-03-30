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
    private String productName;
    private Byte productType;
    private Byte productState;
    private String description;
    private Date beginTime;
    private Date createTime;
}
