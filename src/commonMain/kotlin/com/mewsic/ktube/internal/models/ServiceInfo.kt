package com.mewsic.ktube.internal.models

import com.mewsic.ktube.enums.Host

data class ServiceInfo(
    val domain: String,
) {
    constructor(host: Host) : this(host.toString())
}
