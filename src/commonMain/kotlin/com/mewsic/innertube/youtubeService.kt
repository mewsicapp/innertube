package com.mewsic.innertube

private val _youtubeService = YoutubeService()
fun youtubeService(block: YoutubeService.() -> Unit) {
    _youtubeService.apply(block)
}

