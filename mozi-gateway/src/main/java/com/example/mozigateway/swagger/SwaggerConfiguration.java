package com.example.mozigateway.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
    /**
     * 创建Docket类型的对象。并使用spring容器管理。
     * Docket是Swagger中的全局配置对象。
     *
     * @return
     */
    @Bean
    public Docket docket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        //这里写的是API文档页面上的信息
        ApiInfo apiInfo = new ApiInfoBuilder()
                .contact(
                        new Contact(
                                "YiFan Dai",             //是文档的发布者名称
                                "http://alvis.club",       //文档发布者的网站地址。一般是企业网站
                                "ivan.dai@nf-3.com")     //文档发布者的电子邮箱
                )
                .title("MOZI系统开发文档")
                .description("第一个自己的线上系统。\n" +
                        "目前用到了SpringBoot+MySql+Swagger3+mybatis等技术。")
                .version("1.1")
                .build();
        //给docket上下文配置api描述信息
        docket.apiInfo(apiInfo);


        docket = docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dai.learningsystem.controller"))//用于配置，扫描哪个子包下的注解
                .paths(
                        PathSelectors.regex("/swagger/.*") //使用正则表达式，约束生成API文档的路径地址，即只有/swagger/开始的请求才生成API文档
                )
                .build();
        return docket;
    }
}
