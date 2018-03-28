package cn.loverqi.star.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger
 * @author loverqi
 * @date 2018年1月5日
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("cn.loverqi.star.web.controller")).paths(PathSelectors.any())
                .build();
    }

    //构建 api文档的详细信息函数
    private ApiInfo apiInfo() {
        return new ApiInfo("star快速开发平台前后端接口文档", //标题
                "前后端接口主要使用给安卓、ios、微信公众平台、微信小程序和支付小程序及前后端分离模式的开发。", //描述
                "1.0", //版本号
                "http://localhost:8080/", //服务地址
                "loverqi", //作者
                "mail", //链接文字
                "http://mail.loverqi.cn/" //链接地址
        );
    }
}