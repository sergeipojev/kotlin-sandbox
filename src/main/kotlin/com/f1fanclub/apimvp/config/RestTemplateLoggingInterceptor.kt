package com.f1fanclub.apimvp.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpRequest
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.client.ClientHttpResponse
import java.io.IOException
import java.nio.charset.StandardCharsets.UTF_8

class RestTemplateLoggingInterceptor(
    private val objectMapper: ObjectMapper,
) : ClientHttpRequestInterceptor {

    private val log: Logger = LoggerFactory.getLogger(RestTemplateLoggingInterceptor::class.java)

    override fun intercept(
        request: HttpRequest,
        body: ByteArray,
        execution: ClientHttpRequestExecution,
    ): ClientHttpResponse {
        logRequest(request, body)
        return execution.execute(request, body).also { logResponse(it) }
    }

    @Throws(IOException::class)
    private fun logRequest(request: HttpRequest, body: ByteArray) {
        if (log.isDebugEnabled) {
            log.debug("===Rest template log request start===")
            log.debug("URI: {}", request.uri)
            log.debug("Method: {}", request.method)
            log.debug("Headers: {}", request.headers)
            log.debug("Request body: {}", String(body, UTF_8))
            log.debug("===Rest template log request end===")
        }
    }

    @Throws(IOException::class)
    private fun logResponse(response: ClientHttpResponse) {
        if (log.isDebugEnabled) {
            log.debug("===Rest template log response start===")
            log.debug("Status code: {}", response.statusCode)
            log.debug("Status text: {}", response.statusText)
            log.debug("Headers: {}", response.headers)
            log.debug(
                "Response body: {}",
                objectMapper
                    .readTree(response.body.bufferedReader(UTF_8).readText())
                    .toPrettyString(),
            )
            log.debug("===Rest template log response end===")
        }
    }
}
