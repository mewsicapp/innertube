package com.mewsic.innertube

import com.mewsic.innertube.enums.Client
import com.mewsic.innertube.enums.GoogleHeader
import com.mewsic.innertube.enums.Host
import com.mewsic.innertube.internal.Models
import com.mewsic.innertube.internal.models.ClientSchema
import com.mewsic.innertube.internal.models.Locale
import com.mewsic.innertube.internal.session.InnertubeSession
import com.mewsic.innertube.payloads.request.*
import io.ktor.client.request.*

class InnertubeClient(val client: Client = Client.ANDROID_MUSIC, locale: Locale? = null) {
    val session = InnertubeSession(Models.apis[Host.YOUTUBEI]!!, info, locale)

    val schema: ClientSchema
        get() {
            return Models.schemas.first { it.client == client }
        }

    private val info: com.mewsic.innertube.internal.models.Client
        get() = Models.clients[client]!!
    

    suspend fun config(): JsonParser {
        return session.post("config") {
            setBody(EmptyPayload(ContextPayload(info)))
        }.also {
            if (!it.has("error")) {
                session.extraHeaders[GoogleHeader.VISITOR_ID.toString()] =
                    it["responseContext"].get<String>("visitorData")
            }
        }
    }

    suspend fun guide(): JsonParser {
        return session.post("guide") {
            setBody(EmptyPayload(ContextPayload(info)))
        }
    }

    suspend fun search(query: String) : JsonParser {
        return session.post("search") {
            setBody(SearchPayload(query, ContextPayload(info)))
        }
    }

    suspend fun player(videoId: String) : JsonParser {
        return session.post("player") {
            setBody(PlayerPayload(videoId, ContextPayload(info)))
        }
    }

    suspend fun browse(browseId: String, params: String? = null, continuation: String? = null) : JsonParser {
        return session.post("browse") {
            continuation?.let {
                parameter("continuation", it)
                parameter("ctoken", it)
            }
            setBody(BrowsePayload(browseId, params, ContextPayload(info)))
        }
    }

    suspend fun next(videoId: String, playlistId: String, params: String? = null, index: Int? = null, continuation: String? = null) : JsonParser {
        return session.post("next") {
            setBody(NextPayload(videoId, playlistId, params, index, continuation, ContextPayload(info)))
        }
    }
}
