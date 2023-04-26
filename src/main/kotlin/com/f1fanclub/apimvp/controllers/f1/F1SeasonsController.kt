package com.f1fanclub.apimvp.controllers.f1

import com.f1fanclub.apimvp.config.Features.F1_COMBINED_DATA
import com.f1fanclub.apimvp.exception.ExceptionResponse
import com.f1fanclub.apimvp.exception.FeatureNotEnabledException
import com.f1fanclub.apimvp.model.dto.F1SeasonInfo
import com.f1fanclub.apimvp.model.network.f1.F1ApiResponse
import com.f1fanclub.apimvp.services.IF1SeasonService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/f1/seasons")
@Tag(name = "F1 Seasons", description = "Endpoints for getting data about F1 seasons")
class F1SeasonsController(
    private val f1SeasonService: IF1SeasonService,
) {

    /**
     * Getting all F1 seasons.
     */
    @GetMapping
    @Operation(summary = "Getting all F1 seasons")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Successfully retrieved all F1 seasons",
            content = [Content(mediaType = APPLICATION_JSON_VALUE, schema = Schema(type = "array", implementation = F1SeasonInfo::class))] ),
        ApiResponse(responseCode = "500", description = "Internal server error", content = [Content(mediaType = APPLICATION_JSON_VALUE, schema = Schema(implementation = ExceptionResponse::class))])
    ])
    fun getAllSeasons(): List<F1SeasonInfo> = f1SeasonService.getAllSeasons()

    /**
     * Getting all drivers for a given season.
     */
    @GetMapping("/{season}/drivers")
    @Operation(summary = "Getting all drivers for a given season")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Successfully retrieved all drivers for a given season",
            content = [Content(mediaType = APPLICATION_JSON_VALUE, schema = Schema(type = "array", implementation = F1ApiResponse::class))]),
        ApiResponse(responseCode = "500", description = "Internal server error", content = [Content(mediaType = APPLICATION_JSON_VALUE, schema = Schema(implementation = ExceptionResponse::class))])
    ])
    suspend fun getDrivers(
        @Parameter(
            name = "season",
            description = "Season for which to return drivers list.",
            example = "2022",
            schema = Schema(type = "integer")
        ) @PathVariable season: Int
    ): Mono<F1ApiResponse> =
        f1SeasonService.getDrivers(season)

    @GetMapping("/{season}/constructors")
    @Operation(summary = "Getting all constructors for a given season")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Successfully retrieved all constructors for a given season",
            content = [Content(mediaType = APPLICATION_JSON_VALUE, schema = Schema(type = "array", implementation = F1ApiResponse::class))]),
        ApiResponse(responseCode = "500", description = "Internal server error", content = [Content(mediaType = APPLICATION_JSON_VALUE, schema = Schema(implementation = ExceptionResponse::class))])
    ])
    suspend fun getConstructors(
        @Parameter(
            name = "season", description = "Season for which to return constructors list.",
            example = "2022", schema = Schema(type = "integer")
        ) @PathVariable season: Int
    ): Mono<F1ApiResponse> =
        f1SeasonService.getConstructors(season)

    @GetMapping("/{season}/circuits")
    @Operation(summary = "Getting all circuits for a given season")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Successfully retrieved all circuits for a given season",
            content = [Content(mediaType = APPLICATION_JSON_VALUE, schema = Schema(type = "array", implementation = F1ApiResponse::class))]),
        ApiResponse(responseCode = "500", description = "Internal server error", content = [Content(mediaType = APPLICATION_JSON_VALUE, schema = Schema(implementation = ExceptionResponse::class))])
    ])
    suspend fun getCircuits(
        @Parameter(
            name = "season", description = "Season for which to return circuits list.",
            example = "2022", schema = Schema(type = "integer")
        ) @PathVariable season: Int
    ): Mono<F1ApiResponse> =
        f1SeasonService.getCircuits(season)

    @GetMapping("/{season}/races")
    @Operation(summary = "Getting all races for a given season")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Successfully retrieved all races for a given season",
            content = [Content(mediaType = APPLICATION_JSON_VALUE, schema = Schema(type = "array", implementation = F1ApiResponse::class))]),
        ApiResponse(responseCode = "500", description = "Internal server error", content = [Content(mediaType = APPLICATION_JSON_VALUE, schema = Schema(implementation = ExceptionResponse::class))])
    ])
    suspend fun getRaces(
        @Parameter(
            name = "season", description = "Season for which to return races list.",
            example = "2022", schema = Schema(type = "integer")
        ) @PathVariable season: Int
    ): Mono<F1ApiResponse> =
        f1SeasonService.getRaces(season)

    @GetMapping("/{season}/driver-standings")
    @Operation(summary = "Getting all driver standings for a given season")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Successfully retrieved all driver standings for a given season",
            content = [Content(mediaType = APPLICATION_JSON_VALUE, schema = Schema(type = "array", implementation = F1ApiResponse::class))]),
        ApiResponse(responseCode = "500", description = "Internal server error", content = [Content(mediaType = APPLICATION_JSON_VALUE, schema = Schema(implementation = ExceptionResponse::class))])
    ])
    suspend fun getDriverStandings(
        @Parameter(
            name = "season", description = "Season for which to return driver standings.",
            example = "2022", schema = Schema(type = "integer")
        ) @PathVariable season: Int
    ): Mono<F1ApiResponse> =
        f1SeasonService.getDriverStandings(season)

    @GetMapping("/{season}/constructor-standings")
    @Operation(summary = "Getting all constructor standings for a given season")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Successfully retrieved all constructor standings for a given season",
            content = [Content(mediaType = APPLICATION_JSON_VALUE, schema = Schema(type = "array", implementation = F1ApiResponse::class))]),
        ApiResponse(responseCode = "500", description = "Internal server error", content = [Content(mediaType = APPLICATION_JSON_VALUE, schema = Schema(implementation = ExceptionResponse::class))])
    ])
    suspend fun getConstructorStandings(
        @Parameter(
            name = "season", description = "Season for which to return constructor standings.",
            example = "2022", schema = Schema(type = "integer")
        ) @PathVariable season: Int
    ): Mono<F1ApiResponse> =
        f1SeasonService.getConstructorStandings(season)

    @GetMapping("/{season}/overview")
    @Operation(summary = "Getting all overview for a given season", description = "This endpoint is only available if the feature flag F1_COMBINED_DATA is enabled.")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Successfully retrieved all overview for a given season",
            content = [Content(mediaType = APPLICATION_JSON_VALUE, schema = Schema(implementation = ExceptionResponse::class))]),
        ApiResponse(responseCode = "404", description = "Season not found", content = [Content(mediaType = APPLICATION_JSON_VALUE, schema = Schema(implementation = ExceptionResponse::class))]),
        ApiResponse(responseCode = "422", description = "Feature flag F1_COMBINED_DATA is not enabled", content = [Content(mediaType = APPLICATION_JSON_VALUE, schema = Schema(implementation = ExceptionResponse::class))]),
        ApiResponse(responseCode = "500", description = "Internal server error", content = [Content(mediaType = APPLICATION_JSON_VALUE, schema = Schema(implementation = ExceptionResponse::class))])
    ])
    suspend fun getSeasonOverview(
        @Parameter(
            name = "season", description = "Season for which to return data.",
            example = "2022", schema = Schema(type = "integer")
        ) @PathVariable season: Int
    ): Mono<F1SeasonInfo> =
        if (F1_COMBINED_DATA.isActive()) {
            f1SeasonService.getSeasonOverview(season)
        } else {
            throw FeatureNotEnabledException()
        }


    @GetMapping("/overview")
    @Operation(summary = "Getting all overview for all seasons", description = "This endpoint is only available if the feature flag F1_COMBINED_DATA is enabled.")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Successfully retrieved all overview for all seasons",
            content = [Content(mediaType = APPLICATION_JSON_VALUE, schema = Schema(type = "array", implementation = F1SeasonInfo::class))]),
        ApiResponse(responseCode = "422", description = "Feature flag F1_COMBINED_DATA is not enabled", content = [Content(mediaType = APPLICATION_JSON_VALUE, schema = Schema(implementation = ExceptionResponse::class))]),
        ApiResponse(responseCode = "500", description = "Internal server error", content = [Content(mediaType = APPLICATION_JSON_VALUE, schema = Schema(implementation = ExceptionResponse::class))])
    ])
    suspend fun getAllSeasonsOverview(): Flux<F1SeasonInfo> =
        if (F1_COMBINED_DATA.isActive()) {
            f1SeasonService.getAllSeasonsOverview()
        } else {
            throw FeatureNotEnabledException()
        }
}
