package com.f1fanclub.apimvp.model.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ConstructorInfo(
    @JsonProperty("constructorId") val constructorId: String,
    @JsonProperty("url") val wikiUrl: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("nationality") val nationality: String,
)
