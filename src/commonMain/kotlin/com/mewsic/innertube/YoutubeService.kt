package com.mewsic.innertube

import com.mewsic.innertube.enums.Client
import com.mewsic.innertube.enums.GoogleHeader
import com.mewsic.innertube.enums.Host
import com.mewsic.innertube.enums.InnertubeEndpoint
import com.mewsic.innertube.internal.Models
import com.mewsic.innertube.internal.Point
import com.mewsic.innertube.internal.bodyOf
import com.mewsic.innertube.internal.entities.YoutubeContent
import com.mewsic.innertube.internal.entities.YoutubeIdentifier
import com.mewsic.innertube.internal.entities.content.*
import com.mewsic.innertube.internal.entities.search.ContentFilter
import com.mewsic.innertube.internal.entities.search.SearchResult
import com.mewsic.innertube.internal.entities.search.ContentType
import com.mewsic.innertube.internal.entities.search.filterOf
import com.mewsic.innertube.platform.getHttpClient
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlin.properties.Delegates

class YoutubeService {
    private val scope = CoroutineScope(Dispatchers.Unconfined)
    private val _headers: MutableMap<String, String> = mutableMapOf()


    var updated by Delegates.notNull<Boolean>()

    internal val apiHttpClient = getHttpClient {
        install(ContentNegotiation) {
            json(Json)
        }
    }
    internal fun update() {
        scope.launch {
            updated = false
            val parser: JsonParser = Point.to(InnertubeEndpoint.CONFIG) {
                headers {
                    for ((key, value) in _headers) {
                        append(key, value)
                    }
                }
            }
            if (!parser.has("error"))
                _headers += Pair(GoogleHeader.VISITOR_ID.toString(), parser["responseContext"].get<String>("visitorData"))


            updated = true
        }
    }
    init {
        update()
    }
    fun search(query: String, filter: ContentFilter = filterOf(ContentType.Video)): List<SearchResult> {
        return listOf()
    }
    fun search(query: String, filter: ContentFilter = filterOf(ContentType.Video), callback: YoutubeService.(List<SearchResult>) -> Unit) {
        callback(listOf())
    }

    inline fun <reified T: YoutubeContent> fetch(resolvable: String): T? =
        when (val it = resolve(resolvable)) {
            is VideoIdentifier -> fetchVideo(it) as T? // please work
            is PlaylistIdentifier -> fetchPlaylist(it) as T?
            is ChannelIdentifier -> fetchChannel(it) as T?
            else -> null
        }
    inline fun <reified T: YoutubeContent> fetch(resolvable: String, callback: T?.(YoutubeService) -> Unit) {
        fetch<T>(resolvable)?.apply { callback(this, this@YoutubeService) }
    }
    fun resolve(resolvable: String): YoutubeIdentifier =
        when {
            resolvable.startsWith("https://www.youtube.com/watch?v=") ->
                VideoIdentifier(resolvable.substringAfter("https://www.youtube.com/watch?v=").substringBefore("&"))

            resolvable.startsWith("https://youtu.be/") ->
                VideoIdentifier(resolvable.substringAfter("https://youtu.be/"))

            resolvable.startsWith("https://www.youtube.com/embed/") ->
                VideoIdentifier(resolvable.substringAfter("https://www.youtube.com/embed/"))

            resolvable.startsWith("https://www.youtube.com/playlist?list=") ->
                PlaylistIdentifier(resolvable.substringAfter("https://www.youtube.com/playlist?list="))

            resolvable.startsWith("https://www.youtube.com/channel/") ->
                ChannelIdentifier(resolvable.substringAfter("https://www.youtube.com/channel/").substringBefore("/"))

            resolvable.matches(Regex("^[a-zA-Z0-9_-]{11}$")) ->  // accept just plain video id
                VideoIdentifier(resolvable)

            else -> throw IllegalArgumentException("Invalid resolvable: $resolvable")
        }
    fun fetchVideo(identifier: VideoIdentifier): Video {
        return Video(identifier)
    }
    fun fetchVideo(identifier: String): Video = fetchVideo(VideoIdentifier(identifier))
    fun fetchPlaylist(identifier: PlaylistIdentifier): Playlist? {
        return null
    }
    fun fetchPlaylist(identifier: String): Playlist? = fetchPlaylist(PlaylistIdentifier(identifier))
    fun fetchChannel(identifier: ChannelIdentifier): Channel? {
        return null
    }
    fun fetchChannel(identifier: String): Channel? = fetchChannel(ChannelIdentifier(identifier))

}
