package com.f1fanclub.apimvp.model.network.f1.circuit

import com.fasterxml.jackson.annotation.JsonProperty

data class CircuitTable(
    @JsonProperty("season") val season: Number,
    @JsonProperty("Circuits") val circuits: Collection<Circuit>,
)
