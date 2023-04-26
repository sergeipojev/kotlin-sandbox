package com.f1fanclub.apimvp.model.network.f1.season

import com.f1fanclub.apimvp.model.db.F1Season
import com.f1fanclub.apimvp.model.dto.F1SeasonInfo
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

data class Season(
    @JsonProperty("season") val season: String,
    @JsonProperty("url") val wikiUrl: String,
) {

    fun toModel() = F1Season(
        id = UUID.randomUUID().toString(),
        season = this.season.toInt(),
        wikiPage = this.wikiUrl,
    )

    fun toDto() = F1SeasonInfo(
        id = UUID.randomUUID().toString(),
        season = this.season.toInt(),
        wikiPage = this.wikiUrl,
    )
}
