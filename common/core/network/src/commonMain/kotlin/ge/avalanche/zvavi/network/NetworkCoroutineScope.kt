package ge.avalanche.zvavi.network

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

class NetworkCoroutineScope : CoroutineScope {
    override val coroutineContext: CoroutineContext = 
        SupervisorJob() + 
        Dispatchers.Default + 
        CoroutineName("NetworkScope") +
        CoroutineExceptionHandler { _, throwable ->
            co.touchlab.kermit.Logger.e("NetworkScope", throwable) { "Unhandled error" }
        }
}