package com.mewsic.innertube.payloads.request

import kotlinx.serialization.Serializable

@Serializable
data class ClientPayload(
    val clientName: String,
    val clientVersion: String,
)
