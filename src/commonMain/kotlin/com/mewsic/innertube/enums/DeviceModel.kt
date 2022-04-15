package com.mewsic.innertube.enums

import com.mewsic.innertube.ext.toTitleCase

enum class DeviceModel {
    NEXUS_5;

    override fun toString(): String {
        return toTitleCase()
    }
}
