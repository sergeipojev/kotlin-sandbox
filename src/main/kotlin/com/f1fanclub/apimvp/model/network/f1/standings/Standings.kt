package com.f1fanclub.apimvp.model.network.f1.standings

import com.f1fanclub.apimvp.model.network.f1.constructor.ConstructorStanding
import com.f1fanclub.apimvp.model.network.f1.driver.DriverStanding
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
data class Standings(
    @JsonProperty("season") val season: Number,
    @JsonProperty("round") val round: Number,
    @JsonProperty("DriverStandings") val driverStandings: Collection<DriverStanding>?,
    @JsonProperty("ConstructorStandings") val constructorStandings: Collection<ConstructorStanding>?,
)
