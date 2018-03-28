package cn.loverqi.star.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring Security配置
 * @author loverqi
 * @date 2018年1月12日
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //    @Autowired
    //    private UserDetailsService userDetailsService;
    //
    //    /** 注入登录成功的返回类*/
    //    @Autowired
    //    private AuthenticationSuccessHandler authenticationSuccessHandler;
    //
    //    /** 注入登录成功的返回类*/
    //    @Autowired
    //    private AuthenticationFailureHandler authenticationFailureHandler;
    //
    //    /** 注入退出登录的返回类*/
    //    @Autowired
    //    private LogoutSuccessHandler logoutSuccessHandler;
    //
    //    /** 注入权限验证失败的的返回类*/
    //    @Autowired
    //    private AccessDeniedHandler accessDeniedHandler;
    //
    //    /** 注入默认错误处理类返回类*/
    //    @Autowired
    //    private LoginUrlAuthenticationEntryPoint loginUrlAuthenticationEntryPoint;
    //
    //    /** 注入自定义拦截去从数据库读取配置文件*/
    //    @Autowired
    //    private DynamicFilterSecurityInterceptor dynamicFilterSecurityInterceptor;
    //
    //    /** 用于密码加密的类*/
    //    @Autowired
    //    private PasswordEncoder passwordEncoder;
    //
    //    /**
    //     * 配置认证方式
    //     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
    //     */
    //    @Override
    //    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //
    //        //传入userDetailsService后，会在用户登录时自动调用loadUserByUsername方法在
    //        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    //    }
    //
    //    /**
    //     * 密码加密的类
    //     */
    //    @Bean
    //    public PasswordEncoder passwordEncoder() {
    //        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(4);
    //        return passwordEncoder;
    //    }
    //
    //    /**
    //     * 设置页面跳转方式为转发
    //     */
    //    @Bean
    //    public LoginUrlAuthenticationEntryPoint loginUrlAuthenticationEntryPoint() {
    //
    //        LoginUrlAuthenticationEntryPoint loginUrlAuthenticationEntryPoint = new LoginUrlAuthenticationEntryPoint(
    //                "/login/notLogin.do");
    //        loginUrlAuthenticationEntryPoint.setUseForward(true);
    //        return loginUrlAuthenticationEntryPoint;
    //    }
    //
    //    /**
    //     * 配置认证规则
    //     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
    //     */
    //    @Override
    //    protected void configure(HttpSecurity http) throws Exception {
    //    	
    //    	http.headers().frameOptions().disable();
    //
    //        //将默认的重定向方式修改为转发的形式
    //        http.exceptionHandling().authenticationEntryPoint(loginUrlAuthenticationEntryPoint);
    //
    //        //权限认证失败的返回类
    //        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    //
    //        //自定义拦截去从数据库读取配置文件
    //        http.addFilterBefore(dynamicFilterSecurityInterceptor, FilterSecurityInterceptor.class);
    //
    //        http.authorizeRequests() //开启认证规则配置
    //                .anyRequest().authenticated() //其他所有路径都是需要认证/登录后才能访问
    //                .and().formLogin()
    //                //返回登录成功
    //                .successHandler(authenticationSuccessHandler)
    //                //返回登陆了失败
    //                .failureHandler(authenticationFailureHandler)
    //                //登录处理路径
    //                .loginProcessingUrl("/login/userLogin.do").usernameParameter("username").passwordParameter("password") //登录用户名为username，密码为password
    //                .permitAll().and().logout()
    //                //退出登录处理路径
    //                .logoutUrl("/login/userUnlogin.do").logoutSuccessUrl("/login/unloginSuccess.do")
    //                .logoutSuccessHandler(logoutSuccessHandler).permitAll().and().csrf().disable();
    //
    //        //限制用户登陆次数，目前无法解决重定向的问题
    //        http.sessionManagement().maximumSessions(1).expiredUrl("/login/notLogin.do");
    //    }
    //    @Override
    //    public void configure(WebSecurity web) throws Exception {
    //        //设置忽略资源
    //        web.ignoring().antMatchers("/static/**", "/druid/**",
    //                "/**/*.html", "/v2/api-docs/**", "/webjars/**", "/swagger-resources/**", "/**/*.png");
    //    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //设置忽略资源
        web.ignoring().anyRequest();
    }

}