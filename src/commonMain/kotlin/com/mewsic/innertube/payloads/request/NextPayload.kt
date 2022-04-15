package com.mewsic.innertube.payloads.request

import kotlinx.serialization.Serializable

@Serializable
data class NextPayload(val videoId: String, val playlistId: String, val params: String?, val index: Int?, val continuation: String?, val contextPayload: ContextPayload)
