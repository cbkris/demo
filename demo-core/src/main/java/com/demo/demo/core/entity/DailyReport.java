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
    //@Column(name = "id",updatable = false)
    private Integer id;
    //运营人员
    @Column(name = "operator")
    private String operator;
    //区域id
    @Column(name = "area_id")
    private Integer areaId;
    //区域
    @Column(name = "area")
    private String area;
    //代理商id
    @Column(name = "agent_id")
    private Integer agentId;
    //代理商
    @Column(name = "agent")
    private String agent;
    //客户
    @Column(name = "customer")
    private String customer;
    //行业
    @Column(name = "industry")
    private String industry;
    //近7天日均消耗
    @Column(name = "nearly_consumed")
    private BigDecimal nearlyConsumed;
    //近7天点击
    @Column(name = "nearly_click")
    private BigDecimal nearlyClick;
    //近7天曝光
    @Column(name = "nearly_exposure")
    private BigDecimal nearlyExposure;
    //上一天客户总预算
    @Column(name = "yesterday_budget")
    private BigDecimal yesterdayBudget;
    //上一天客户总消耗
    @Column(name = "yesterday_consume")
    private BigDecimal yesterdayConsume;
    //上一天账户优化情况
    @Column(name = "yesterday_optimize")
    private String yesterdayOptimize;
    //目前存在的问题
    @Column(name = "problem")
    private String problem;
    //今日账户优化计划
    @Column(name = "today_optimize")
    private String todayOptimize;
    //需要的支持
    @Column(name = "support")
    private String support;
    //反馈情况
    @Column(name = "feedback")
    private String feedback;
    //kpi描述,
    @Column(name = "kpi")
    private String kpi;
    //kpi实际完成情况
    @Column(name = "kpi_actual")
    private String kpiActual;
    //转化成本
    @Column(name = "conversion_cost")
    private String conversionCost;
    //当前运营状态
    @Column(name = "operation_state")
    private String operationState;
    //其他信息
    @Column(name = "otherinfo")
    private String otherinfo;
    //当前记录的状态
    @Column(name = "record_state")
    private Integer recordState;
    //创建日期
    @Column(name = "create_date")
    private Date createDate;
}
