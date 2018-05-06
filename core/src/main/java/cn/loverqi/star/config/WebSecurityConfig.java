package cn.loverqi.star.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import cn.loverqi.star.core.security.lnterceptor.DynamicFilterSecurityInterceptor;

/**
 * Spring Security配置
 * @author loverqi
 * @date 2018年1月12日
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${security.enable:false}")
    private boolean enable;

    @Value("${swagger.enable:false}")
    private boolean swaggerEnable;

    @Value("${security.iframe:false}")
    private boolean iframeEnable;

    @Value("${security.csrf:true}")
    private boolean csrf;

    @Value("${security.formLogin.enable:false}")
    private boolean formLoginEnable;
    @Value("${security.formLogin.skipModel:redirect}")
    private String skipModel;
    @Value("${security.formLogin.loginPage:/login.html}")
    private String loginPage;
    @Value("${security.formLogin.loginProcessingUrl:/login.do}")
    private String loginProcessingUrl;
    @Value("${security.formLogin.defaultSuccessUrl:/index.html}")
    private String defaultSuccessUrl;
    @Value("${security.formLogin.failureUrl:/login.html?error=true}")
    private String failureUrl;
    @Value("${security.formLogin.usernameParameter:username}")
    private String usernameParameter;
    @Value("${security.formLogin.passwordParameter:password}")
    private String passwordParameter;

    @Value("${security.logout.enable:false}")
    private boolean logoutEnable;
    @Value("${security.logout.logoutUrl:/unlogin.do}")
    private String logoutUrl;
    @Value("${security.logout.logoutSuccessUrl:/login.html}")
    private String logoutSuccessUrl;

    @Value("${security.formLogin.rememberMe.enable:false}")
    private boolean rememberMeEnable;
    @Value("${security.formLogin.rememberMe.key:loverqi_star}")
    private String key;
    @Value("${security.formLogin.rememberMe.rememberMeParameter:remember-me}")
    private String rememberMeParameter;
    @Value("${security.formLogin.rememberMe.tokenValiditySeconds:604800}")
    private int tokenValiditySeconds;

    @Value("${security.sessionManagement.enable:false}")
    private boolean sessionManagementEnable;
    @Value("${security.sessionManagement.maximumSessions:1}")
    private int maximumSessions;
    @Value("${security.sessionManagement.expiredUrl:/login.html}")
    private String expiredUrl;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /** 注入默认错误处理类返回类*/
    @Autowired
    private LoginUrlAuthenticationEntryPoint loginUrlAuthenticationEntryPoint;

    /** 注入自定义拦截去从数据库读取配置文件*/
    @Autowired
    private DynamicFilterSecurityInterceptor dynamicFilterSecurityInterceptor;

    /**
     * 设置页面跳转方式为转发
     */
    @Bean
    public LoginUrlAuthenticationEntryPoint loginUrlAuthenticationEntryPoint() {

        LoginUrlAuthenticationEntryPoint loginUrlAuthenticationEntryPoint = new LoginUrlAuthenticationEntryPoint(
                loginPage);
        loginUrlAuthenticationEntryPoint.setUseForward(true);
        return loginUrlAuthenticationEntryPoint;
    }

    /**
     * 配置认证方式
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        if (enable) {
            auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        if (enable) {
            http.authorizeRequests() //开启认证规则配置
                    .anyRequest().authenticated(); //其他所有路径都是需要认证/登录后才能访问

            //自定义拦截去从数据库读取配置文件
            http.addFilterBefore(dynamicFilterSecurityInterceptor, FilterSecurityInterceptor.class);

            if (formLoginEnable) {
                if ("forward".equals(skipModel)) {
                    //将默认的重定向方式修改为转发的形式
                    http.exceptionHandling().authenticationEntryPoint(loginUrlAuthenticationEntryPoint);
                } else {
                    //默认的重定向方式      
                    http.formLogin().loginPage(loginPage);
                }

                //登录处理路径       
                http.formLogin().loginProcessingUrl(loginProcessingUrl)
                        //登录用户名为username，密码为password
                        .usernameParameter(usernameParameter).passwordParameter(passwordParameter)
                        //设置默认登录成功跳转页面
                        .defaultSuccessUrl(defaultSuccessUrl)
                        //设置默认登录失败跳转页面
                        .failureUrl(failureUrl).permitAll();
            }

            //退出登陆页的配置
            if (logoutEnable) {
                //默认注销行为为logout，可以通过下面的方式来修改
                http.logout().logoutUrl(logoutUrl)
                        //设置注销成功后跳转页面，默认是跳转到登录页面
                        .logoutSuccessUrl(logoutSuccessUrl).permitAll();
            }

            //记住用户登陆信息
            if (formLoginEnable && rememberMeEnable) {
                //开启cookie保存用户数据
                http.rememberMe().rememberMeParameter(rememberMeParameter)
                        //设置cookie有效期
                        .tokenValiditySeconds(tokenValiditySeconds)
                        //设置cookie的私钥
                        .key(key);
            }

            //限制用户登陆次数
            if (sessionManagementEnable) {
                http.sessionManagement().maximumSessions(maximumSessions).expiredUrl(expiredUrl);
            }

            //是否启用csrf
            if (!csrf) {
                http.csrf().disable();
            }

            //设置允许iframe跨域
            if (iframeEnable) {
                http.headers().frameOptions().disable();
            }
        }
    }

    /*
     * 设置权限框架的忽略资源
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        if (enable) {
            web.ignoring().antMatchers("/static/**", "/druid/**", "/**/*.jpg", "/**/*.gif", "/**/*.png", "/**/*.css",
                    "/**/*.ttf", "/**/*.woff", "/**/*.js");
            if (swaggerEnable) {
                web.ignoring().antMatchers("/swagger-resources/**", "/v2/api-docs/**", "/webjars/**",
                        "/swagger-ui.html");
            }
        } else {
            web.ignoring().anyRequest();
        }
    }

}