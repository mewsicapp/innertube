package com.mewsic.innertube.internal.entities.search

import com.mewsic.innertube.internal.entities.content.PlaylistIdentifier

class PlaylistSearchResult(
    override val identifier: PlaylistIdentifier
) : SearchResult()  {
}
