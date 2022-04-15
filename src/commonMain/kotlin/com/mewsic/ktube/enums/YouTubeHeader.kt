package com.mewsic.ktube.enums

import com.mewsic.ktube.ext.toTrainCase

enum class YouTubeHeader {
    CLIENT_NAME,
    CLIENT_VERSION;

    override fun toString(): String {
        return "X-YouTube-${toTrainCase()}"
    }
}
