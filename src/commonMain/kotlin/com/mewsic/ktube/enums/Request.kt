package com.mewsic.ktube.enums

import com.mewsic.ktube.ext.toPascalCase

enum class Request {
    CONFIG,
    SEARCH,
    PLAYER,
    HOME,
    CHANNEL_PAGE,
    PLAYLIST,
    WATCH_NEXT,
    BROWSE_HOME_PAGE,
    BROWSE_ARTIST_DETAIL_PAGE,
    BROWSE_ALBUM_DETAIL_PAGE,
    BROWSE_PLAYLIST_DETAIL_PAGE,
    BROWSE_EXPLORE_PAGE,
    BROWSE_NEW_RELEASES_PAGE,
    BROWSE_CHARTS_PAGE,
    BROWSE_MOODS_AND_GENRES_PAGE,
    BROWSE_MOODS_AND_GENRES_CATEGORY_PAGE,
    MUSIC_GUIDE,
    MUSIC_QUEUE,
    MUSIC_WATCH_NEXT,
    MUSIC_SEARCH_SUGGESTIONS,
    MOBILE_MAIN_APP_GUIDE,
    WEB_MAIN_APP_GUIDE;

    override fun toString(): String {
        return toPascalCase()
    }
}
