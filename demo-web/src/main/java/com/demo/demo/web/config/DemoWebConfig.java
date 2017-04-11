package com.demo.demo.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by cb on 2017/3/29.
 */

@Configuration
public class DemoWebConfig extends WebMvcConfigurerAdapter{
    /**
     * 添加缓存静态资源
     * @param registry
     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        //registry.addResourceHandler("/resources/**").addResourceLocations("/resource/").setCachePeriod(31556926);
//        super.addResourceHandlers(registry);
//    }
}
