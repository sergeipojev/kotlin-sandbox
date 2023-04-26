package com.f1fanclub.apimvp.model.network.f1.circuit

import com.f1fanclub.apimvp.model.dto.CircuitInfo
import com.fasterxml.jackson.annotation.JsonProperty

data class Circuit(
    @JsonProperty("circuitId") val circuitId: String,
    @JsonProperty("url") val wikiUrl: String,
    @JsonProperty("circuitName") val circuitName: String,
    @JsonProperty("Location") val location: CircuitLocation,
) {
    fun toDto() = CircuitInfo(
        circuitId = this.circuitId,
        wikiUrl = this.wikiUrl,
        circuitName = this.circuitName,
        latitude = this.location.latitude,
        longitude = this.location.longitude,
        locality = this.location.locality,
        country = this.location.country,
    )
}
