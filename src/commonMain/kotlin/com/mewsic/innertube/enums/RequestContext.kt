package com.mewsic.innertube.enums

import com.mewsic.innertube.ext.toSnakeCase

enum class RequestContext {
    CHANNEL_CREATOR;

    override fun toString(): String {
        return toSnakeCase()
    }
}
