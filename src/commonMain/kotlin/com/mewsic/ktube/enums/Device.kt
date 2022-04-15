package com.mewsic.ktube.enums

import com.mewsic.ktube.ext.toLowerCase

enum class Device {
    WEB,
    ANDROID,
    IOS,
    LR;

    override fun toString(): String {
        return toLowerCase()
    }
}
