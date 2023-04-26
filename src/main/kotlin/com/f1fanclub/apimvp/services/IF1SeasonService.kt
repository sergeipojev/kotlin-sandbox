package com.f1fanclub.apimvp.services

import com.f1fanclub.apimvp.model.dto.F1SeasonInfo
import com.f1fanclub.apimvp.model.network.f1.F1ApiResponse
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface IF1SeasonService {

    fun getAllSeasons(): List<F1SeasonInfo>

    suspend fun getDrivers(season: Int): Mono<F1ApiResponse>

    suspend fun getConstructors(season: Int): Mono<F1ApiResponse>

    suspend fun getCircuits(season: Int): Mono<F1ApiResponse>

    suspend fun getDriverStandings(season: Int): Mono<F1ApiResponse>

    suspend fun getConstructorStandings(season: Int): Mono<F1ApiResponse>

    suspend fun getRaces(season: Int): Mono<F1ApiResponse>

    suspend fun getSeasonOverview(season: Int): Mono<F1SeasonInfo>

    suspend fun getAllSeasonsOverview(): Flux<F1SeasonInfo>
}
