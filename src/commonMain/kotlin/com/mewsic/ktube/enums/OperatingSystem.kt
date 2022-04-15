package com.mewsic.ktube.enums

import com.mewsic.ktube.ext.toPascalCase

enum class OperatingSystem {
    ANDROID;

    override fun toString(): String {
        return toPascalCase()
    }
}
