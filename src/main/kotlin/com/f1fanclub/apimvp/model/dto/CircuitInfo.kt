package com.f1fanclub.apimvp.model.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(NON_NULL)
data class CircuitInfo(
    @JsonProperty("circuitId") val circuitId: String,
    @JsonProperty("url") val wikiUrl: String,
    @JsonProperty("circuitName") val circuitName: String,
    @JsonProperty("lat") val latitude: Double?,
    @JsonProperty("long") val longitude: Double?,
    @JsonProperty("locality") val locality: String,
    @JsonProperty("country") val country: String,
)
