package com.f1fanclub.apimvp.model.network.f1.constructor

import com.fasterxml.jackson.annotation.JsonProperty

data class ConstructorTable(
    @JsonProperty("season") val season: Number,
    @JsonProperty("Constructors") val constructors: Collection<Constructor>,
)
