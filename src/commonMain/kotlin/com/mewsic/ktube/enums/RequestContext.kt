package com.mewsic.ktube.enums

import com.mewsic.ktube.ext.toSnakeCase

enum class RequestContext {
    CHANNEL_CREATOR;

    override fun toString(): String {
        return toSnakeCase()
    }
}
