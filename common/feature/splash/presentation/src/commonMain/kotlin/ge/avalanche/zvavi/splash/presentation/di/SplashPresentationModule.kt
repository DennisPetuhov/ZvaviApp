package ge.avalanche.zvavi.splash.presentation.di

import ge.avalanche.zvavi.splash.presentation.SplashScreenViewModel
import org.koin.dsl.module

val splashPresentationModule = module { factory { SplashScreenViewModel() } }