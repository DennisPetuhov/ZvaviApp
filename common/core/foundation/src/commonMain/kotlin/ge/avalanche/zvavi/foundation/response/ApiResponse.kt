package ge.avalanche.zvavi.foundation.response

import co.touchlab.kermit.Logger
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.isSuccess
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonPrimitive

/**
 * Wrapper for API responses that provides a consistent way to handle success and error cases
 */
sealed class ApiResponse<out T> {
    data class Success<T>(val data: T, val statusCode: Int) : ApiResponse<T>()
    data class Error(val code: Int, val message: String, val details: String? = null) :
        ApiResponse<Nothing>()

    data object Loading : ApiResponse<Nothing>()

    val isSuccess: Boolean get() = this is Success
    val isError: Boolean get() = this is Error
    val isLoading: Boolean get() = this is Loading
}

/**
 * Extension function to parse HttpResponse into ApiResponse
 */
suspend fun <T> HttpResponse.toApiResponse(
    json: Json,
    parser: (JsonElement) -> T
): ApiResponse<T> {
    val statusCode = status.value
    val responseText = bodyAsText()

    return try {
        if (status.isSuccess()) {
            val jsonElement = json.parseToJsonElement(responseText)
            ApiResponse.Success(parser(jsonElement), statusCode)
        } else {
            val errorMessage = try {
                val jsonElement = json.parseToJsonElement(responseText)
                if (jsonElement is JsonObject) {
                    jsonElement["message"]?.jsonPrimitive?.content ?: "Unknown error"
                } else {
                    "Unknown error"
                }
            } catch (e: Exception) {
                "Error with status code: $statusCode"
            }

            ApiResponse.Error(statusCode, errorMessage, responseText)
        }
    } catch (e: Exception) {
        Logger.e("ApiResponse") { "Failed to parse response: $responseText" }
        ApiResponse.Error(statusCode, "Failed to parse response: ${e.message}", responseText)
    }
}

inline fun <T> ApiResponse<T>.onSuccess(action: (T) -> Unit): ApiResponse<T> {
    if (this is ApiResponse.Success) action(data)
    return this
}

inline fun <T> ApiResponse<T>.onError(action: (Int, String, String?) -> Unit): ApiResponse<T> {
    if (this is ApiResponse.Error) action(code, message, details)
    return this
}

inline fun <T> ApiResponse<T>.onLoading(action: () -> Unit): ApiResponse<T> {
    if (this is ApiResponse.Loading) action()
    return this
}

/**
 * Extension function to map ApiResponse to another type
 */
inline fun <T, R> ApiResponse<T>.map(transform: (T) -> R): ApiResponse<R> = when (this) {
    is ApiResponse.Success -> ApiResponse.Success(transform(data), statusCode)
    is ApiResponse.Error -> ApiResponse.Error(code, message, details)
    is ApiResponse.Loading -> ApiResponse.Loading
}

/**
 * Extension functions to get data from ApiResponse
 */
fun <T> ApiResponse<T>.getOrNull(): T? = when (this) {
    is ApiResponse.Success -> data
    else -> null
}

fun <T> ApiResponse<T>.getOrThrow(): T = when (this) {
    is ApiResponse.Success -> data
    is ApiResponse.Error -> throw IllegalStateException("$message (code: $code)")
    is ApiResponse.Loading -> throw IllegalStateException("Result is loading")
} 