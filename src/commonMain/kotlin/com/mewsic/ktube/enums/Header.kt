package com.mewsic.ktube.enums

import com.mewsic.ktube.ext.toTrainCase

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
