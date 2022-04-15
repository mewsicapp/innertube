package com.mewsic.innertube.enums

import com.mewsic.innertube.ext.toTrainCase

enum class Header {
    USER_AGENT,
    REFERER,
    CONTENT_TYPE,
    ACCEPT_LANGUAGE,
    AUTHORIZATION;

    override fun toString(): String {
        return toTrainCase()
    }
}
