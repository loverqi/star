package cn.loverqi.star.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;

/**
 * 注册MyBatis分页插件PageHelper
 * @author loverqi
 * @date 2018年1月4日
 */
@EnableSpringHttpSession
public class HttpSessionConfig {

    @Bean
    public LettuceConnectionFactory connectionFactory() {
        return new LettuceConnectionFactory();
    }

    //这是RestfulApi项目用的
    //    @Bean
    //    public HttpSessionIdResolver httpSessionIdResolver() {
    //        return HeaderHttpSessionIdResolver.xAuthToken();
    //    }
}
