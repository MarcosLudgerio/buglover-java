package br.minsait.rmarcosgon.appPessoas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.minsait.rmarcosgon.appPessoas"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }
    public ApiInfo metaInfo(){
        ApiInfo appinfo = new ApiInfo(
                "App Pessoa",
                "API Rest com um CRUD básico de pessoas",
                "1.0.0",
                "Terms of Services",
                new Contact("Marcos Ludgério", "https://github.com/MarcosLudgerio", "rmarcosgon@minsait.com.br"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
        return appinfo;
    }
}
