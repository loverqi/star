package cn.loverqi.star.config;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import cn.loverqi.star.core.serializer.ObjectRedisSerializer;

/**
 * redis配置
 * @author loverqi
 * @date 2018年1月4日
 */
@Configuration
@EnableCaching
public class RedisConfig {

    /**
     * 配置Redis操作类
     */
    @Bean
    public RedisTemplate<Serializable, Serializable> redisTemplate(@Autowired RedisConnectionFactory connectionFactory) {
        RedisTemplate<Serializable, Serializable> template = new RedisTemplate<Serializable, Serializable>();
        template.setConnectionFactory(connectionFactory);
        template.afterPropertiesSet();
        // redis存取对象的关键配置
        template.setKeySerializer(new StringRedisSerializer());
        // ObjectRedisSerializer类为java对象的序列化和反序列化工具类
        template.setValueSerializer(new ObjectRedisSerializer());
        return template;
    }
}
