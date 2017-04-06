package com.demo.demo.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by cb on 2017/4/5.
 * 不需要配置Factory,会根据配置文件生成
 */
@EnableRedisHttpSession
public class DemoSessionConfig {

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        return new JedisConnectionFactory();
    }
}
