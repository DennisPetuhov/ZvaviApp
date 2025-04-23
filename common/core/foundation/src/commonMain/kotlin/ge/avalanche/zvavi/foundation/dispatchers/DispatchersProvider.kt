package ge.avalanche.zvavi.foundation.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

expect class DispatchersProvider constructor() {
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
    val default: CoroutineDispatcher
} 