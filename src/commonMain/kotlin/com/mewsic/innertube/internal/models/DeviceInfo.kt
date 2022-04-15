package com.mewsic.innertube.internal.models

import com.mewsic.innertube.enums.Device
import com.mewsic.innertube.enums.DeviceFamily
import com.mewsic.innertube.enums.Product

data class DeviceInfo(
    val identifier: String,
    val family: DeviceFamily,
    val comments: List<String>
) {
    constructor(identifier: Device, family: DeviceFamily, comments: List<String>) : this(
        identifier.toString(),
        family,
        comments
    )

    val product: String?
        get() {
            if (family != DeviceFamily.WEB) {
                return null
            }

            return "${Product.MOZILLA}/${Product.MOZILLA.version}" + if (comments.isEmpty()) "" else " (${comments.joinToString("; ")})"
        }
}
