package ge.avalanche.zvavi.network.result

sealed class NetworkResult<out T> {
    data class Success<T>(val data: T) : NetworkResult<T>()
    data class Error(val exception: Throwable) : NetworkResult<Nothing>()  // Current version
    data object Loading : NetworkResult<Nothing>()
}