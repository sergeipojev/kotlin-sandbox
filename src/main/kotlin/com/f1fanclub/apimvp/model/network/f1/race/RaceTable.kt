package com.f1fanclub.apimvp.model.network.f1.race

import com.fasterxml.jackson.annotation.JsonProperty

data class RaceTable(
    @JsonProperty("season") val season: String,
    @JsonProperty("Races") val races: Collection<Race>,
)
