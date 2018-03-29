package cn.loverqi.star.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Spring Security配置
 * @author loverqi
 * @date 2018年1月12日
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    /** 用于密码加密的类*/
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 配置认证方式
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //传入userDetailsService后，会在用户登录时自动调用loadUserByUsername方法在
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    /**
     * 密码加密的类
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(4);
        return passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                //登录处理路径       
                .and().formLogin().loginPage("/login.html").loginProcessingUrl("/login.do")
                //登录用户名为username，密码为password
                .usernameParameter("username").passwordParameter("password")
                //设置默认登录成功跳转页面
                .defaultSuccessUrl("/index.html").failureUrl("/login.html?err=1").permitAll().and()
                //开启cookie保存用户数据
                .rememberMe().rememberMeParameter("remember-me")
                //设置cookie有效期
                .tokenValiditySeconds(60 * 60 * 24 * 7)
                //设置cookie的私钥
                .key("loverqi#star")
                //默认注销行为为logout，可以通过下面的方式来修改
                .and().logout().logoutUrl("/unlogin.do")
                //设置注销成功后跳转页面，默认是跳转到登录页面
                .logoutSuccessUrl("/login.html?msg=1").permitAll().and().csrf().disable()
                //限制用户登陆次数，目前无法解决重定向的问题
                .sessionManagement().maximumSessions(1).expiredUrl("/login.html?msg=2");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //设置忽略资源
        web.ignoring().antMatchers("/static/**", "/druid/**", "/swagger-resources/**", "/v2/api-docs/**", "/webjars/**",
                "/swagger-ui.html", "/**/*.jpg", "/**/*.gif", "/**/*.png", "/**/*.css", "/**/*.ttf", "/**/*.woff",
                "/**/*.js");
        //        web.ignoring().anyRequest();

    }

}