package com.f1fanclub.apimvp.controllers

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/heartbeat")
@Tag(name = "Heartbeat", description = "Endpoint for checking if the application is working.")
class HeartbeatController {

    @GetMapping
    @Operation(summary = "Heartbeat endpoint", description = "Returns a string to check if the application is working.")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Application is working"),
        ApiResponse(responseCode = "500", description = "Application is not working")
    ])
    fun heartbeat() = "F1FanClub application is working!"
}
