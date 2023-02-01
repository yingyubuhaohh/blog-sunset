package com.jin.blog.sunset.base.config;

import cn.hutool.core.util.BooleanUtil;
import org.springframework.beans.factory.annotation.Value;
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

import java.nio.file.Path;

/**
 * @Description
 * @ClassName: SwaggerConfig
 * @author: jinzelei
 * @date: 2023/1/31 14:21
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // http://localhost:8090/doc.html 推荐使用地址
    // http://localhost:8090/swagger-ui.html

    @Value("${swagger.portal.enable}")
    private Boolean portalSwaggerEnable;

    @Value("${swagger.system.enable}")
    private Boolean systemSwaggerEnable;

    private String host = "localhost:8100/";

    /**
     * 前台门户的api文档
     * @return
     */
    @Bean
    public Docket portalDocket(){
        return new Docket(DocumentationType.SWAGGER_2)// api的类型
                .apiInfo(portalApiInfo())// api文档基本信息
                //.host("150.158.107.172")// 请求路径
                .enable(portalSwaggerEnable)
                .groupName("portal")// 分组名称
                .select().apis(RequestHandlerSelectors.basePackage("com.jin.blog.sunset.portal")) //扫描包路径
                .paths(PathSelectors.any())// 展示所有接口
                .build();
    }
    public ApiInfo portalApiInfo(){
        return new ApiInfoBuilder()
                .title("前台门户")// 标题
                .contact(new Contact("jinzelei","150.158.172.107:8080","2690708525@qq.com"))// 联系方式
                .description("为博客前台准备的API文档")// 说明
                .version("1.0.0")// 版本
                .termsOfServiceUrl("150.158.172.107:8080")// 网址
                .build();
    }

    /**
     * 后台管理的api文档
     * @return
     */
    @Bean
    public Docket systemDocket(){
        //if (BooleanUtil.isTrue(systemSwaggerEnable)) return null;
        //System.out.println(systemSwaggerEnable+"&&"+portalSwaggerEnable);
        return new Docket(DocumentationType.SWAGGER_2)// api的类型
                .apiInfo(systemApiInfo())// api文档基本信息
                .enable(systemSwaggerEnable)
                .groupName("system")// 分组名称
                .select().apis(RequestHandlerSelectors.basePackage("com.jin.blog.sunset.system")) //扫描包路径
                .paths(PathSelectors.any())// 展示所有接口
                .build();
    }
    public ApiInfo systemApiInfo(){
        return new ApiInfoBuilder()
                .title("后台管理")// 标题
                .contact(new Contact("jinzelei","150.158.172.107:8090","2690708525@qq.com"))// 联系方式
                .description("为后台管理准备的API文档")// 说明
                .version("1.0.0")// 版本
                .termsOfServiceUrl("150.158.172.107:8090")// 网址
                .build();
    }

}
