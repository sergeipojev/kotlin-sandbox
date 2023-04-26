package com.f1fanclub.apimvp.repositories

import com.f1fanclub.apimvp.model.db.F1Season
import com.f1fanclub.apimvp.model.network.f1.F1ApiResponse
import reactor.core.publisher.Mono

interface F1DataSource {

    fun retrieveAllF1Seasons(): Collection<F1Season>

    suspend fun retrieveSeasonInfo(season: Int): Mono<F1ApiResponse>

    suspend fun retrieveDrivers(season: Int): Mono<F1ApiResponse>

    suspend fun retrieveConstructors(season: Int): Mono<F1ApiResponse>

    suspend fun retrieveCircuits(season: Int): Mono<F1ApiResponse>

    suspend fun retrieveRaces(season: Int): Mono<F1ApiResponse>

    suspend fun retrieveDriverStandingsAfterSeason(season: Int): Mono<F1ApiResponse>

    suspend fun retrieveConstructorStandingsAfterSeason(season: Int): Mono<F1ApiResponse>
}
