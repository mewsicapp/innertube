package com.mewsic.ktube.enums

import com.mewsic.ktube.ext.toPascalCase

enum class DeviceMake {
    GOOGLE;

    override fun toString(): String {
        return toPascalCase()
    }
}
