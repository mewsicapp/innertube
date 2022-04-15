package com.mewsic.innertube.internal.models

data class ClientSchema(
    val client: com.mewsic.innertube.enums.Client,
    val device: com.mewsic.innertube.enums.Device,
    val service: com.mewsic.innertube.enums.Service,
)
