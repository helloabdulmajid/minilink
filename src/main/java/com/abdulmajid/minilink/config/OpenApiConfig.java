package com.abdulmajid.minilink.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("MiniLink URL Shortener API")
                        .version("1.0")
                        .description("REST API for URL shortening and redirection")
                        .contact(new Contact()
                                .name("Abdul Majid")
                                .email("helloabdulmajid@gmail.com")));
    }
}