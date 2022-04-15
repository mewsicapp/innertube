package com.mewsic.ktube.enums

import com.mewsic.ktube.ext.toPascalCase

enum class ProductName {
    MOZILLA;

    override fun toString(): String {
        return toPascalCase()
    }
}
