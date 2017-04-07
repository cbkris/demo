package com.demo.demo.web.config;

/**
 * Created by cb on 2017/4/4.
 */
//@Configuration
//@EnableCaching
public class DemoCachingConfig {
//    //配置EhCacheCacheManager
//    //@Bean
//    public EhCacheCacheManager cacheManager(CacheManager cm){
//        return new EhCacheCacheManager();
//    }
//    //Redis缓存管理器bean
//    //@Bean
//    public CacheManager cacheManager(RedisTemplate redisTemplate){
//        return new RedisCacheManager(redisTemplate);
//    }
//    //Redis连接工厂配置
//    //@Bean
//    public JedisConnectionFactory jedisConnectionFactory(){
//        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
//        jedisConnectionFactory.afterPropertiesSet();
//        return jedisConnectionFactory;
//    }
//    //创建RedisTemplateBean
//    //@Bean
//    public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory redisConnectionFactory){
//        RedisTemplate<String,String> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        //设置序列化器
//        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<User>(User.class));
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }
}
