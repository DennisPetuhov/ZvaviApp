package ge.avalanche.zvavi.network.coroutines

import co.touchlab.kermit.Logger
import ge.avalanche.zvavi.foundation.dispatchers.DispatchersProvider
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

interface NetworkScope : CoroutineScope {
    fun cancel()
}

class NetworkScopeImpl(
    private val dispatchers: DispatchersProvider,
    private val scopeName: String = "NetworkScope"
) : NetworkScope {
    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext = job + 
        dispatchers.io + 
        CoroutineName(scopeName) +
        CoroutineExceptionHandler { _, throwable ->
            Logger.e(scopeName, throwable) { "Unhandled error" }
        }
        
    override fun cancel() {
        job.cancel()
    }
} 