package ge.avalanche.zvavi.splash.presentation.models

sealed class SplashAction {
    data object OpenMainScreen : SplashAction()
}