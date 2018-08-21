package com.demo.yunfei.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author: yunfei
 * @Date: 2018/8/21 10:19
 */
@Configuration
public class Swagger2 {

    @Value("${swagger.enable}")
    private Boolean enableSwagger;

    public Docket creatRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).enable(enableSwagger)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.demo.yunfei"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("yunfei")
                .description("API文档以及示例")
                .termsOfServiceUrl("www.yunfei.com")
                .version("1.0")
                .build();
    }

}
