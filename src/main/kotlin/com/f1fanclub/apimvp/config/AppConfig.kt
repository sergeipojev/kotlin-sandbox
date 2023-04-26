package com.f1fanclub.apimvp.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories
import org.springframework.http.client.BufferingClientHttpRequestFactory
import org.springframework.http.client.ClientHttpRequestFactory
import org.springframework.http.client.SimpleClientHttpRequestFactory
import org.springframework.web.client.RestTemplate

@Configuration
@EnableReactiveMongoRepositories
class AppConfig {

    @Bean
    fun restTemplate(): RestTemplate {
        val factory: ClientHttpRequestFactory = BufferingClientHttpRequestFactory(SimpleClientHttpRequestFactory())
        val restTemplate = RestTemplate(factory)

        val loggingInterceptor = RestTemplateLoggingInterceptor(this.objetMapper())
        restTemplate.interceptors.add(loggingInterceptor)

        return restTemplate
    }

    @Bean
    fun objetMapper(): ObjectMapper {
        val mapper = ObjectMapper()
        mapper.writerWithDefaultPrettyPrinter()

        return mapper
    }

    companion object {
        val appConfig: AppConfig = AppConfig()
    }
}
