package com.mewsic.innertube.enums

import com.mewsic.innertube.ext.toUpperCase

enum class DeviceFamily {
    WEB,
    MOBILE;

    override fun toString(): String {
        return toUpperCase()
    }
}
