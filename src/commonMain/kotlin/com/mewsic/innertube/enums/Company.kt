package com.mewsic.innertube.enums

import com.mewsic.innertube.ext.toPascalCase

enum class Company {
    GOOGLE;

    override fun toString(): String {
        return toPascalCase()
    }
}
