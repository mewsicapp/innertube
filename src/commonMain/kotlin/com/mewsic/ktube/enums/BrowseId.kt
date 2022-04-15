package com.mewsic.ktube.enums

enum class BrowseId {
    MUSIC_EXPLORE,
    MUSIC_NEW_RELEASES,
    MUSIC_CHARTS,
    MUSIC_HOME,
    MUSIC_MOODS_AND_GENRES,
    MUSIC_MOODS_AND_GENRES_CATEGORY;

    override fun toString(): String {
        return "FE${name.lowercase()}"
    }
}
