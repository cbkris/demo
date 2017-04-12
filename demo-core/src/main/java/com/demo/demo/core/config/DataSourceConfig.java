package com.demo.demo.core.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by cb on 2017/4/12.
 */
@Configuration
public class DataSourceConfig {
    /**
     * 配置多数据源,使用一个作为主数据源
     * @return
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource mainDataSource(){
        return DataSourceBuilder.create().build();
    }

   // @Bean
   // @ConfigurationProperties(prefix = "spring.datasource.other")
    public DataSource otherDataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     * 配置EntityManager,同样要指定
     * @param builder
     * @return
     */
    @Bean(name = "mainEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean mainEntityManagerFactory(EntityManagerFactoryBuilder builder){
        LocalContainerEntityManagerFactoryBean emfb = builder
                .dataSource(mainDataSource())
                .packages("com.demo.demo.core")
                .persistenceUnit("main")
                .build();
//        Properties properties = new Properties();
//        properties.setProperty("spring.jpa.hibernate.naming.implicit-strategy","org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy");
//        properties.setProperty("spring.jpa.hibernate.naming.physical-strategy","org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy");
//        emfb.setJpaProperties(properties);
        return emfb;
    }
    //@Bean(name = "otherEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean otherEntityManagerFactory(EntityManagerFactoryBuilder builder){
        LocalContainerEntityManagerFactoryBean emfb = builder
                .dataSource(otherDataSource())
                .packages("com.demo.demo.core")
                .persistenceUnit("other")
                .build();
        return emfb;
    }

    /**
     * 配置两个事务管理
     * @param builder
     * @return
     */
    @Bean(name = "mainTransactionManager")
    @Primary
    public PlatformTransactionManager mainTransactionManager(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(mainEntityManagerFactory(builder).getObject());
    }

    //@Bean(name = "otherTransactionManager")
    public PlatformTransactionManager otherTransactionManager(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(otherEntityManagerFactory(builder).getObject());
    }

}
