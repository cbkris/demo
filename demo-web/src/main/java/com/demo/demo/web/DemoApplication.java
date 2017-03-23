package com.demo.demo.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by cb on 2017/3/23.
 * 启动类
 */
@EnableJpaRepositories
@SpringBootApplication(scanBasePackages = "com.demo.demo")
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
