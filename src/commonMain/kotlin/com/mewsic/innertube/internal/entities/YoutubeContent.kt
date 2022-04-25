package com.mewsic.innertube.internal.entities

import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext
abstract class YoutubeContent {
    abstract val identifier: YoutubeIdentifier
    abstract val coroutineContext: CoroutineContext
    abstract val coroutineScope: CoroutineScope
}
