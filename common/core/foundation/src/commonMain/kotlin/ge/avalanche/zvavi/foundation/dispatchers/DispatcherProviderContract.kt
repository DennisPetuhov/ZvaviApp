package ge.avalanche.zvavi.foundation.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProviderContract {
        val io: CoroutineDispatcher
        val main: CoroutineDispatcher
        val default: CoroutineDispatcher

}