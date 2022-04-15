package com.mewsic.ktube.payloads.request

import com.mewsic.ktube.internal.models.Client
import kotlinx.serialization.Serializable

@Serializable
data class ContextPayload(
    val client: ClientPayload
) {
    constructor(client: Client) : this(ClientPayload(client.client.name.toString(), client.client.version))
}
