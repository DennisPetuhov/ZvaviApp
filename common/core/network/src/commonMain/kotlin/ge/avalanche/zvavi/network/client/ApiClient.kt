package ge.avalanche.zvavi.network.client

import co.touchlab.kermit.Logger
import ge.avalanche.zvavi.foundation.response.ApiResponse
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

    suspend inline fun <reified T> requestList(
        method: HttpMethod,
        path: String,
        crossinline block: HttpRequestBuilder.() -> Unit = {}
    ): ApiResponse<List<T>> = try {
        withTimeout(networkConfig.connectTimeout) {
            val response = httpClient.request("${networkConfig.baseUrl}$path") {
                this.method = method
                block()
            }

            when {
                response.status.isSuccess() -> {
                    try {
                        val data = json.decodeFromString<List<T>>(response.bodyAsText())
                        Logger.d { "Parsed list response: $data" }
                        ApiResponse.Success(data, response.status.value)
                    } catch (e: Exception) {
                        logger.e(e) { "Failed to parse list response" }
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
                    ApiResponse.Error(
                        response.status.value,
                        "HTTP error",
                        errorMessage
                    )
                }
            }
        }
    } catch (e: Exception) {
        logger.e(e) { "Network request failed" }
        ApiResponse.Error(0, e.message ?: "Unknown error", null, e)
    }
}