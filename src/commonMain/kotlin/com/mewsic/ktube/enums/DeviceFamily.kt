package com.mewsic.ktube.enums

import com.mewsic.ktube.ext.toUpperCase

enum class DeviceFamily {
    WEB,
    MOBILE;

    override fun toString(): String {
        return toUpperCase()
    }
}
