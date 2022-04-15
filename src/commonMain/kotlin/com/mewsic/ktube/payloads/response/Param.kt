package com.mewsic.ktube.payloads.response

import kotlinx.serialization.Serializable

@Serializable
data class Param(
    val key: String,
    val value: String
)
