package ge.avalanche.zvavi.foundation.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

expect class DispatchersProvider{
  val io: CoroutineDispatcher
    val main: CoroutineDispatcher
    val default: CoroutineDispatcher
} 