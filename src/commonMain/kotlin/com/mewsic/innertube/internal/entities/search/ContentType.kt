package com.mewsic.innertube.internal.entities.search

class ContentType<T : SearchResult>() : Filterable() {
    companion object {
        val Video = ContentType<VideoSearchResult>()
        val Playlist = ContentType<PlaylistSearchResult>()
        val Channel = ContentType<ChannelSearchResult>()
    }
}
