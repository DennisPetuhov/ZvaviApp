package ge.avalanche.zvavi.bulletin.presentation.di

import ge.avalanche.zvavi.bulletin.data.domain.usecase.FetchBulletinUseCase
import ge.avalanche.zvavi.bulletin.data.domain.usecase.ObserveBulletinUseCase
import ge.avalanche.zvavi.bulletin.presentation.BulletinViewModel
import ge.avalanche.zvavi.foundation.dispatchers.DispatchersProvider
import org.koin.dsl.module

val bulletinPresentationModule = module {
    single {
        BulletinViewModel(
            observeBulletinUseCase = get<ObserveBulletinUseCase>(),
            fetchBulletinUseCase = get<FetchBulletinUseCase>(),
            dispatchers = get<DispatchersProvider>()
        )
    }
} 