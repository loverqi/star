package cn.loverqi.star;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ServletComponentScan
@SpringBootApplication
@MapperScan("cn.loverqi.star.mapper")
public class StarApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StarApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(StarApplication.class);
    }
}
