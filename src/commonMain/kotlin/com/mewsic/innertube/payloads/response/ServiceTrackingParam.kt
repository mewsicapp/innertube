package com.mewsic.innertube.payloads.response

import kotlinx.serialization.Serializable

@Serializable
data class ServiceTrackingParam(
    val params: List<Param>,
    val service: String
)
