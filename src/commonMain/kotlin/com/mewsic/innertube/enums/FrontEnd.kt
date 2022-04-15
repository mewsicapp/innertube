package com.mewsic.innertube.enums

import com.mewsic.innertube.ext.toKebabCase

enum class FrontEnd {
    YOUTUBE,
    YOUTUBE_PEGASUS_WEB,
    YOUTUBE_MUSIC_ANDROID,
    YOUTUBE_MUSIC_IOS,
    YOUTUBE_LR,
    YOUTUBE_REDUCED;

    override fun toString(): String {
        return toKebabCase()
    }
}
