package com.demo.demo.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by cb on 2017/3/28.
 */
@Entity
@Data
@Table(name = "daily_report")
public class DailyReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",updatable = false)
    private Integer id;
    private String operator;
    private Integer areaId;
    private String area;
    private Integer agentId;
    private String agent;
    private String customer;
    private String industry;
    private BigDecimal nearlyConsumed;
    private BigDecimal nearlyClick;
    private BigDecimal nearlyExposure;
    private BigDecimal yesterdayBudget;
    private BigDecimal yesterdayConsume;
    private String yesterdayOptimize;
    private String problem;
    private String todayOptimize;
    private String support;
    private String feedback;
    private String kpi;
    private String kpiActual;
    private String conversionCost;
    private String operationState;
    private String otherinfo;
    private Integer recordState;
    private Date createDate;
}
