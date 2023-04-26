package com.f1fanclub.apimvp.model.network.f1.race

import com.f1fanclub.apimvp.model.dto.RaceInfo
import com.f1fanclub.apimvp.model.network.f1.circuit.Circuit
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
data class Race(
    @JsonProperty("season") val season: String,
    @JsonProperty("round") val round: String,
    @JsonProperty("url") val wikiUrl: String,
    @JsonProperty("raceName") val raceName: String,
    @JsonProperty("Circuit") val circuit: Circuit,
    @JsonProperty("date") val date: String,
    @JsonProperty("time") val time: String?,
    @JsonProperty("FirstPractice") val firstPractice: SessionSchedule?,
    @JsonProperty("SecondPractice") val secondPractice: SessionSchedule?,
    @JsonProperty("ThirdPractice") val thirdPractice: SessionSchedule?,
    @JsonProperty("Qualifying") val qualifying: SessionSchedule?,
    @JsonProperty("Sprint") val sprint: SessionSchedule?,
) {
    fun toDto() = RaceInfo(
        season = this.season,
        round = this.round,
        wikiUrl = this.wikiUrl,
        raceName = this.raceName,
        circuit = this.circuit.toDto(),
        date = this.date,
        time = this.time?.replace("Z", "")?:"00:00:00",
        dateTime = LocalDateTime.parse("${this.date}T${this.time?.replace("Z", "")?:"00:00:00"}"),
        firstPractice = this.firstPractice?.toDto(),
        secondPractice = this.secondPractice?.toDto(),
        thirdPractice = this.thirdPractice?.toDto(),
        qualifying = this.qualifying?.toDto(),
        sprint = this.sprint?.toDto(),
    )
}
