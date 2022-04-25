package com.mewsic.innertube.internal.entities.orders

import com.mewsic.innertube.internal.entities.YoutubeContent
import com.mewsic.innertube.internal.entities.orders.enums.Format

class DownloadOrder(
    internal val content: YoutubeContent
) {
    internal var format: Format? = null
    internal var placeTo: String? = null
    internal var onProgress: ((Int) -> Unit)? = null
    internal var onSuccess: (() -> Unit)? = null
    fun format(format: Format){

    }
    fun to(placeTo: String){
        this.placeTo = placeTo
    }
    fun progress(block: (Int) -> Unit){
        this.onProgress = block
    }
    fun done(block: () -> Unit){
        this.onSuccess = block
    }


}
