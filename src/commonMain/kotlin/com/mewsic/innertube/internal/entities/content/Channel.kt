package com.mewsic.innertube.internal.entities.content

import com.mewsic.innertube.JsonParser
import com.mewsic.innertube.internal.entities.YoutubeContent
import com.mewsic.innertube.internal.rely
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlin.coroutines.CoroutineContext

class Channel(
    override val identifier: ChannelIdentifier,
    override val coroutineContext: CoroutineContext = Dispatchers.Unconfined,
    override val coroutineScope: CoroutineScope = MainScope()
) : YoutubeContent()  {
    lateinit var channelJson: JsonParser
    internal suspend fun fetch(): JsonParser {
        TODO()
    }

    var name by rely( on = ::channelJson, fetch = ::fetch){
        "TODO"
    }
    var bio by rely( on = ::channelJson, fetch = ::fetch){
        "TODO"
    }
    var links by rely( on = ::channelJson, fetch = ::fetch){
        TODO()
        listOf(Triple("icon url", "link text", "link url"))
    }
    var icon by rely( on = ::channelJson, fetch = ::fetch){
        "TODO"
    }
    var banner by rely( on = ::channelJson, fetch = ::fetch){
        "TODO"
    }
    var subscribers by rely( on = ::channelJson, fetch = ::fetch){
        TODO()
        2
    }
    var videos by rely( on = ::channelJson, fetch = ::fetch){
        TODO()
        listOf<Video>()
    }
    var playlists by rely( on = ::channelJson, fetch = ::fetch){
        TODO()
        listOf<Playlist>()
    }
    var channels by rely( on = ::channelJson, fetch = ::fetch){
        listOf<Pair<String, List<Channel>>>()
    }
    constructor (identifier: ChannelIdentifier, vararg partial: Pair<String, Any?>) : this(identifier) {
        listOf(
            "name",
            "bio",
            "links",
            "icon",
            "banner",
            "subscribers",
            "videos",
            "playlists",
            "channels",
        ).forEach {
            if (it in partial.map { it.first }) {
                this.apply {
                    try{
                        when (it) {
                            "name" -> name = partial.first { it.first == "name" }.second as String
                            "bio" -> bio = partial.first { it.first == "bio" }.second as String
                            "links" -> links =
                                partial.first { it.first == "links" }.second as List<Triple<String, String, String>>
                            "icon" -> icon = partial.first { it.first == "icon" }.second as String
                            "banner" -> banner = partial.first { it.first == "banner" }.second as String
                            "subscribers" -> subscribers = partial.first { it.first == "subscribers" }.second as Int
                            "videos" -> videos = partial.first { it.first == "videos" }.second as List<Video>
                            "playlists" -> playlists = partial.first { it.first == "playlists" }.second as List<Playlist>
                            "channels" -> channels =
                                partial.first { it.first == "channels" }.second as List<Pair<String, List<Channel>>>
                        }
                    } catch (e: Exception) {
                        // ignore
                    }
                }
            }
        }
    }
}
