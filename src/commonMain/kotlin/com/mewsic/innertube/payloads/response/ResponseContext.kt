package com.mewsic.innertube.payloads.response

import kotlinx.serialization.Serializable

@Serializable
data class ResponseContext(
    val serviceTrackingParams: List<ServiceTrackingParam>,
    val visitorData: String? = null,
    val maxAgeSeconds: Int? = null,
    val mainAppWebResponseContext: MainAppWebResponseContext? = null,
    val webResponseContextExtensionData: WebResponseContextExtensionData? = null,
)

@Serializable
data class MainAppWebResponseContext(
    val loggedOut: Boolean
)

@Serializable
data class WebResponseContextExtensionData(
    val hasDecorated: Boolean,
)
