package com.mewsic.innertube.enums

import com.mewsic.innertube.ext.toPascalCase

enum class DeviceMake {
    GOOGLE;

    override fun toString(): String {
        return toPascalCase()
    }
}
