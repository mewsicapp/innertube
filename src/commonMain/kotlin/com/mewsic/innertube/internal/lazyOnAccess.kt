package com.mewsic.innertube.internal

import kotlin.reflect.KProperty

class lazyOnAccess<T>(private val initializer: lazyOnAccess<T>.() -> T?) {
    internal var value: T? = null

    operator fun getValue(`_`: Any?, `__`: KProperty<*>): T {
        if (value == null) {
            val v = initializer()
            if (value == null) {
                value = v ?: throw IllegalStateException("Initializer returned null")
            }
        }
        return value!!
    }
}

