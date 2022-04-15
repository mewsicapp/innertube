package com.mewsic.innertube

import com.mewsic.innertube.enums.Client
import com.mewsic.innertube.enums.GoogleHeader
import com.mewsic.innertube.enums.Host
import com.mewsic.innertube.internal.Models
import com.mewsic.innertube.internal.models.ClientSchema
import com.mewsic.innertube.internal.models.Locale
import com.mewsic.innertube.internal.session.InnertubeSession
import com.mewsic.innertube.payloads.request.*
import com.mewsic.innertube.payloads.response.ConfigResponse
import com.mewsic.innertube.payloads.response.GuideResponse
import io.ktor.client.request.*

class InnertubeClient(val client: Client = Client.ANDROID_MUSIC, locale: Locale? = null) {
    val session = InnertubeSession(Models.apis[Host.YOUTUBEI]!!, info, locale)

    val schema: ClientSchema
        get() {
            return Models.schemas.first { it.client == client }
        }

    private val info: com.mewsic.innertube.internal.models.Client
        get() = Models.clients[client]!!

    suspend fun config() : ConfigResponse {
        return configJson().interpret()
    }

    private suspend fun configJson(): JsonParser {
        return session.postJson("config") {
            setBody(EmptyPayload(ContextPayload(info)))
        }.also {
            if (!it.has("error")) {
                session.extraHeaders[GoogleHeader.VISITOR_ID.toString()] =
                    it["responseContext"].get<String>("visitorData")
            }
        }
    }

    suspend fun guide() : GuideResponse {
        return guideJson().interpret()
    }

    private suspend fun guideJson(): JsonParser {
        return session.postJson("guide") {
            setBody(EmptyPayload(ContextPayload(info)))
        }
    }

    suspend fun searchJson(query: String) : JsonParser {
        return session.postJson("search") {
            setBody(SearchPayload(query, ContextPayload(info)))
        }
    }

    suspend fun playerJson(videoId: String) : JsonParser {
        return session.postJson("player") {
            setBody(PlayerPayload(videoId, ContextPayload(info)))
        }
    }

    suspend fun browseJson(browseId: String, params: String? = null, continuation: String? = null) : JsonParser {
        return session.postJson("browse") {
            continuation?.let {
                parameter("continuation", it)
                parameter("ctoken", it)
            }
            setBody(BrowsePayload(browseId, params, ContextPayload(info)))
        }
    }

    suspend fun nextJson(videoId: String, playlistId: String, params: String? = null, index: Int? = null, continuation: String? = null) : JsonParser {
        return session.postJson("next") {
            setBody(NextPayload(videoId, playlistId, params, index, continuation, ContextPayload(info)))
        }
    }
}
