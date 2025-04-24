package ge.avalanche.zvavi.foundation.di

// JVM-specific implementation of the context provider
actual class ContextProvider {
    actual fun getContext(): Any? = null
} 