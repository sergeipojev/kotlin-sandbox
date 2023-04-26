package com.f1fanclub.apimvp.model.network.f1.season

import com.fasterxml.jackson.annotation.JsonProperty

data class SeasonTable(
    @JsonProperty("Seasons") val seasons: Collection<Season>,
    @JsonProperty("season") val season: String?,
)
