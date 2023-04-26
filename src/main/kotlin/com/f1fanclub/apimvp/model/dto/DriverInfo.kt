package com.f1fanclub.apimvp.model.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class DriverInfo(
    @JsonProperty("driverId") val driverId: String,
    @JsonProperty("permanentNumber") val permanentNumber: Number,
    @JsonProperty("code") val code: String,
    @JsonProperty("url") val wikiUrl: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("dateOfBirth") val dateOfBirth: String,
    @JsonProperty("nationality") val nationality: String,
)
