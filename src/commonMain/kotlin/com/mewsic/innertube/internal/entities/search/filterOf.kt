package com.mewsic.innertube.internal.entities.search

fun filterOf(vararg filters: Filterable) : ContentFilter{
    var filter = ContentFilter()
    for( applicableFilter in filters ) {
        filter.apply(applicableFilter)
    }
    return filter
}
