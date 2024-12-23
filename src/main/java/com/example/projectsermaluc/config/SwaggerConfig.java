package com.example.projectsermaluc.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "API Proyecto Prueba Sermaluc",
                description = "Proyecto de evaluación JAVA para Sermaluc",
                version = "1.0.0",
                contact = @Contact(
                        name = "Kevin Arnold Lozada Taboada",
                        url = "https://www.linkedin.com/in/kevinlozada/",
                        email = "kevinlozada1102@gmail.com"
                ),
                license = @License(
                        name = "MIT License",
                        url = "https://opensource.org/licenses/MIT"
                )
        ),
        servers = {
                @Server(
                        description = "DEV SERVER",
                        url = "http://localhost:8080"
                )
        }
)
public class SwaggerConfig {
}
