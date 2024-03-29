package com.xiao.web.init;

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
 * Created by sunjinwei on 2018/1/11.
 *
 * @author sunjinwei
 * <p>
 * 初始化 swagger
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xiao.web"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot 2.0.3 中使用Swagger2构建RESTful APIs")
                .description("更多Spring Boot相关文章请关注：https://projects.spring.io/spring-boot/")
                .termsOfServiceUrl("https://projects.spring.io/spring-boot/")
                .contact(new Contact("sunjinwei", "xx", "xx@xx"))
                .version("1.0")
                .build();
    }
}
