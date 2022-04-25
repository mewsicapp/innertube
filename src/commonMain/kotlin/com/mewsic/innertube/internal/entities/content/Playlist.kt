package com.mewsic.innertube.internal.entities.content

import com.mewsic.innertube.internal.entities.YoutubeContent

class Playlist(
    override val identifier: PlaylistIdentifier
) : YoutubeContent()  {
}
