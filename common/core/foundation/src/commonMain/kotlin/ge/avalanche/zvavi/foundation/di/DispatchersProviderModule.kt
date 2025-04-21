package ge.avalanche.zvavi.foundation.di

import ge.avalanche.zvavi.foundation.dispatchers.DispatchersProvider
import org.koin.dsl.module

val dispatchersProviderModule = module {
    single<DispatchersProvider> {
        DispatchersProvider()
    }
}