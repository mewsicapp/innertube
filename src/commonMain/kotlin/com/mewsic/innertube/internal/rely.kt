package com.mewsic.innertube.internal

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Semaphore
import kotlin.coroutines.CoroutineContext
import kotlin.reflect.KMutableProperty0
import kotlin.reflect.KProperty

/**
 * @author Jai
 * @date 2022/4/24
 * @constructor
 * @param GT: The type that this is waiting for. (ex. in `val x: String by waitFor(...)` this is `String`)
 * @param PT: The type of required getter that this is waiting for (ex. in `suspend fun foo(): Bar; val x: String by waitFor(foo)` this is `Bar`)
 * @param CT: The type of thisRef
 * @param semaphore: The semaphore that is used internally.
 * @param suspendFunc: The function that is used to get a value of type PT and set propertySet to it
 * @param propertySet: The settable reflection property that will become the result of suspendFunc
 * @param getter: The getter that gets a property of type GT
 * @param coroutineScope: The coroutine scope that is used internally.
 * @param coroutineContext: The coroutine context that is used internally.
 */
class rely<GT: Any, PT: Any, CT: Any>(
    private val on: KMutableProperty0<PT>,
    private val fetch: suspend () -> PT,
    private val coroutineScope: CoroutineScope = MainScope(),
    private val coroutineContext: CoroutineContext = Dispatchers.Unconfined,
    private val getter: () -> GT,
)
{
    lateinit var value: GT
    val semaphore = Semaphore(1)
    init {
        if (!::value.isInitialized) initialize()
    }
    private fun initialize() {
        coroutineScope.launch(coroutineContext) {
            if(!semaphore.tryAcquire())
                throw IllegalStateException("Semaphore is already acquired past the point of release")
            on.set(fetch())
            semaphore.release()
        }
    }
    operator fun getValue(thisRef: CT, property: KProperty<*>): GT {
        while (!semaphore.tryAcquire()) {}
        semaphore.release()
        return if (::value.isInitialized)
            value
        else
            getter.invoke().also { value = it }
    }
    operator fun setValue(thisRef: CT, property: KProperty<*>, value: GT) {
        this.value = value
    }

}

