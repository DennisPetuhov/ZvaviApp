package ge.avalanche.zvavi.network.client

import ge.avalanche.zvavi.network.config.NetworkConfig
import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.header

interface ApiClient {
    val client: HttpClient
    fun HttpRequestBuilder.addDefaultHeaders()
}

class ApiClientImpl(override val client: HttpClient) : ApiClient {
    override fun HttpRequestBuilder.addDefaultHeaders() {
        header("apikey", NetworkConfig.SUPABASE_API_KEY)
    }
} 