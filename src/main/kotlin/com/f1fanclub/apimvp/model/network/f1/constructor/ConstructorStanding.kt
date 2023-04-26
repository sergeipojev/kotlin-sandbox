package com.f1fanclub.apimvp.model.network.f1.constructor

import com.fasterxml.jackson.annotation.JsonProperty

data class ConstructorStanding(
    @JsonProperty("position") val position: Number,
    @JsonProperty("positionText") val positionText: String,
    @JsonProperty("points") val points: Number,
    @JsonProperty("wins") val wins: Number,
    @JsonProperty("Constructor") val constructor: Constructor,
)
