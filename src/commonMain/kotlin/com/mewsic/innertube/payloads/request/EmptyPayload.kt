package com.mewsic.innertube.payloads.request

import kotlinx.serialization.Serializable

@Serializable
data class EmptyPayload(
    val context: ContextPayload
)
