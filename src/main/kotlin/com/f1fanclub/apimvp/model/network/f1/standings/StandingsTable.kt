package com.f1fanclub.apimvp.model.network.f1.standings

import com.fasterxml.jackson.annotation.JsonProperty

data class StandingsTable(
    @JsonProperty("season") val season: Number,
    @JsonProperty("StandingsLists") val standings: Collection<Standings>,
)
