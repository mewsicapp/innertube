package com.mewsic.innertube.internal.entities.search

import com.mewsic.innertube.internal.entities.content.ChannelIdentifier

class ChannelSearchResult(
    override val identifier: ChannelIdentifier
) : SearchResult()  {
}
