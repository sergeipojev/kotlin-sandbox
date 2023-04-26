package com.f1fanclub.apimvp.model.network.f1

import com.f1fanclub.apimvp.model.network.f1.circuit.CircuitTable
import com.f1fanclub.apimvp.model.network.f1.constructor.ConstructorTable
import com.f1fanclub.apimvp.model.network.f1.driver.DriverTable
import com.f1fanclub.apimvp.model.network.f1.race.RaceTable
import com.f1fanclub.apimvp.model.network.f1.season.SeasonTable
import com.f1fanclub.apimvp.model.network.f1.standings.StandingsTable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
data class F1ApiResponseData(
    @JsonProperty("series") val series: String,
    @JsonProperty("url") val url: String,
    @JsonProperty("limit") val limit: Int,
    @JsonProperty("offset") val offset: Int,
    @JsonProperty("total") val total: Int,
    @JsonProperty("SeasonTable") val seasonData: SeasonTable?,
    @JsonProperty("DriverTable") val driversData: DriverTable?,
    @JsonProperty("ConstructorTable") val constructorsData: ConstructorTable?,
    @JsonProperty("CircuitTable") val circuitsData: CircuitTable?,
    @JsonProperty("RaceTable") val racesData: RaceTable?,
    @JsonProperty("StandingsTable") val standingsData: StandingsTable?,
)
