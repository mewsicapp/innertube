package com.mewsic.innertube.enums

import com.mewsic.innertube.ext.toTrainCase

enum class YouTubeHeader {
    CLIENT_NAME,
    CLIENT_VERSION;

    override fun toString(): String {
        return "X-YouTube-${toTrainCase()}"
    }
}
