package ge.avalanche.zvavi.splash.presentation.models

sealed class SplashEvent {
    data object Initialize : SplashEvent()
    data object NavigateToMain : SplashEvent()
} 