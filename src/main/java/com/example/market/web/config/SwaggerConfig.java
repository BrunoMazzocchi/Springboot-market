package com.example.market.web.config;


import org.springframework.context.annotation.*;
import springfox.documentation.builders.*;
import springfox.documentation.spi.*;
import springfox.documentation.spring.web.plugins.*;
import springfox.documentation.swagger2.annotations.*;

@Configuration //Para habilitar swagger
@EnableSwagger2
public class SwaggerConfig {

    @Bean //
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.market.web.controller"))
                .build();
    }
}
