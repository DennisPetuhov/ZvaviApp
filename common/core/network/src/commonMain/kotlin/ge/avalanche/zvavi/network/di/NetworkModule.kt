package ge.avalanche.zvavi.network.di

import ge.avalanche.zvavi.network.NetworkCoroutineScope
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
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.CoroutineScope
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import ge.avalanche.zvavi.network.client.ApiClient
import ge.avalanche.zvavi.network.client.ApiClientImpl

val networkModule = module {
    single<CoroutineScope> { NetworkCoroutineScope() }
    single { provideJson() }
    single<HttpClientEngineFactory<HttpClientEngineConfig>> { HttpEngineFactory().getEngine() }
    single { provideClient(json = get(), engine = get()) }
    single<ApiClient> { ApiClientImpl(get()) }
}

fun provideJson() = Json {
    encodeDefaults = true
    prettyPrint = true
    isLenient = true
    ignoreUnknownKeys = true
    explicitNulls = false
    coerceInputValues = true
}

fun provideClient(
    json: Json,
    enableNetworkLogs: Boolean = false,
    engine: HttpClientEngineFactory<HttpClientEngineConfig>
): HttpClient {
    return HttpClient(engine) {
        defaultRequest {
            url("https://gnfghuusszsxjddfousc.supabase.co/rest/v1/")
            contentType(ContentType.Application.Json)
        }
        install(ContentNegotiation) { json(json) }
        if (enableNetworkLogs) {
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
        }
    }
}