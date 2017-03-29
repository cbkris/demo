package com.demo.demo.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by cb on 2017/3/29.
 */
@EnableSpringDataWebSupport
@Configuration
public class DemoWebConfig extends WebMvcConfigurerAdapter{
}
