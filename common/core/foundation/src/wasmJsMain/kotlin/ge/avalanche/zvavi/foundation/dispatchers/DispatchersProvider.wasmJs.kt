package ge.avalanche.zvavi.foundation.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual class DispatchersProvider {
    actual val io: CoroutineDispatcher = Dispatchers.Default
    actual val main: CoroutineDispatcher = Dispatchers.Default
    actual val default: CoroutineDispatcher = Dispatchers.Default
}