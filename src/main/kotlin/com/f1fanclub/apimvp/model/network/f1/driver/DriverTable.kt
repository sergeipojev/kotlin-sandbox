package com.f1fanclub.apimvp.model.network.f1.driver

import com.fasterxml.jackson.annotation.JsonProperty

data class DriverTable(
    @JsonProperty("season") val season: Int,
    @JsonProperty("Drivers") val drivers: Collection<Driver>,
)
