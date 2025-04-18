package ge.avalanche.zvavi.network.ktor

import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.okhttp.OkHttp

actual class HttpEngineFactory {
   actual fun getEngine() :HttpClientEngineFactory<HttpClientEngineConfig> = OkHttp
}