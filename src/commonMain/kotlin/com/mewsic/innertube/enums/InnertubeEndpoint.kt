package com.mewsic.innertube.enums

import io.ktor.http.*

enum class InnertubeEndpoint(val point: String, val method: HttpMethod) {
    CONFIG("/config", HttpMethod.Post),
    GUIDE("/guide", HttpMethod.Post),
    SEARCH("/search", HttpMethod.Post),
    VIDEO("/player", HttpMethod.Post),
    BROWSE("/browse", HttpMethod.Post),
    VIDEO_NEXT("/next", HttpMethod.Post),

}
