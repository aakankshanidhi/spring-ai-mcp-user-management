package com.springai.MCPServer.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()

                .info(new Info()
                        .title("Spring AI MCP User Management API")
                        .version("1.0")
                        .description("AI powered user management system")
                )

                .servers(List.of(
                        new Server()
                                .url("https://spring-ai-mcp-user-management-production.up.railway.app")
                ));
    }
}
