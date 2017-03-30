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
public class Product {
    @Id
    @Column(name = "product_id", nullable = false)
    private Integer productId;
    @Basic
    @Column(name = "product_name", nullable = false, length = 128)
    private String productName;
    @Basic
    @Column(name = "product_type", nullable = false)
    private Byte productType;
    @Basic
    @Column(name = "product_state", nullable = false)
    private Byte productState;
    @Basic
    @Column(name = "description", nullable = false, length = 256)
    private String description;
    @Basic
    @Column(name = "begin_time", nullable = false)
    private Timestamp beginTime;
    @Basic
    @Column(name = "create_time", nullable = false)
    private Timestamp createTime;

}
