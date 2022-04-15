package com.mewsic.innertube.enums

import com.mewsic.innertube.ext.toKebabCase

enum class Service {
    YOUTUBE,
    YOUTUBE_MUSIC,
    YOUTUBE_KIDS,
    YOUTUBE_STUDIO;

    override fun toString(): String {
        return toKebabCase()
    }
}
