package ge.avalanche.zvavi.bulletin.presentation.di

import ge.avalanche.zvavi.bulletin.data.domain.usecase.FetchBulletinUseCase
import ge.avalanche.zvavi.bulletin.data.domain.usecase.ObserveBulletinUseCase
import ge.avalanche.zvavi.bulletin.presentation.BulletinViewModel
import org.koin.dsl.module

val bulletinPresentationModule = module {
    single {
        BulletinViewModel(
            fetchBulletinUseCase = get<FetchBulletinUseCase>(),
            observeBulletinUseCase = get<ObserveBulletinUseCase>(),
            dispatchers = get()
        )
    }
} 