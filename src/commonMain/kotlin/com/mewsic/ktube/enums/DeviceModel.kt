package com.mewsic.ktube.enums

import com.mewsic.ktube.ext.toTitleCase

enum class DeviceModel {
    NEXUS_5;

    override fun toString(): String {
        return toTitleCase()
    }
}
