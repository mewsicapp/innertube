package com.mewsic.innertube.internal.entities.content

import com.mewsic.innertube.JsonParser
import com.mewsic.innertube.enums.InnertubeEndpoint
import com.mewsic.innertube.internal.Point
import com.mewsic.innertube.internal.bodyOf
import com.mewsic.innertube.internal.entities.YoutubeContent
import com.mewsic.innertube.internal.entities.content.data.Thumbnail
import com.mewsic.innertube.internal.entities.content.data.video.AdaptiveFormat
import com.mewsic.innertube.internal.entities.content.data.video.FormatList
import com.mewsic.innertube.internal.entities.content.data.video.IVideoFormat
import com.mewsic.innertube.internal.entities.content.data.video.VideoFormat
import com.mewsic.innertube.internal.entities.orders.enums.Format
import com.mewsic.innertube.internal.rely
import io.ktor.util.date.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlin.coroutines.CoroutineContext

class Video(
    override val identifier: VideoIdentifier,
    override val coroutineContext: CoroutineContext = Dispatchers.Unconfined,
    override val coroutineScope: CoroutineScope = MainScope()

) : YoutubeContent() {
    internal lateinit var videoJson: JsonParser
    internal var _fetchingVideoJson = false
    suspend fun fetch(): JsonParser {
        if (::videoJson.isInitialized) return videoJson
        _fetchingVideoJson = true
        return Point.to<JsonParser>(InnertubeEndpoint.VIDEO) {
            bodyOf("videoId" to identifier.id)
        }.also {
            _fetchingVideoJson = false
            videoJson = it
        }
    }

    val title by rely(on = ::videoJson, fetch = ::fetch) {
        videoJson["videoDetails"]["title"].interpret<String>()
    }
    val author by rely(on = ::videoJson, fetch = ::fetch) {
        Channel(
            ChannelIdentifier(videoJson["videoDetails"]["channelId"].interpret()),
            Pair("name", videoJson["videoDetails"]["author"].interpret<String>())
        )
    }
    val viewCount by rely(on = ::videoJson, fetch = ::fetch) {
        videoJson["videoDetails"]["viewCount"].interpret<Int>()
    }
    val thumbnails by rely(on = ::videoJson, fetch = ::fetch) {
        videoJson["videoDetails"]["thumbnail"]["thumbnails"].interpret<List<Thumbnail>>()
    }
    val duration by rely(on = ::videoJson, fetch = ::fetch) {
        videoJson["videoDetails"]["lengthSeconds"].interpret<Int>()
    }
    val isLive by rely(on = ::videoJson, fetch = ::fetch) {
        videoJson["videoDetails"]["isLiveContent"].interpret<Boolean>()
    }
    val streamingExpiresIn by rely(on = ::videoJson, fetch = ::fetch) {
        videoJson["streamingData"]["expiresInSeconds"].interpret<Int>() // no better way to do this in common code :(
    }
    val formats by rely(on = ::videoJson, fetch = ::fetch) {
        FormatList.from(
            listOf(
                *videoJson["streamingData"]["formats"].interpret<List<VideoFormat>>().toTypedArray(),
                *videoJson["streamingData"]["adaptiveFormats"].interpret<List<AdaptiveFormat>>().toTypedArray()
            )
        )
    }


}
