package com.mewsic.innertube.internal.models

data class Locale(
    val hl: String,
    val gl: String?
) {
    val acceptLanguage: String
        get() = if (gl != null) "$hl,$gl" else hl

    fun asMap(): Map<String, String> {
        val map = mutableMapOf<String, String>()
        map["hl"] = hl
        if (gl != null) {
            map["gl"] = gl
        }
        return map
    }
}
