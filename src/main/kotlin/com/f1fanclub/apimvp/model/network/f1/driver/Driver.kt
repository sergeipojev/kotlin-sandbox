package com.f1fanclub.apimvp.model.network.f1.driver

import com.f1fanclub.apimvp.model.dto.DriverInfo
import com.fasterxml.jackson.annotation.JsonProperty

data class Driver(
    @JsonProperty("driverId") val driverId: String,
    @JsonProperty("permanentNumber") val permanentNumber: Number?,
    @JsonProperty("code") val code: String?,
    @JsonProperty("url") val wikiUrl: String,
    @JsonProperty("givenName") val givenName: String,
    @JsonProperty("familyName") val familyName: String,
    @JsonProperty("dateOfBirth") val dateOfBirth: String,
    @JsonProperty("nationality") val nationality: String,
) {
    fun toDto() = DriverInfo(
        driverId = this.driverId,
        permanentNumber = this.permanentNumber?: 0,
        code = this.code?: "N/A",
        wikiUrl = this.wikiUrl,
        name = "${this.givenName} ${this.familyName}",
        dateOfBirth = this.dateOfBirth,
        nationality = this.nationality
    )
}
