package com.f1fanclub.apimvp.model.network.f1.circuit

import com.fasterxml.jackson.annotation.JsonProperty

data class CircuitLocation(
    @JsonProperty("lat") val latitude: Double,
    @JsonProperty("long") val longitude: Double,
    @JsonProperty("locality") val locality: String,
    @JsonProperty("country") val country: String,
)
