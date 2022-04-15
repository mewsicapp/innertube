package com.mewsic.innertube.enums

enum class Domain {
    GOOGLE,
    GOOGLE_APIS,
    YOUTUBE,
    YOUTUBE_KIDS;

    override fun toString(): String {
        return name.lowercase().replace("_", "") + ".com"
    }

    fun reverse(): String {
        return name.lowercase().split("_").reversed().joinToString(".")
    }
}
