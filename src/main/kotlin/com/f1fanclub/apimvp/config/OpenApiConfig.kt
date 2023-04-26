package com.f1fanclub.apimvp.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.PathItem
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun f1OpenApiConfig(): GroupedOpenApi = GroupedOpenApi.builder()
        .group("F1 APIs Version 1")
        .pathsToMatch("/api/f1/**", "/api/heartbeat")
        .addOpenApiCustomizer {openApi ->
            openApi.info(
                Info()
                    .title("F1 Fan Club API")
                    .description("API for getting data about F1 seasons, winners, etc.")
                    .version("1.0")
            )
        }
        .build()

    @Bean
    fun f1OpenApiV2Config(): GroupedOpenApi = GroupedOpenApi.builder()
        .group("F1 APIs Version 2")
        .pathsToMatch("/api/f1/v2/**", "/api/heartbeat")
        .addOpenApiCustomizer {openApi ->
            openApi.info(
                Info()
                    .title("F1 Fan Club API")
                    .description("API for getting data about F1 seasons, winners, etc.")
                    .version("2.0")
            )
        }
        .build()
}