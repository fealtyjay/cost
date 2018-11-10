package com.hit.cost;

import io.swagger.models.Contact;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * =========================
 *
 * @Author:fealty
 * @Description:swagger文档功能配置
 * @Date：2018/11/8 10:05
 * <p>
 * Created By IDEA
 * ==========================
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Value(value = "${swagger.enabled}")
    Boolean swaggerEnabled;
    @Value(value="${swagger.user}")
    String name;
    @Value(value="${swagger.email}")
    String email;
    @Value(value="${swagger.blog}")
    String blog;
    @Value(value="${swagger.title}")
    String title;
    @Value(value="${swagger.description}")
    String description;

    @Bean
    public Docket createRestAPI(){
        return  new Docket(DocumentationType.SWAGGER_2).
                apiInfo(apiInfo()).
                enable(swaggerEnabled).
                select().
                paths(PathSelectors.any()).
                build().
                pathMapping("/");
    }
    private ApiInfo apiInfo(){
        return  new ApiInfoBuilder().
                title(title).
                description(description).
                contact(createContact()).
                version("1.0.0").
                build();
    }
    private  String createContact(){
        Contact contact = new Contact();
        contact.setName(name);
        contact.setEmail(email);
        contact.setUrl(blog);
        return contact.toString();
    }
}
