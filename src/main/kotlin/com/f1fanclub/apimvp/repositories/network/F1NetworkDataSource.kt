package com.f1fanclub.apimvp.repositories.network

import com.f1fanclub.apimvp.model.db.F1Season
import com.f1fanclub.apimvp.model.network.f1.F1ApiResponse
import com.f1fanclub.apimvp.repositories.F1DataSource
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import reactor.core.publisher.Mono
import java.io.IOException

@Repository
@ConditionalOnProperty(name = ["app.config.f1.data-source"], havingValue = "resttemplate")
class F1NetworkDataSource(
    private val restTemplate: RestTemplate,
) : F1DataSource {

    override fun retrieveAllF1Seasons(): List<F1Season> {
        val forEntity =
            restTemplate.getForEntity(
                "http://ergast.com/api/f1/seasons.json?limit=100",
                F1ApiResponse::class.java,
            )

        val f1SeasonData = forEntity.body?.data?.seasonData?.seasons
            ?: throw IOException("Could not fetch f1 seasons from the API!")

        return f1SeasonData.map { it.toModel() }
    }

    override suspend fun retrieveSeasonInfo(season: Int): Mono<F1ApiResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun retrieveDrivers(season: Int): Mono<F1ApiResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun retrieveConstructors(season: Int): Mono<F1ApiResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun retrieveCircuits(season: Int): Mono<F1ApiResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun retrieveRaces(season: Int): Mono<F1ApiResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun retrieveDriverStandingsAfterSeason(season: Int): Mono<F1ApiResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun retrieveConstructorStandingsAfterSeason(season: Int): Mono<F1ApiResponse> {
        TODO("Not yet implemented")
    }
}
