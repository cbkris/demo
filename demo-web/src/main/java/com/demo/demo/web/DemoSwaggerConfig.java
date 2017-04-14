package com.demo.demo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by cb on 2017/4/13.
 */
//@Configuration
//@EnableSwagger2
public class DemoSwaggerConfig {
    private static final Logger logger = LoggerFactory.getLogger(DemoSwaggerConfig.class);

    //@Bean
    public Docket createRestApi(){
        logger.info("swagger配置启动");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.demo.demo.web"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("我的项目API")
                .description("demo")
                //.termsOfServiceUrl()
                .contact(new Contact("cb","aaa","cb_kris@sina.com"))
                .version("1.0.0")
                .build();
    }

}
