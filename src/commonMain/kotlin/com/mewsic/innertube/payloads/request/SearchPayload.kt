package com.mewsic.innertube.payloads.request

import kotlinx.serialization.Serializable

@Serializable
data class SearchPayload(
    val query: String,
    val context: ContextPayload
)
