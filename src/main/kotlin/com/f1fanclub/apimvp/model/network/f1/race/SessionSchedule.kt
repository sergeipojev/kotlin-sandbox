package com.f1fanclub.apimvp.model.network.f1.race

import com.f1fanclub.apimvp.model.dto.RaceSchedule
import com.fasterxml.jackson.annotation.JsonProperty

data class SessionSchedule(
    @JsonProperty("date") val date: String,
    @JsonProperty("time") val time: String?,
) {
    fun toDto() = RaceSchedule(
        date = this.date,
        time = this.time?: "00:00:00",
    )
}
