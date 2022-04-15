package com.mewsic.ktube.internal.models

data class ClientSchema(
    val client: com.mewsic.ktube.enums.Client,
    val device: com.mewsic.ktube.enums.Device,
    val service: com.mewsic.ktube.enums.Service,
)
