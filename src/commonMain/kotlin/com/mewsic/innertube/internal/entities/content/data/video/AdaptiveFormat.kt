package com.mewsic.innertube.internal.entities.content.data.video

import com.mewsic.innertube.JsonParser

class AdaptiveFormat(json: JsonParser) : IVideoFormat(json) {
    data class Range(val start: Long, val end: Long)
    val isAudioOnly: Boolean = mimeType.audio
    val isVideoOnly: Boolean = mimeType.video
    val initRange: Range
        get() = json.getValue("initRange")
    val indexRange: Range
        get() = json.getValue("indexRange")

}
