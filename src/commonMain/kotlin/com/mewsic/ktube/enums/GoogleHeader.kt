package com.mewsic.ktube.enums

import com.mewsic.ktube.ext.toTrainCase

enum class GoogleHeader {
    VISITOR_ID,
    DEVICE_AUTH,
    API_FORMAT_VERSION;

    override fun toString(): String {
        return "X-Goog-${toTrainCase()}"
    }
}
