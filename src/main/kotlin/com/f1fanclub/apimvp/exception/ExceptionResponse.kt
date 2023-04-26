package com.f1fanclub.apimvp.exception

import org.springframework.http.HttpStatus

data class ExceptionResponse(
    val message: String?,
    val statusCode: Int,
    val httpStatus: HttpStatus
)
