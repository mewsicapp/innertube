package com.mewsic.ktube.enums

import com.mewsic.ktube.ext.toKebabCase

enum class Service {
    YOUTUBE,
    YOUTUBE_MUSIC,
    YOUTUBE_KIDS,
    YOUTUBE_STUDIO;

    override fun toString(): String {
        return toKebabCase()
    }
}
