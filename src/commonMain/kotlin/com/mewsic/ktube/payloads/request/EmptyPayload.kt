package com.mewsic.ktube.payloads.request

import kotlinx.serialization.Serializable

@Serializable
data class EmptyPayload(
    val context: ContextPayload
)
