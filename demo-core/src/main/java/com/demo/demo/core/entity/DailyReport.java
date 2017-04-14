package com.demo.demo.core.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by cb on 2017/3/28.
 */
@Entity
@Data
@DynamicUpdate
@DynamicInsert
@Table(name = "daily_report")
public class DailyReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Integer id;
    @Column(name = "operator")
    private String operator;
    @Column(name = "area_id")
    private String areaId;
    @Column(name = "area")
    private String area;
    @Column(name = "agent_id")
    private Integer agentId;
    @Column(name = "agent")
    private String agent;
    @Column(name = "customer")
    private String customer;
    @Column(name = "industry")
    private String industry;
    @Column(name = "nearly_consumed")
    private BigDecimal nearlyConsumed;
    @Column(name = "nearly_click")
    private BigDecimal nearlyClick;
    @Column(name = "nearly_exposure")
    private BigDecimal nearlyExposure;
    @Column(name = "yesterday_budget")
    private BigDecimal yesterdayBudget;
    @Column(name = "yesterday_consume")
    private BigDecimal yesterdayConsume;
    @Column(name = "yesterday_optimize")
    private String yesterdayOptimize;
    @Column(name = "problem")
    private String problem;
    @Column(name = "today_optimize")
    private String todayOptimize;
    @Column(name = "support")
    private String support;
    @Column(name = "feedback")
    private String feedback;
    @Column(name = "kpi")
    private String kpi;
    @Column(name = "kpi_actual")
    private String kpiActual;
    @Column(name = "conversion_cost")
    private String conversionCost;
    @Column(name = "operation_state")
    private String operationState;
    @Column(name = "otherinfo")
    private String otherinfo;
    @Column(name = "record_state")
    private Integer recordState;
    @Column(name = "create_date")
    private Date createDate;
}
