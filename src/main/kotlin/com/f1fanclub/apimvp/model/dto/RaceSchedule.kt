package com.f1fanclub.apimvp.model.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class RaceSchedule(
    @JsonProperty("date") val date: String,
    @JsonProperty("time") val time: String,
)
