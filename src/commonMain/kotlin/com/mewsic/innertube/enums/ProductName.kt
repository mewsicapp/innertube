package com.mewsic.innertube.enums

import com.mewsic.innertube.ext.toPascalCase

enum class ProductName {
    MOZILLA;

    override fun toString(): String {
        return toPascalCase()
    }
}
