package com.mewsic.innertube.internal.models

import com.mewsic.innertube.enums.Host

data class ServiceInfo(
    val domain: String,
) {
    constructor(host: Host) : this(host.toString())
}
