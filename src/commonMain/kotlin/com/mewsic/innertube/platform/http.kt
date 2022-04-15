package com.mewsic.innertube.platform

import io.ktor.client.*

expect fun getHttpClient(block: HttpClientConfig<*>.() -> Unit): HttpClient
