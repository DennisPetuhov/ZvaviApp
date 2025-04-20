package ge.avalanche.zvavi.network.client

import co.touchlab.kermit.Logger
import ge.avalanche.zvavi.foundation.response.ApiResponse
import ge.avalanche.zvavi.foundation.response.toApiResponse
import ge.avalanche.zvavi.foundation.response.toApiResponseList
import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.request
import io.ktor.http.HttpMethod
import kotlinx.coroutines.withTimeout
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

/**
 * Base API client for making HTTP requests with standardized response handling
 */
class ApiClient(
    val httpClient: HttpClient,
    val json: Json,
    val baseUrl: String,
    val connectTimeout: Long = 30_000 // 30 seconds default timeout
) {
    val logger = Logger.withTag("ApiClient")

    /**
     * Make a GET request
     */
    suspend inline fun <reified T> get(
        path: String,
        crossinline block: HttpRequestBuilder.() -> Unit = {}
    ): ApiResponse<T> = request(HttpMethod.Get, path, block)

    /**
     * Make a POST request
     */
    suspend inline fun <reified T> post(
        path: String,
        crossinline block: HttpRequestBuilder.() -> Unit = {}
    ): ApiResponse<T> = request(HttpMethod.Post, path, block)

    /**
     * Make a PUT request
     */
    suspend inline fun <reified T> put(
        path: String,
        crossinline block: HttpRequestBuilder.() -> Unit = {}
    ): ApiResponse<T> = request(HttpMethod.Put, path, block)

    /**
     * Make a DELETE request
     */
    suspend inline fun <reified T> delete(
        path: String,
        crossinline block: HttpRequestBuilder.() -> Unit = {}
    ): ApiResponse<T> = request(HttpMethod.Delete, path, block)

    /**
     * Make a generic HTTP request
     */
    suspend inline fun <reified T> request(
        method: HttpMethod,
        path: String,
        crossinline block: HttpRequestBuilder.() -> Unit = {}
    ): ApiResponse<T> = try {
        withTimeout(connectTimeout) {
            val response = httpClient.request("$baseUrl$path") {
                this.method = method
                block()
            }

            response.toApiResponse(json) { element ->
                json.decodeFromJsonElement(serializer<T>(), element)
            }
        }
    } catch (e: Exception) {
        logger.e(e) { "Network request failed: ${e.message}" }
        ApiResponse.Error(0, "Network request failed: ${e.message}")
    }

    /**
     * Make a request that returns a list
     */
    suspend inline fun <reified T> requestList(
        method: HttpMethod,
        path: String,
        crossinline block: HttpRequestBuilder.() -> Unit = {}
    ): ApiResponse<List<T>> = try {
        withTimeout(connectTimeout) {
            val response = httpClient.request("$baseUrl$path") {
                this.method = method
                block()
            }

            response.toApiResponseList(json) { element ->
                json.decodeFromJsonElement(serializer<List<T>>(), element)
            }
        }
    } catch (e: Exception) {
        logger.e(e) { "Network request failed: ${e.message}" }
        ApiResponse.Error(0, "Network request failed: ${e.message}")
    }
} 