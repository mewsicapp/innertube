package com.mewsic.innertube.internal.models

import io.ktor.http.*

data class Error(
    val code: HttpStatusCode,
    val message: String
)
