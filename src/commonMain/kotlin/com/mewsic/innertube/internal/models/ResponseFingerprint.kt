package com.mewsic.innertube.internal.models

data class ResponseFingerprint(
    val endpoint: String?,
    val request: String?,
    val function: String?,
    val browse_id: String?,
    val context: String?,
    val client: String?,
)
