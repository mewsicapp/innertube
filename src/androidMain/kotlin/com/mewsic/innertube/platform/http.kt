package com.mewsic.innertube.platform

import io.ktor.client.*
import io.ktor.client.engine.cio.*

actual fun getHttpClient(block: HttpClientConfig<*>.() -> Unit): HttpClient {
    return HttpClient(CIO, block)
}
