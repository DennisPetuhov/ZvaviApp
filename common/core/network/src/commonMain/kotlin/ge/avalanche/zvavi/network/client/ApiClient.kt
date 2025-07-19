package ge.avalanche.zvavi.network.client

import co.touchlab.kermit.Logger
import ge.avalanche.zvavi.foundation.network.ApiResponse
import ge.avalanche.zvavi.network.config.NetworkConfig
import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.request
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpMethod
import io.ktor.http.isSuccess
import kotlinx.coroutines.withTimeout
import kotlinx.serialization.json.Json

class ApiClient(
    val httpClient: HttpClient,
    val json: Json,
    val networkConfig: NetworkConfig,
) {
val logger = Logger.withTag("ApiClient")

    suspend inline fun <reified T> requestBulletin(
        method: HttpMethod,
        path: String,
        crossinline block: HttpRequestBuilder.() -> Unit = {}
    ): ApiResponse<T> = try {
        logger.d { "Making network request to: ${networkConfig.baseUrl}$path" }
        withTimeout(networkConfig.connectTimeout) {
            val response = httpClient.request("${networkConfig.baseUrl}$path") {
                this.method = method
                block()
            }

            logger.d { "Received response with status: ${response.status.value}" }
            when {
                response.status.isSuccess() -> {
                    try {
                        val responseText = response.bodyAsText()
                        logger.d { "Response body: $responseText" }
                        val data = json.decodeFromString<T>(responseText)
                        logger.d { "Successfully parsed response: $data" }
                        ApiResponse.Success(data, response.status.value)
                    } catch (e: Exception) {
                        logger.e(e) { "Failed to parse response: ${e.message}" }
                        ApiResponse.Error(
                            response.status.value,
                            "Failed to parse response",
                            response.bodyAsText(),
                            e
                        )
                    }
                }
                else -> {
                    val errorMessage = response.bodyAsText()
                    logger.e { "HTTP error: ${response.status.value}, message: $errorMessage" }
                    ApiResponse.Error(
                        response.status.value,
                        "HTTP error",
                        errorMessage
                    )
                }
            }
        }
    } catch (e: Exception) {
        logger.e(e) { "Network request failed: ${e.message}" }
        ApiResponse.Error(0, e.message ?: "Unknown error", null, e)
    }
}