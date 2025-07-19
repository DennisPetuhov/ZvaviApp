package ge.avalanche.zvavi.network.di

import ge.avalanche.zvavi.network.client.ApiClient
import ge.avalanche.zvavi.network.config.NetworkConfig
import ge.avalanche.zvavi.network.ktor.HttpEngineFactory
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module


val networkModule = module {
    single { NetworkConfig.createDefault() }
    single { provideJson() }
    single<HttpClientEngineFactory<HttpClientEngineConfig>> { HttpEngineFactory().getEngine() }
    single {
        provideClient(
            config = get(),
            json = get(),
            engine = get<HttpClientEngineFactory<HttpClientEngineConfig>>()
        )
    }
    single {
        ApiClient(
            json = get(),
            httpClient = get(),
            networkConfig = get()
        )
    }
}

private fun provideJson() = Json {
    encodeDefaults = true
    prettyPrint = true
    isLenient = true
    ignoreUnknownKeys = true
    explicitNulls = false
    coerceInputValues = true
}

private fun provideClient(
    config: NetworkConfig,
    json: Json,
    enableNetworkLogs: Boolean = false,
    engine: HttpClientEngineFactory<HttpClientEngineConfig>
): HttpClient {
    return HttpClient(engine) {
        defaultRequest {
            url(config.baseUrl)
            contentType(ContentType.Application.Json)
            config.headers.forEach { (key, value) ->
                header(key, value)
            }
        }
        install(ContentNegotiation) { json(json = json) }
        if (enableNetworkLogs) {
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
        }
    }
}