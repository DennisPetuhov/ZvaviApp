package ge.avalanche.zvavi.network.ktor

import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.js.Js


actual class HttpEngineFactory {
    actual fun getEngine() :HttpClientEngineFactory<HttpClientEngineConfig> = Js
}