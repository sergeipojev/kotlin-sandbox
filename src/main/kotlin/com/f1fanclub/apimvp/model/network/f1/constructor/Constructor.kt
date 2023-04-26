package com.f1fanclub.apimvp.model.network.f1.constructor

import com.f1fanclub.apimvp.model.dto.ConstructorInfo
import com.fasterxml.jackson.annotation.JsonProperty

data class Constructor(
    @JsonProperty("constructorId") val constructorId: String,
    @JsonProperty("url") val wikiUrl: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("nationality") val nationality: String,
) {
    fun toDto() = ConstructorInfo(
        constructorId = this.constructorId,
        wikiUrl = this.wikiUrl,
        name = this.name,
        nationality = this.nationality,
    )
}
