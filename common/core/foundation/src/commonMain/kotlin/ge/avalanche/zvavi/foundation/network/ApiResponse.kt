package ge.avalanche.zvavi.foundation.network

sealed class ApiResponse<out T> {
    data class Success<T>(val data: T, val statusCode: Int) : ApiResponse<T>()
    data class Error(
        val code: Int,
        val message: String,
        val details: String? = null,
        val exception: Throwable? = null
    ) : ApiResponse<Nothing>()

    data object Loading : ApiResponse<Nothing>()
}

inline fun <T> ApiResponse<T>.onSuccess(action: (T) -> Unit): ApiResponse<T> {
    if (this is ApiResponse.Success) action(data)
    return this
}

inline fun <T> ApiResponse<T>.onError(action: (Int, String, String?, Throwable?) -> Unit): ApiResponse<T> {
    if (this is ApiResponse.Error) action(code, message, details, exception)
    return this
}

inline fun <T> ApiResponse<T>.onLoading(action: () -> Unit): ApiResponse<T> {
    if (this is ApiResponse.Loading) action()
    return this
}