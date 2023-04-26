package com.f1fanclub.apimvp.config.webclient

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders.CONTENT_TYPE
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.reactive.function.client.ExchangeFilterFunction
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono

@Configuration
class WebClientConfig(
    @Value("\${app.api.baseUrl.f1}") private val f1ApiBaseUrl: String,
) {

    private val log: Logger = LoggerFactory.getLogger(WebClientConfig::class.java)

    @Bean
    fun webClient(builder: WebClient.Builder): WebClient =
        builder
            .baseUrl(f1ApiBaseUrl)
            .defaultHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
            .filter(WebClientLogging())
//            .filter(logResponseFilter())
            .build()

    private fun logResponseFilter(): ExchangeFilterFunction =
        ExchangeFilterFunction.ofResponseProcessor { response ->
            if (log.isDebugEnabled) {
                log.info("Response status: ${response.statusCode()}")
                response.bodyToMono<String>().doOnNext { body ->
                    log.debug("Response body: $body")
                }.then(Mono.just(response))
            } else {
                Mono.just(response)
            }
        }
}
