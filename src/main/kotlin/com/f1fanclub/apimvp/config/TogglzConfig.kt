package com.f1fanclub.apimvp.config

import com.mongodb.WriteConcern.ACKNOWLEDGED
import com.mongodb.client.MongoClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.togglz.core.context.StaticFeatureManagerProvider
import org.togglz.core.manager.FeatureManager
import org.togglz.core.manager.FeatureManagerBuilder
import org.togglz.core.repository.StateRepository
import org.togglz.core.repository.file.FileBasedStateRepository
import org.togglz.core.spi.FeatureProvider
import org.togglz.core.user.SimpleFeatureUser
import org.togglz.core.user.UserProvider
import org.togglz.kotlin.EnumClassFeatureProvider
import org.togglz.mongodb.MongoStateRepository
import java.io.File

@Configuration
class TogglzConfig(
    private val mongoClient: MongoClient,
    @Value("\${spring.data.mongodb.database}") private val mongoDbName: String,
) {

    @Bean
    fun featureProvider() = EnumClassFeatureProvider(Features::class.java)

    @Bean
    @ConditionalOnProperty(name = ["app.togglz.file.enabled"], havingValue = "true")
    fun stateRepository(): StateRepository = FileBasedStateRepository(File("src/main/resources/togglz.properties"))

    @Bean
    @ConditionalOnProperty(name = ["app.togglz.mongo.enabled"], havingValue = "true")
    fun mongoStateRepository(): StateRepository =
        MongoStateRepository.newBuilder(mongoClient, mongoDbName)
            .collection("togglz")
            .writeConcern(ACKNOWLEDGED)
            .build()

    @Bean
    fun userProvider(): UserProvider = UserProvider { SimpleFeatureUser("admin", true) }

    @Bean
    @Primary
    fun myFeatureManager(
        stateRepository: StateRepository,
        userProvider: UserProvider,
        featureProvider: FeatureProvider,
    ): FeatureManager {
        val featureManager = FeatureManagerBuilder()
            .featureProvider(featureProvider)
            .stateRepository(stateRepository)
            .userProvider(userProvider)
            .build()

        StaticFeatureManagerProvider.setFeatureManager(featureManager)
        return featureManager
    }
}
