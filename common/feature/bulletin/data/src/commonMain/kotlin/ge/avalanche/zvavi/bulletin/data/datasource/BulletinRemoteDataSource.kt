package ge.avalanche.zvavi.bulletin.data.datasource

import co.touchlab.kermit.Logger
import ge.avalanche.zvavi.bulletin.api.models.Bulletin
import ge.avalanche.zvavi.foundation.dispatchers.DispatchersProvider
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.statement.bodyAsText
import io.ktor.http.isSuccess
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.serialization.json.Json
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.coroutines.CoroutineContext
import ge.avalanche.zvavi.network.client.ApiClient

interface BulletinRemoteDataSource {
    suspend fun getBulletin(): List<Bulletin>
}

class BulletinRemoteDataSourceImpl(
    private val apiClient: ApiClient,
    private val baseUrl: String
) : BulletinRemoteDataSource, KoinComponent {
    private val logger = Logger.withTag("BulletinRemoteDataSource")
    private val json: Json by inject()

    override suspend fun getBulletin(): List<Bulletin> {
        try {
            val response = apiClient.client.get("${baseUrl}forecasts?order=id.desc&limit=1") {
                with(apiClient) { addDefaultHeaders() }
            }
            val responseText = response.bodyAsText()
            logger.d { "Response: $responseText" }

            if (!response.status.isSuccess()) {
                logger.e { "Failed to get bulletins: ${response.status}" }
                throw Exception("Failed to get bulletins: ${response.status}")
            }
            return try {
                val result: List<Bulletin> = json.decodeFromString(responseText)
                result
            } catch (e: Exception) {
                logger.e(e) { "Failed to deserialize response: $responseText" }
                throw e
            }
        } catch (e: Exception) {
            logger.e(e) { "Error fetching bulletins" }
            throw e
        }
    }
}

class NetworkCoroutineScope(
    private val dispatchers: DispatchersProvider
) : CoroutineScope {
    private val job = SupervisorJob()

    override val coroutineContext: CoroutineContext = job +
            dispatchers.io +
            CoroutineName("NetworkScope") +
            CoroutineExceptionHandler { _, throwable ->
                Logger.e("NetworkScope", throwable) { "Unhandled error" }
            }

    fun cancel() {
        job.cancel()
    }
}

