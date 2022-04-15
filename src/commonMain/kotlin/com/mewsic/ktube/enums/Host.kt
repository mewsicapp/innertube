package com.mewsic.ktube.enums

enum class Host(private val host: String) {
    YOUTUBEI("youtubei.${Domain.GOOGLE_APIS}"),
    SUGGEST_QUERIES("suggestqueries.${Domain.GOOGLE}"),
    YOUTUBE("www.${Domain.YOUTUBE}"),
    YOUTUBE_MUSIC("music.${Domain.YOUTUBE}"),
    YOUTUBE_STUDIO("studio.${Domain.YOUTUBE}"),
    YOUTUBE_KIDS("www.${Domain.YOUTUBE_KIDS}"),
    YOUTUBE_MOBILE("m.${Domain.YOUTUBE}");

    override fun toString(): String {
        return host
    }
}
