package com.mewsic.innertube.payloads.request

import kotlinx.serialization.Serializable

@Serializable
data class PlayerPayload(
    val videoId: String,
    val context: ContextPayload,
)
