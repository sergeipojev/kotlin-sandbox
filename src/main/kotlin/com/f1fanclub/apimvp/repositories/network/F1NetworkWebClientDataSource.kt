package com.f1fanclub.apimvp.repositories.network

import com.f1fanclub.apimvp.model.db.F1Season
import com.f1fanclub.apimvp.model.network.f1.F1ApiResponse
import com.f1fanclub.apimvp.repositories.F1DataSource
import com.f1fanclub.apimvp.utils.prettyPrintJsonObject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Repository
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import java.io.IOException

@Repository
@ConditionalOnProperty(name = ["app.config.f1.data-source"], havingValue = "webclient")
class F1NetworkWebClientDataSource(
    private val f1WebClient: WebClient,
) : F1DataSource {

    private val log: Logger = LoggerFactory.getLogger(F1NetworkWebClientDataSource::class.java)

    override fun retrieveAllF1Seasons(): Collection<F1Season> {
        val f1ApiResponse = f1WebClient.get()
            .uri("/seasons.json?limit=100")
            .retrieve()
            .bodyToMono(F1ApiResponse::class.java)
            .doOnSuccess {
                if (log.isDebugEnabled) log.debug("Web Client F1 Seasons Response: {}", prettyPrintJsonObject(it))
            }
            .block()

        val f1SeasonData = f1ApiResponse?.data?.seasonData?.seasons
            ?: throw IOException("Could not fetch f1 seasons from the API!")

        return f1SeasonData.map { it.toModel() }
    }

    override suspend fun retrieveSeasonInfo(season: Int): Mono<F1ApiResponse> =
        retrieveF1ApiResponse("/$season/seasons.json?limit=100", "Season $season Info")

    override suspend fun retrieveDrivers(season: Int): Mono<F1ApiResponse> =
        retrieveF1ApiResponse("/$season/drivers.json?limit=100", "Drivers")

    override suspend fun retrieveConstructors(season: Int): Mono<F1ApiResponse> =
        retrieveF1ApiResponse("/$season/constructors.json?limit=100", "Constructors")

    override suspend fun retrieveCircuits(season: Int): Mono<F1ApiResponse> =
        retrieveF1ApiResponse("/$season/circuits.json?limit=100", "Circuits")

    override suspend fun retrieveRaces(season: Int): Mono<F1ApiResponse> =
        retrieveF1ApiResponse("/$season.json?limit=100", "Races")

    override suspend fun retrieveDriverStandingsAfterSeason(season: Int): Mono<F1ApiResponse> =
        retrieveF1ApiResponse("/$season/driverStandings.json?limit=100", "Driver Standings After Season")

    override suspend fun retrieveConstructorStandingsAfterSeason(season: Int): Mono<F1ApiResponse> =
        retrieveF1ApiResponse("/$season/constructorStandings.json?limit=100", "Constructor Standings After Season")

    private suspend fun retrieveF1ApiResponse(uri: String, type: String): Mono<F1ApiResponse> =
        f1WebClient.get()
            .uri(uri)
            .retrieve()
            .bodyToMono(F1ApiResponse::class.java)
            .doOnSuccess {
                log.debug("Web Client, for $type, F1 Response: {}", prettyPrintJsonObject(it))
            }

}
