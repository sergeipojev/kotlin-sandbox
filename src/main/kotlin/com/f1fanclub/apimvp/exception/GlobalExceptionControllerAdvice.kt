package com.f1fanclub.apimvp.exception

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.HttpStatus.NOT_IMPLEMENTED
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.io.IOException

@ControllerAdvice
class GlobalExceptionControllerAdvice {

    @ExceptionHandler(NotImplementedError::class)
    fun handleNotFound(e: NotImplementedError): ResponseEntity<ExceptionResponse> =
        ResponseEntity(
            ExceptionResponse(
                e.message,
                NOT_IMPLEMENTED.value(),
                NOT_IMPLEMENTED,
            ),
            NOT_IMPLEMENTED,
        )

    @ExceptionHandler(IOException::class, NotFoundException::class)
    fun handleIoException(e: IOException): ResponseEntity<ExceptionResponse> =
        ResponseEntity(
            ExceptionResponse(
                e.message,
                NOT_FOUND.value(),
                NOT_FOUND,
            ),
            NOT_FOUND,
        )

    @ExceptionHandler(FeatureNotEnabledException::class)
    fun handleFeatureNotEnabledException(e: FeatureNotEnabledException): ResponseEntity<ExceptionResponse> =
        ResponseEntity(
            ExceptionResponse(
                "Feature not enabled",
                UNPROCESSABLE_ENTITY.value(),
                UNPROCESSABLE_ENTITY,
            ),
            UNPROCESSABLE_ENTITY,
        )
}
