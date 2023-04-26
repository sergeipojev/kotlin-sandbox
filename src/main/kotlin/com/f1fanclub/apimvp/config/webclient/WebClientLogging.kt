package com.f1fanclub.apimvp.config.webclient

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.reactive.function.client.ClientRequest
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.ExchangeFilterFunction
import org.springframework.web.reactive.function.client.ExchangeFunction
import reactor.core.publisher.Mono

class WebClientLogging : ExchangeFilterFunction {

    private val log: Logger = LoggerFactory.getLogger(WebClientLogging::class.java)

    override fun filter(request: ClientRequest, next: ExchangeFunction): Mono<ClientResponse> {
        log.info("Web Client: Sending request to ${request.url()} with method ${request.method()} and headers ${request.headers()}")

        return next.exchange(request)
            .doOnNext { response ->
                log.info("Web Client: Received response with status ${response.statusCode()} and headers ${response.headers()}")
            }
    }
}
