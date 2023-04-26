package com.f1fanclub.apimvp.model.network.f1

import com.fasterxml.jackson.annotation.JsonProperty

data class F1ApiResponse(
    @JsonProperty("MRData") val data: F1ApiResponseData,
)
