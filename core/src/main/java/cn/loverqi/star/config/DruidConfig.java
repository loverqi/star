package cn.loverqi.star.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

import cn.loverqi.star.core.utils.StringUtil;

/**
 * druid 连接池的配置类
 * @author LoverQi
 * @date 2018年3月28日
 */
@Configuration
public class DruidConfig {

    @Value("${druid.loginUsername:star_user}")
    private String loginUsername;

    @Value("${druid.loginPassword:star_pwd}")
    private String loginPassword;

    @Value("${druid.resetEnable:false}")
    private String resetEnable;

    @Value("${druid.allow:}")
    private String allow;

    @Value("${druid.deny:}")
    private String deny;

    /**
     * 配置DataSource数据源
     * @return DataSource
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    /**
     * 配置druid的管理Servlet
     * @return druidServlet
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> druidServlet() {
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<StatViewServlet>();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");
        Map<String, String> initParameters = getInitParameters();
        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;
    }

    /**
     * 配置druid的拦截器Filter
     * @return filterRegistration
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> filterRegistrationBean() {
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<WebStatFilter>();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.txt,*.ico,/druid/*");
        return filterRegistrationBean;
    }

    /**
     * 根据配置文件配置生成配置对象的方法
     * @return 配置对象
     */
    private Map<String, String> getInitParameters() {
        Map<String, String> initParameters = new HashMap<String, String>();
        //用户名
        initParameters.put("loginUsername", loginUsername);
        //密码
        initParameters.put("loginPassword", loginPassword);
        // 禁用HTML页面上的“Reset All”功能
        if (StringUtil.isNotNull(resetEnable) && resetEnable.equals("true")) {
            initParameters.put("resetEnable", "true");
        } else {
            initParameters.put("resetEnable", "false");
        }
        // IP白名单 (没有配置或者为空，则允许所有访问)
        initParameters.put("allow", allow);
        // IP黑名单 (存在共同时，deny优先于allow)
        initParameters.put("deny", deny);

        return initParameters;
    }

}
