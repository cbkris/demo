package com.demo.demo.core.repository;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by cb on 2017/3/29.
 */
public interface OnlyCustomer {
    String getCustomer();
    //暴露虚拟的属性
    @Value("#{target.problem}")
    String getQuestion();
    //还可以拼接属性
    @Value("#{target.support} #{target.feedback}")
    String getFullInfo();
}
