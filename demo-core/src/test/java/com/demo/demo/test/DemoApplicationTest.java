package com.demo.demo.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by cb on 2017/3/29.
 */
@EnableSpringDataWebSupport
@EnableJpaRepositories(basePackages = "com.demo.demo.core",
        queryLookupStrategy = QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND)
@EntityScan(basePackages = "com.demo.demo.core")
@SpringBootApplication(scanBasePackages = {"com.demo.demo"},
        exclude = {
                SessionAutoConfiguration.class
        })
public class DemoApplicationTest {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplicationTest.class, args);
    }
}

