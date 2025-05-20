package ge.avalanche.zvavi.bulletin.presentation

import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import ge.avalanche.zvavi.bulletin.data.domain.usecase.FetchBulletinUseCase
import ge.avalanche.zvavi.bulletin.data.domain.usecase.ObserveBulletinUseCase
import ge.avalanche.zvavi.bulletin.data.repository.NoDataException
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinAction
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinEvent
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinViewState
import ge.avalanche.zvavi.foundation.base.BaseViewModel
import ge.avalanche.zvavi.foundation.dispatchers.DispatchersProvider
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

internal class BulletinViewModel(
    private val observeBulletinUseCase: ObserveBulletinUseCase,
    private val fetchBulletinUseCase: FetchBulletinUseCase,
    private val dispatchers: DispatchersProvider,
) : BaseViewModel<BulletinViewState, BulletinAction, BulletinEvent>(BulletinViewState.EMPTY) {

    private val logger = Logger.withTag("BulletinViewModel")
    private var bulletinJob: Job? = null
    private var retryCount = 0
    private val maxRetries = 3

    init {
        observeBulletinData()
    }

    override fun obtainEvent(viewEvent: BulletinEvent) {
        when (viewEvent) {
            BulletinEvent.RecentAvalanchesClicked -> handleRecentAvalanchesClick()
            BulletinEvent.SnowPackClicked -> handleSnowPackClick()
            BulletinEvent.WeatherClicked -> handleWeatherClick()
            BulletinEvent.TravelAdviceClicked -> handleTravelAdviceClick()
            BulletinEvent.OverviewClicked -> handleOverviewClick()
            BulletinEvent.SwipeToRefresh -> retryFetchBulletin()
            BulletinEvent.AvalancheProblemsClicked -> fetchBulletin()
            BulletinEvent.InfoClicked -> viewModelScope.launch { fetchBulletinUseCase.execute() }
            BulletinEvent.CloseBottomSheet -> handleCloseBottomSheet()
            BulletinEvent.OpenBottomSheet -> handleOpenBottomSheet()
            BulletinEvent.ProblemInfoClicked -> handleNavigateToBulletinProblemInfoScreen()
            BulletinEvent.ReturnFromBulletinProblemInfoScreen -> handleReturnFromBulletinProblemScreen()
            BulletinEvent.Retry -> {}
        }
    }

    fun handleReturnFromBulletinProblemScreen() {

    }

    fun handleReturnFromBulletinProblemScreen() {
        viewState = viewState.copy(showBottomSheet = true)
    }

    fun handleOpenBottomSheet() {
        viewState = viewState.copy(showBottomSheet = true)
    }

    private fun handleNavigateToBulletinProblemInfoScreen() {
        viewState = viewState.copy(showBottomSheet = false)
        viewAction = BulletinAction.OpenProblemInfoScreen
    }

    private fun handleCloseBottomSheet() {
        viewState = viewState.copy(showBottomSheet = false)
//
    }

    fun fetchBulletin() {
        viewModelScope.launch {
            try {
                fetchBulletinUseCase.execute()
                logger.d { "Bulletin fetched successfully" }
            } catch (e: Exception) {
                logger.e(e) { "Error fetching bulletin" }
            }
        }
    }
    fun observeBulletinData() {
        bulletinJob?.cancel()
        retryCount = 0
        bulletinJob = viewModelScope.launch {
            try {
                fetchBulletinUseCase.execute()
                logger.d { "Successfully fetched bulletin data" }
            } catch (e: Exception) {
                logger.e(e) { "Error fetching bulletin data" }
            }
            observeBulletinUseCase.execute()
                .onEach { bulletin ->
                    logger.d { "Received bulletin from database: $bulletin" }
                    viewState = viewState.copy(
                        loading = false,
                        error = null,
                        riskLevelOverall = bulletin.hazardLevels.overall,
                        overallInformation = bulletin.summary,
                        travelAdvice = bulletin.additionalHazards,
                        riskLevelHighAlpine = bulletin.hazardLevels.highAlpine,
                        riskLevelAlpine = bulletin.hazardLevels.alpine,
                        riskLevelSubAlpine = bulletin.hazardLevels.subAlpine,
                        snowpack = bulletin.snowpack,
                        weather = bulletin.weather,
                        topTriangleColor = bulletin.hazardLevels.highAlpine,
                        middleTriangleColor = bulletin.hazardLevels.highAlpine,
                        bottomTriangleColor = bulletin.hazardLevels.highAlpine,
                    )
                    retryCount = 0
                }
                .catch { e ->
                    logger.e(e) { "Error in BulletinViewModel" }
                    handleError(e)
                }.launchIn(this)
        }
    }

    private fun handleError(e: Throwable) {
        if (retryCount < maxRetries) {
            retryCount++
            val delayMillis = 1000L * (1 shl (retryCount - 1)) // 1s, 2s, 4s
            logger.i { "Retrying fetch (attempt $retryCount of $maxRetries) after $delayMillis ms" }

            viewModelScope.launch {
                delay(delayMillis)
                observeBulletinData()
            }
        } else {
            val errorMessage = when (e) {
                is NoDataException -> "No bulletin data available"
                else -> "Failed to load bulletin: ${e.message}"
            }
            viewState = viewState.copy(
                loading = false,
                error = errorMessage
            )
        }
    }

    fun retryFetchBulletin() {
        retryCount = 0
        observeBulletinData()
    }

    private fun handleRecentAvalanchesClick() {
        // Implementation for recent avalanches click
    }

    private fun handleSnowPackClick() {
        // Implementation for snow pack click
    }

    private fun handleWeatherClick() {
        // Implementation for weather click
    }

    private fun handleBulletinClick() {
        // Implementation for bulletin click
    }

    private fun handleTravelAdviceClick() {
        // Implementation for travel advice click
    }

    private fun handleOverviewClick() {
        // Implementation for overview click
    }
}