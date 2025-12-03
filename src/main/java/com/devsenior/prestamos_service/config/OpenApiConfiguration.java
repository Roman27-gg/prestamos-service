package com.devsenior.prestamos_service.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfiguration {
    @Bean
    OpenAPI OpenApi() {
        return new OpenAPI().info(new Info().title("API de gestion de prestamos")
                .description("Sistema de gestion de prestamos de equipos tecnologicos para empleados").version("v1.0")
                .contact(new Contact()
                        .name("Juan Manuel Ramon").email("rajuanmanuel@gmail.com")))
                .servers(List.of(new Server().url("http://localhost:8080").description("Entorno de desarrollo")));
    }
}
