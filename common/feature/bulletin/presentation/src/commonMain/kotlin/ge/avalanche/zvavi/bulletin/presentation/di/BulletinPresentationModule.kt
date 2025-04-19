package ge.avalanche.zvavi.bulletin.presentation.di

import ge.avalanche.zvavi.bulletin.data.usecase.GetBulletinUseCase
import ge.avalanche.zvavi.bulletin.presentation.BulletinViewModel
import org.koin.dsl.module

val bulletinPresentationModule = module {
    factory<BulletinViewModel> { 
        BulletinViewModel(
            getBulletinUseCase = get<GetBulletinUseCase>()
        ) 
    }
} 