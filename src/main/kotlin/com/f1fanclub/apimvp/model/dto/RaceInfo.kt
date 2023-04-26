package com.f1fanclub.apimvp.model.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import java.time.LocalDateTime

data class RaceInfo(
    @JsonProperty("season") val season: String,
    @JsonProperty("round") val round: String,
    @JsonProperty("url") val wikiUrl: String,
    @JsonProperty("raceName") val raceName: String,
    @JsonProperty("circuit") val circuit: CircuitInfo,
    @JsonProperty("date") val date: String,
    @JsonProperty("time") val time: String,

    @JsonDeserialize(using = LocalDateTimeDeserializer::class)
    @JsonSerialize(using = LocalDateTimeSerializer::class)
    @JsonProperty("dateTime") val dateTime: LocalDateTime,

    @JsonProperty("firstPractice") val firstPractice: RaceSchedule?,
    @JsonProperty("secondPractice") val secondPractice: RaceSchedule?,
    @JsonProperty("thirdPractice") val thirdPractice: RaceSchedule?,
    @JsonProperty("qualifying") val qualifying: RaceSchedule?,
    @JsonProperty("sprint") val sprint: RaceSchedule?,
)
