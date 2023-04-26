package com.f1fanclub.apimvp.services.impl

import com.f1fanclub.apimvp.model.dto.F1SeasonInfo
import com.f1fanclub.apimvp.model.network.f1.F1ApiResponse
import com.f1fanclub.apimvp.repositories.F1DataSource
import com.f1fanclub.apimvp.services.IF1SeasonService
import javassist.NotFoundException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.supervisorScope
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class F1SeasonService(
    private val f1DataSource: F1DataSource,
) : IF1SeasonService {

    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    override fun getAllSeasons(): List<F1SeasonInfo> {
        log.info("Retrieving all F1 seasons")
        val f1Seasons = this.f1DataSource.retrieveAllF1Seasons()
        return f1Seasons.map { it.toDto() }
    }

    override suspend fun getDrivers(season: Int): Mono<F1ApiResponse> =
        f1DataSource.retrieveDrivers(season)

    override suspend fun getConstructors(season: Int): Mono<F1ApiResponse> =
        f1DataSource.retrieveConstructors(season)

    override suspend fun getCircuits(season: Int): Mono<F1ApiResponse> =
        f1DataSource.retrieveCircuits(season)

    override suspend fun getDriverStandings(season: Int): Mono<F1ApiResponse> =
        f1DataSource.retrieveDriverStandingsAfterSeason(season)

    override suspend fun getConstructorStandings(season: Int): Mono<F1ApiResponse> =
        f1DataSource.retrieveConstructorStandingsAfterSeason(season)

    override suspend fun getRaces(season: Int): Mono<F1ApiResponse> =
        f1DataSource.retrieveRaces(season)

    override suspend fun getSeasonOverview(season: Int): Mono<F1SeasonInfo> =
        supervisorScope {
            log.info("Retrieving season overview for season $season")
            val getSeasonInfoJob = async(Dispatchers.IO) {
                f1DataSource.retrieveSeasonInfo(season)
                    .mapNotNull { it.data.seasonData?.seasons?.firstOrNull()?.toDto() }
                    .block()
            }

            collectSeasonInfo(getSeasonInfoJob.await() ?: throw NotFoundException("Season $season not found"))
        }

    private suspend fun collectSeasonInfo(seasonInfo: F1SeasonInfo): Mono<F1SeasonInfo> =
        supervisorScope {
            val getDriversJob = async(Dispatchers.IO) {
                getDrivers(seasonInfo.season)
                    .mapNotNull { response ->
                        response.data.driversData?.drivers?.map {
                            it.toDto()
                        }?.toList() }
                    .block()
            }

            val getConstructorsJob = async(Dispatchers.IO) {
                getConstructors(seasonInfo.season)
                    .mapNotNull { response ->
                        response.data.constructorsData?.constructors?.map {
                            it.toDto()
                        }?.toList() }
                    .block()
            }

            val getCircuitsJob = async(Dispatchers.IO) {
                getCircuits(seasonInfo.season)
                    .mapNotNull { response ->
                        response.data.circuitsData?.circuits?.map {
                            it.toDto()
                        }?.toList() }
                    .block()
            }

            val getRacesJob = async(Dispatchers.IO) {
                getRaces(seasonInfo.season)
                    .mapNotNull { response ->
                        response.data.racesData?.races?.map {
                            it.toDto()
                        }?.toList() }
                    .block()
            }

            Mono.just(F1SeasonInfo(
                id = seasonInfo.id,
                season = seasonInfo.season,
                wikiPage = seasonInfo.wikiPage,
                drivers = getDriversJob.await(),
                constructors = getConstructorsJob.await(),
                races = getRacesJob.await(),
                circuits = getCircuitsJob.await()
            ))
        }

    override suspend fun getAllSeasonsOverview(): Flux<F1SeasonInfo> =
        supervisorScope {
            log.info("Retrieving all seasons overview")
            getAllSeasons().map {
                val getSeasonInfoJob = async(Dispatchers.IO) {
                    collectSeasonInfo(it).block()?: throw NotFoundException("Info for season ${it.season} not found")
                }
                getSeasonInfoJob.await()
            }.toList().let { Flux.fromIterable(it) }
        }
}
