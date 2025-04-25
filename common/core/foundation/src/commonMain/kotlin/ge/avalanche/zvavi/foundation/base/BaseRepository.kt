package ge.avalanche.zvavi.foundation.base

import co.touchlab.kermit.Logger
import ge.avalanche.zvavi.foundation.dispatchers.DispatchersProvider
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull

/**
 * Base repository class that provides common functionality for all repositories.
 * Handles threading, timeouts, and error handling.
 */
abstract class BaseRepository(
    protected val dispatchers: DispatchersProvider,
    protected val logger: Logger = Logger.withTag("BaseRepository")
) {
    /**
     * Executes a block of code on the IO dispatcher.
     * This ensures that potentially blocking operations don't block the main thread.
     */
    protected suspend fun <T> withIoContext(block: suspend () -> T): T =
        withContext(dispatchers.io) {
            block()
        }

    /**
     * Executes a block of code with a timeout.
     * If the operation takes longer than the specified timeout, it will throw a TimeoutException.
     */
    protected suspend fun <T> withTimeout(
        timeoutMillis: Long,
        block: suspend () -> T
    ): T = kotlinx.coroutines.withTimeout(timeoutMillis) {
        block()
    }

    /**
     * Executes a block of code with a timeout.
     * If the operation takes longer than the specified timeout, it will return null.
     */
    protected suspend fun <T> withTimeoutOrNull(
        timeoutMillis: Long,
        block: suspend () -> T
    ): T? = withTimeoutOrNull(timeoutMillis) {
        block()
    }

    /**
     * Executes a block of code and logs any exceptions that occur.
     * This provides a consistent way to handle errors across repositories.
     */
    protected suspend fun <T> safeApiCall(
        errorMessage: String = "An unknown error occurred",
        block: suspend () -> T
    ): T? {
        return try {
            block()
        } catch (e: Exception) {
            logger.e(e) { errorMessage }
            null
        }
    }

    /**
     * Executes a block of code on the IO dispatcher and logs any exceptions that occur.
     * This combines the functionality of withIoContext and safeApiCall.
     */
    protected suspend fun <T> safeApiCallWithIo(
        errorMessage: String = "An unknown error occurred",
        block: suspend () -> T
    ): T? {
        return withIoContext {
            safeApiCall(errorMessage, block)
        }
    }
} 