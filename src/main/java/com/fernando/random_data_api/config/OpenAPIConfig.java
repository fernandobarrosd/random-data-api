package com.fernando.random_data_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {
    @Bean
    OpenAPI openAPI() {
        return new OpenAPI()
        .info(
            new Info()
            .title("Random Data API")
            .description("Uma API que auxilia na geração de dados aleatórios")
            .contact(
                new Contact()
                .name("Fernando de Barros")
                .email("fdebarros0910-2004@hotmail.com")
                .url("https://github.com/fernandobarrosd"))
            );
    }
}