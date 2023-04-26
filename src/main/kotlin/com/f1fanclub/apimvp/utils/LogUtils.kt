package com.f1fanclub.apimvp.utils

import com.f1fanclub.apimvp.config.AppConfig.Companion.appConfig
import com.fasterxml.jackson.databind.ObjectMapper

fun prettyPrintJsonObject(toLog: Any): String {
    val objectMapper: ObjectMapper = appConfig.objetMapper()
    return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(toLog)
}
