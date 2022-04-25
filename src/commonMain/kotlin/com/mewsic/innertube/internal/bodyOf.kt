package com.mewsic.innertube.internal

import com.mewsic.innertube.internal.models.*
import io.ktor.client.request.*

internal val defaultClient = Models.clients[com.mewsic.innertube.enums.Client.ANDROID_MUSIC]!!
fun HttpRequestBuilder.bodyOf(vararg attrs: Pair<String, *>, client: Client = defaultClient) {
    setBody(mapOf(
        *attrs,
        "context" to mapOf(
            "client" to mapOf(
                "clientName" to client.client.name.toString(),
                "clientVersion" to client.client.version,
            )
        ))
    )
}
