package com.mewsic.innertube.internal.session

import com.mewsic.innertube.JsonParser
import com.mewsic.innertube.enums.Alt
import com.mewsic.innertube.enums.Host
import com.mewsic.innertube.internal.Models
import com.mewsic.innertube.internal.models.Api
import com.mewsic.innertube.internal.models.Client
import com.mewsic.innertube.internal.models.Locale
import com.mewsic.innertube.platform.getHttpClient
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json
import kotlin.math.min

class InnertubeSession(private val baseUrl: Api = Models.apis[Host.YOUTUBEI]!!, @PublishedApi internal val client: Client, private val locale: Locale? = null) {
    val extraHeaders = mutableMapOf<String, String>()

    @PublishedApi
    internal val apiHttpClient = getHttpClient {
        install(DefaultRequest) {
            url(baseUrl.toString())
            client.headers(headers, locale)
        }
        install(ContentNegotiation) {
            json(Json {

            })
        }
    }

    suspend fun get(url: String) : ByteArray {
        val response = apiHttpClient.get(url) {
            parameter("key", client.client.key)
            parameter("alt", Alt.JSON.toString())
            extraHeaders.forEach {
                header(it.key, it.value)
            }
        }

        println(response)

        return response.readBytes()
    }

    fun readStream(url: String) = flow {
        val chunkSize = 9 * (1 shl 20)
        var totalSize = chunkSize
        var downloaded = 0

        while (downloaded < totalSize) {
            val stopPos = min(downloaded + chunkSize, totalSize) - 1
            val header = "bytes=${downloaded}-${stopPos}"

            val res = apiHttpClient.get(url) {
                headers.append("Range", header)
            }

            if (totalSize == chunkSize) {
                totalSize = res.headers["Content-Range"]!!.split("/").last().toInt()
            }

            val data = res.readBytes()

            emit(data)
            downloaded += data.size
        }
    }

    suspend fun post(path: String, builder: HttpRequestBuilder.() -> Unit = {}) : JsonParser {
        val json = apiHttpClient.post(path) {
            builder()
            parameter("key", client.client.key)
            parameter("alt", Alt.JSON.toString())
            extraHeaders.forEach {
                header(it.key, it.value)
            }
        }.bodyAsText()
        return JsonParser(json)
    }
}
