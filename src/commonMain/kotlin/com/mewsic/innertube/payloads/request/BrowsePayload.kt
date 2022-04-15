package com.mewsic.innertube.payloads.request

import kotlinx.serialization.Serializable

@Serializable
data class BrowsePayload(
    val browseId: String,
    val params: String?,
    val context: ContextPayload,
)

