package com.mewsic.innertube.enums

import com.mewsic.innertube.ext.toPascalCase

enum class OperatingSystem {
    ANDROID;

    override fun toString(): String {
        return toPascalCase()
    }
}
