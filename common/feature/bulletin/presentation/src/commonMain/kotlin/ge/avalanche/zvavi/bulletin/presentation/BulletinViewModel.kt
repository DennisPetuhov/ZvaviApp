package ge.avalanche.zvavi.bulletin.presentation

import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import ge.avalanche.zvavi.bulletin.data.usecase.GetBulletinUseCase
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinAction
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinEvent
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinViewState
import ge.avalanche.zvavi.foundation.base.BaseViewModel
import kotlinx.coroutines.launch

class BulletinViewModel(
    private val getBulletinUseCase: GetBulletinUseCase
) : BaseViewModel<BulletinViewState, BulletinAction, BulletinEvent>(
    BulletinViewState.EMPTY
) {

    private val logger = Logger.withTag("BulletinViewModel")

    override fun obtainEvent(viewEvent: BulletinEvent) {
        when (viewEvent) {
            is BulletinEvent.BulletinClicked -> fetchBulletinData()
            else -> { /* Handle other events */
            }
        }
    }

    fun fetchBulletinData() {
        viewModelScope.launch {
            viewState = viewState.copy(loading = true)
            try {
                getBulletinUseCase.execute().collect { result ->
                    result.onSuccess { bulletins ->
                        if (bulletins.isNotEmpty()) {
                            val firstBulletin = bulletins.first()
                            viewState = viewState.copy(
                                loading = false,
                                riskLevelOverall = firstBulletin.hazardLevels.overall,
                                riskLevelHighAlpine = firstBulletin.hazardLevels.highAlpine,
                                riskLevelAlpine = firstBulletin.hazardLevels.alpine,
                                riskLevelSubAlpine = firstBulletin.hazardLevels.subAlpine,
                                overallInformation = firstBulletin.summary,
                                travelAdvice = firstBulletin.additionalHazards,
                                snowpack = firstBulletin.snowpack,
                                weather = firstBulletin.weather
                            )
                        }
                    }.onFailure { error ->
                        logger.e(error) { "Failed to fetch bulletin data" }
                        viewState = viewState.copy(
                            loading = false,
                        )
                    }
                }
            } catch (e: Exception) {
                logger.e(e) { "Exception while fetching bulletin data" }
                viewState = viewState.copy(
                    loading = false,
                )
            }
        }
    }
}