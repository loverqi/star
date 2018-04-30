package cn.loverqi.star.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 注入密码加密类
 * @author LoverQi
 * @date 2018年3月28日
 */
@Configuration
public class PasswordEncoderConfig {

    /**
     * 密码加密的类
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }
}
