package com.mewsic.innertube.internal

import com.mewsic.innertube.JsonParser
import com.mewsic.innertube.enums.Client
import com.mewsic.innertube.enums.Host
import com.mewsic.innertube.enums.InnertubeEndpoint
import com.mewsic.innertube.platform.getHttpClient
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
//import io.ktor.http.ContentType.Application.Json
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json

class Point {
    companion object {
        internal val apiHost = Models.apis[Host.YOUTUBEI]!!
        internal val client = Models.clients[Client.ANDROID_MUSIC]!!
        internal val scope = CoroutineScope(Dispatchers.Unconfined)
        val internalHttpClient = getHttpClient {
            install(ContentNegotiation) {
                json(Json)
            }
        }
        fun toHttpRequestBuilder(endpoint: InnertubeEndpoint, block: (HttpRequestBuilder.() -> Unit)? = null): HttpRequestBuilder =
            HttpRequestBuilder().apply {
                url {
                    method = endpoint.method
                    host = apiHost.toString()
                    path(endpoint.point)
                    parameter("key", client.client.key)
                }
                client.headers(headers, null)
                block?.invoke(this)
            }
        suspend fun toJson(endpoint: InnertubeEndpoint, httpClient: HttpClient = internalHttpClient, block: (HttpRequestBuilder.() -> Unit)? = null): JsonParser =
            JsonParser(httpClient.request(toHttpRequestBuilder(endpoint, block)).bodyAsText())

        suspend inline fun <reified T : Any> to(endpoint: InnertubeEndpoint, httpClient: HttpClient = internalHttpClient, noinline block: (HttpRequestBuilder.() -> Unit)? = null): T =
            when (T::class) {
                HttpRequestBuilder::class -> toHttpRequestBuilder(endpoint, block) as T // T is HttpRequestBuilder
                JsonParser::class -> toJson(endpoint, httpClient, block) as T // T is JsonParser
                else -> throw IllegalArgumentException("T must be HttpRequestBuilder or JsonParser")
            }

    }
}
