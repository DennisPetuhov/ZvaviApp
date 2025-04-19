package ge.avalanche.zvavi.foundation.base

import ge.avalanche.zvavi.foundation.dispatchers.DispatchersProvider
import kotlinx.coroutines.withContext

abstract class BaseRepository(
    private val dispatchers: DispatchersProvider
) {
    protected suspend fun <T> withIoContext(block: suspend () -> T): T =
        withContext(dispatchers.io) {
            block()
        }
} 