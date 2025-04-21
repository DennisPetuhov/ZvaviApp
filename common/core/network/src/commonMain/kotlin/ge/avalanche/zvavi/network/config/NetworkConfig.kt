package ge.avalanche.zvavi.network.config

/**
 * Contains constants used for network configuration.
 */
object NetworkConstants {
    /**
     * The base URL for the API.
     */
    const val BASE_URL = "https://gnfghuusszsxjddfousc.supabase.co/rest/v1/"

    /**
     * The API key used for authentication.
     * Note: Ensure this key is securely stored and not exposed in production builds.
     */
    const val API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImduZmdodXVzc3pzeGpkZGZvdXNjIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzI0NDA3ODUsImV4cCI6MjA0ODAxNjc4NX0.eNJiMY-rj6dSOla05KHKMY1-BmuBdoT7G1E-Cb_ETws"

    /**
     * The header key for passing the API key in network requests.
     */
    const val HEADER_API_KEY = "apikey"
}

/**
 * Configuration for network requests.
 *
 * @property baseUrl The base URL for the API.
 * @property apiKey The API key for authentication.
 * @property connectTimeout Timeout for establishing a connection (in milliseconds).
 * @property readTimeout Timeout for reading data (in milliseconds).
 * @property writeTimeout Timeout for writing data (in milliseconds).
 * @property retryCount Number of retry attempts for failed requests.
 * @property retryDelay Delay between retry attempts (in milliseconds).
 * @property headers Additional headers to include in requests.
 */
data class NetworkConfig(
    val baseUrl: String,
    val apiKey: String,
    val connectTimeout: Long = 30_000,
    val readTimeout: Long = 30_000,
    val writeTimeout: Long = 30_000,
    val retryCount: Int = 3,
    val retryDelay: Long = 1000,
    val headers: Map<String, String> = emptyMap()
) {
    companion object {
        /**
         * Creates a default instance of NetworkConfig using predefined constants.
         *
         * @return A default NetworkConfig instance.
         */
        fun createDefault() = NetworkConfig(
            baseUrl = NetworkConstants.BASE_URL,
            apiKey = NetworkConstants.API_KEY,
            headers = mapOf(NetworkConstants.HEADER_API_KEY to NetworkConstants.API_KEY)
        )
    }
}
