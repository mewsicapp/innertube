package com.mewsic.innertube.internal.models

import com.mewsic.innertube.enums.Host
import com.mewsic.innertube.enums.Scheme

class Api(private val domain: Host, private val port: Int? = null, private val scheme: Scheme = Scheme.HTTPS, private val mount: String = "/") {
    override fun toString(): String {
        return "$scheme://$domain${port?.let { ":$it" } ?: ""}$mount"
    }
}
