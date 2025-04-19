package ge.avalanche.zvavi.bulletin.presentation

import androidx.lifecycle.viewModelScope
import ge.avalanche.zvavi.bulletin.data.usecase.GetBulletinUseCase
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinAction
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinEvent
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinViewState
import ge.avalanche.zvavi.foundation.base.BaseViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class BulletinViewModel(
    private val getBulletinUseCase: GetBulletinUseCase
) : BaseViewModel<BulletinViewState, BulletinAction, BulletinEvent>(BulletinViewState.EMPTY) {

    init {
        fetchBulletinData()
    }

    override fun obtainEvent(viewEvent: BulletinEvent) {
        when (viewEvent) {
            is BulletinEvent.EmailChanged -> updateEmail(viewEvent.newValue)
            is BulletinEvent.PasswordChanged -> updatePassword(viewEvent.newValue)
            BulletinEvent.RecentAvalanchesClicked -> handleRecentAvalanchesClick()
            BulletinEvent.SnowPackClicked -> handleSnowPackClick()
            BulletinEvent.WeatherClicked -> handleWeatherClick()
            BulletinEvent.BulletinClicked -> handleBulletinClick()
            BulletinEvent.TravelAdviceClicked -> handleTravelAdviceClick()
            BulletinEvent.OverviewClicked -> handleOverviewClick()
        }
    }

    fun fetchBulletinData() {
        viewState = viewState.copy(loading = true)
        
        getBulletinUseCase.execute()
            .onEach { result ->
                result.fold(
                    onSuccess = { bulletins ->
                        val bulletin = bulletins.firstOrNull()
                        viewState = viewState.copy(
                            loading = false,
                            riskLevelOverall = bulletin?.hazardLevels?.overall ?: "",
                            overallInformation = bulletin?.summary ?: "",
                            travelAdvice = bulletin?.additionalHazards ?: "",
                            riskLevelHighAlpine = bulletin?.hazardLevels?.highAlpine ?: "",
                            riskLevelAlpine = bulletin?.hazardLevels?.alpine ?: "",
                            riskLevelSubAlpine = bulletin?.hazardLevels?.subAlpine ?: "",
                            snowpack = bulletin?.snowpack ?: "",
                            weather = bulletin?.weather ?: ""
                        )
                    },
                    onFailure = { error ->
                        viewState = viewState.copy(loading = false)
                        handleError(error)
                    }
                )
            }
            .catch { error ->
                viewState = viewState.copy(loading = false)
                handleError(error)
            }
            .launchIn(viewModelScope)
    }

    private fun handleError(error: Throwable) {
        // Handle error (e.g., show error message)
    }

    private fun updateEmail(newValue: String) {
        viewState = viewState.copy(emailValue = newValue)
    }

    private fun updatePassword(newValue: String) {
        viewState = viewState.copy(passwordValue = newValue)
    }

    private fun handleRecentAvalanchesClick() {
        viewAction = BulletinAction.OpenRecentAvalanches
    }

    private fun handleSnowPackClick() {
        viewAction = BulletinAction.OpenSnowpack
    }

    private fun handleWeatherClick() {
        viewAction = BulletinAction.OpenWeather
    }

    private fun handleBulletinClick() {
        viewAction = BulletinAction.OpenMainScreen
    }

    private fun handleTravelAdviceClick() {
        // Implement if needed
    }

    private fun handleOverviewClick() {
        // Implement if needed
    }
}