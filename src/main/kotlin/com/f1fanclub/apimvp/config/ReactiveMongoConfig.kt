package com.f1fanclub.apimvp.config


import com.mongodb.reactivestreams.client.MongoClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.ReactiveMongoTemplate

@Configuration
class ReactiveMongoConfig(
    private val mongoClient: MongoClient,
    @Value("\${spring.data.mongodb.database}") private val databaseName: String,
) {
    @Bean
    fun reactiveMongoTemplate() = ReactiveMongoTemplate(mongoClient, databaseName)
}