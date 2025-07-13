package ge.avalanche.zvavi.splash.presentation.models

data class SplashViewState(
    val isLoading: Boolean = true,
    val shouldNavigateToMain: Boolean = false
) {
    companion object {
        val INITIAL = SplashViewState()
    }
} 