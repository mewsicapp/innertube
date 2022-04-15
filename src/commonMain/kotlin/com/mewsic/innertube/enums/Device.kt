package com.mewsic.innertube.enums

import com.mewsic.innertube.ext.toLowerCase

enum class Device {
    WEB,
    ANDROID,
    IOS,
    LR;

    override fun toString(): String {
        return toLowerCase()
    }
}
