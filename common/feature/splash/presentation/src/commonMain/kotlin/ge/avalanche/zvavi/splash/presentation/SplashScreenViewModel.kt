package ge.avalanche.zvavi.splash.presentation

import androidx.lifecycle.viewModelScope
import ge.avalanche.zvavi.foundation.base.BaseViewModel
import ge.avalanche.zvavi.splash.presentation.models.SplashAction
import ge.avalanche.zvavi.splash.presentation.models.SplashEvent
import ge.avalanche.zvavi.splash.presentation.models.SplashViewState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenViewModel : BaseViewModel<SplashViewState, SplashAction, SplashEvent>(
    initialState = SplashViewState.INITIAL
) {
    init {
        initializeSplash()
    }
    
    override fun obtainEvent(viewEvent: SplashEvent) {
        when (viewEvent) {
            SplashEvent.Initialize -> initializeSplash()
            SplashEvent.NavigateToMain -> navigateToMainScreen()
        }
    }
    
    private fun initializeSplash() {
        viewModelScope.launch {
            delay(2000) // 2 seconds delay
            navigateToMainScreen()
        }
    }
    
    private fun navigateToMainScreen() {
        viewState = viewState.copy(
            isLoading = false,
            shouldNavigateToMain = true
        )
        viewAction = SplashAction.OpenMainScreen
    }
}