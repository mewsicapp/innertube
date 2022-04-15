package com.mewsic.ktube.enums

import com.mewsic.ktube.ext.toLowerCase

enum class Alt {
    JSON;

    override fun toString(): String {
        return toLowerCase()
    }
}
