package com.mewsic.ktube.enums

import com.mewsic.ktube.ext.toLowerCase

enum class Scheme {
    HTTP,
    HTTPS;

    override fun toString(): String {
        return toLowerCase()
    }
}
