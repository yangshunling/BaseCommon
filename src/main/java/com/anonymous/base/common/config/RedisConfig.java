package com.anonymous.base.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * <p>
 * RedisConfig Redis配置类
 * </p>
 *
 * @author Anonymous
 * @since 2024/12/13 19:34
 */
@Configuration
public class RedisConfig {

    /**
     * RedisTemplate 配置
     *
     * @param redisConnectionFactory redis连接工厂
     * @return RedisTemplate
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        // 设置 key 的序列化方式
        template.setKeySerializer(new StringRedisSerializer());
        // 设置 value 的序列化方式
        template.setValueSerializer(new GenericToStringSerializer<>(Object.class));
        // 设置 hash key 的序列化方式
        template.setHashKeySerializer(new StringRedisSerializer());
        // 设置 hash value 的序列化方式
        template.setHashValueSerializer(new GenericToStringSerializer<>(Object.class));
        return template;
    }
}
