package com.mewsic.innertube.internal.entities.content.data.video

import com.mewsic.innertube.JsonParser

open class IVideoFormat(internal val json: JsonParser) {
    data class MimeType(internal val mimeString: String) {
        val mediaType = mimeString.substringBefore('/')
        val video: Boolean
            get() = mediaType == "video"
        val audio: Boolean
            get() = mediaType == "audio"
        val mediaFormat: String
            get() = mimeString.substringAfter('/').substringBefore(";")
        val codecs: List<String> = mimeString.substringAfter("codecs=\"").substringBefore("\"").split(", ")

    }
    val itag: Int
        get() = json.getValue("itag")
    val mimeType: MimeType
        get() = MimeType(json.getValue("mimeType"))
    val bitrate: Int
        get() = json.getValue("bitrate")
    val width: Int
        get() = json.getValue("width")
    val height: Int
        get() = json.getValue("height")
    val fps: Int
        get() = json.getValue("fps")
    val qualityLabel: String
        get() = json.getValue("qualityLabel")
    val quality: String
        get() = json.getValue("quality")
    val projectionType: String
        get() = json.getValue("projectionType")
    val audioSampleRate: Int
        get() = json.getValue("audioSampleRate")


}
