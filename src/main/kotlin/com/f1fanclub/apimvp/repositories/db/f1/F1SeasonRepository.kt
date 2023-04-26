package com.f1fanclub.apimvp.repositories.db.f1

import com.f1fanclub.apimvp.model.db.F1Season
import com.f1fanclub.apimvp.model.network.f1.F1ApiResponse
import com.f1fanclub.apimvp.repositories.F1DataSource
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
@ConditionalOnProperty(name = ["app.config.f1.data-source"], havingValue = "mongo")
class F1SeasonRepository(
    private val mongoTemplate: ReactiveMongoTemplate,
) : F1DataSource {

    override fun retrieveAllF1Seasons(): List<F1Season> =
        mongoTemplate.findAll(F1Season::class.java).collectList().block().orEmpty()

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
