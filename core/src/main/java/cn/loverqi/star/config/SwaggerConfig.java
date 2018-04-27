package cn.loverqi.star.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger的基本配置类
 * @author loverqi
 * @date 2018年1月5日
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.show:false}")
    private boolean swaggerShow;

    @Value("${swagger.basePackage:cn.loverqi.star.web.controller}")
    private String basePackage;

    @Value("${swagger.title:star快速开发平台对外开放接口API文档}")
    private String title;

    @Value("${swagger.description:对外开放接口API文档主要使用于安卓、ios、微信公众平台、微信小程序和支付小程序及前后端分离模式的开发。}")
    private String description;

    @Value("${swagger.termsOfServiceUrl:http://localhost:8080/}")
    private String termsOfServiceUrl;

    @Value("${swagger.version:1.0}")
    private String version;

    @Value("${swagger.license:loverqi.cn}")
    private String license;

    @Value("${swagger.licenseUrl:https://github.com/loverqi/star}")
    private String licenseUrl;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).enable(swaggerShow).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage(basePackage)).paths(PathSelectors.any()).build();
    }

    //构建 api文档的详细信息函数
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(title).description(description).version(version).license(license)
                .licenseUrl(licenseUrl).build();

    }
}