package com.demo.demo.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by cb on 2017/4/5.
 */
@EnableRedisHttpSession
public class DemoSessionConfig {
    @Bean
    public JedisConnectionFactory connectionFactory(){
        return new JedisConnectionFactory();
    }
}
