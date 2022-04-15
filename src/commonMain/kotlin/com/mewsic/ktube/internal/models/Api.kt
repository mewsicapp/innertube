package com.mewsic.ktube.internal.models

import com.mewsic.ktube.enums.Host
import com.mewsic.ktube.enums.Scheme

class Api(private val domain: Host, private val port: Int? = null, private val scheme: Scheme = Scheme.HTTPS, private val mount: String = "/") {
    override fun toString(): String {
        return "$scheme://$domain${port?.let { ":$it" } ?: ""}$mount"
    }
}
