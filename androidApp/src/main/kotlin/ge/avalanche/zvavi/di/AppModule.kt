package ge.avalanche.zvavi.di

import ge.avalanche.zvavi.bulletin.di.AndroidDispatchersProvider
import ge.avalanche.zvavi.common.core.foundation.base.DispatchersProvider
import org.koin.dsl.module

val appModule = module {
    single<DispatchersProvider> { AndroidDispatchersProvider() }
} 