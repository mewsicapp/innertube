package com.mewsic.innertube.internal.entities.search

import com.mewsic.innertube.internal.entities.content.VideoIdentifier

class VideoSearchResult(
    override val identifier: VideoIdentifier
) : SearchResult() {

}
