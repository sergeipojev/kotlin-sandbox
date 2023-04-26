package com.f1fanclub.apimvp.model.dto

data class F1SeasonInfo(
    val id: String,
    val season: Int,
    val wikiPage: String,
    val drivers: Collection<DriverInfo>? = null,
    val constructors: Collection<ConstructorInfo>? = null,
    val circuits: Collection<CircuitInfo>? = null,
    val races: Collection<RaceInfo>? = null,
)
