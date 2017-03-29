package com.demo.demo.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by cb on 2017/3/29.
 */
@Table(name = "user_product")
@Data
public class UserToProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "state")
    private Byte state;
    @Column(name = "create_time")
    private Date createTime;
}
