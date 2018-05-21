package cn.loverqi.star.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;

/**
 * HttpSession配置
 * @author loverqi
 * @date 2018年1月4日
 */
@Configuration
@EnableSpringHttpSession
public class HttpSessionConfig {

    /**
     * 注入Lettuce工厂
     */
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
