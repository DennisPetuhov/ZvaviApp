package ge.avalanche.zvavi.foundation.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

expect class DispatchersProvider : DispatcherProviderContract {
    override val io: CoroutineDispatcher
    override val main: CoroutineDispatcher
    override val default: CoroutineDispatcher
}