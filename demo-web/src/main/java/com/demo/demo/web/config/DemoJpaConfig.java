package com.demo.demo.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by cb on 2017/3/29.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.demo.demo.core",
        entityManagerFactoryRef = "mainEntityManagerFactory",
        transactionManagerRef = "mainTransactionManager",
        queryLookupStrategy = QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND
)
public class DemoJpaConfig {
}










