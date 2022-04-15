package com.mewsic.innertube.platform

import io.ktor.client.*
import io.ktor.client.engine.js.*

actual fun getHttpClient(block: HttpClientConfig<*>.() -> Unit): HttpClient {
    return HttpClient(Js, block)
}
