package com.f1fanclub.apimvp.model.network.f1.driver

import com.f1fanclub.apimvp.model.network.f1.constructor.Constructor
import com.fasterxml.jackson.annotation.JsonProperty

data class DriverStanding(
    @JsonProperty("position") val position: Number,
    @JsonProperty("positionText") val positionText: String,
    @JsonProperty("points") val points: Number,
    @JsonProperty("wins") val wins: Number,
    @JsonProperty("Driver") val driver: Driver,
    @JsonProperty("Constructors") val constructors: Collection<Constructor>,
)
