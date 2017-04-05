package com.demo.demo.web.config;

import com.demo.demo.core.entity.User;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * Created by cb on 2017/4/4.
 */
//@Configuration
//@EnableCaching
public class DemoCachingConfig {
    //配置EhCacheCacheManager
    //@Bean
    public EhCacheCacheManager cacheManager(CacheManager cm){
        return new EhCacheCacheManager();
    }
    //Redis缓存管理器bean
    //@Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate){
        return new RedisCacheManager(redisTemplate);
    }
    //Redis连接工厂配置
    //@Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.afterPropertiesSet();
        return jedisConnectionFactory;
    }
    //创建RedisTemplateBean
    //@Bean
    public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String,String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //设置序列化器
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<User>(User.class));
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
