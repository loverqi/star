package cn.loverqi.star.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 关于mvc的配置
 * @author loverqi
 * @date 2018年1月5日
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    @Value("${file.maxFileSize:10MB}")
    private String maxFileSize;

    @Value("${file.maxRequestSize:100MB}")
    private String maxRequestSize;

    @Value("${web.crossDomain.origin:}")
    private String[] origins;

    @Value("${web.crossDomain.maxAge:3600}")
    private long maxAge;

    @Value("${web.resources:classpath:/static/}")
    private String[] resources;

    @Value("${swagger.enable:false}")
    private boolean swaggerEnable;

    /* 
     * 配置跨域访问
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport#addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry)
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        if (origins != null && origins.length > 0) {
            registry.addMapping("/**").allowedOrigins("*").allowedMethods(origins).allowCredentials(false)
                    .maxAge(maxAge);
        }
    }

    /*
     * 配置静态资源路径
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport#addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (swaggerEnable) {
            registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
            registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        }

        //设置静态资源路径
        ResourceHandlerRegistration addResourceHandler = registry.addResourceHandler("/**");
        for (String resource : resources) {
            addResourceHandler.addResourceLocations(resource);
        }
        
        super.addResourceHandlers(registry);
    }

    /**  
     * 文件上传配置  
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大 KB,MB  
        factory.setMaxFileSize(maxFileSize);
        /// 设置总上传数据总大小  
        factory.setMaxRequestSize(maxRequestSize);
        return factory.createMultipartConfig();
    }
}