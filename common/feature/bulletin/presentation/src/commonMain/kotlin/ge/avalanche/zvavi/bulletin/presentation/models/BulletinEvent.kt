package ge.avalanche.zvavi.bulletin.presentation.models

import ge.avalanche.zvavi.bulletin.api.models.AvalancheProblem

sealed class BulletinEvent {
    object InfoClicked : BulletinEvent()
    object RecentAvalanchesClicked : BulletinEvent()
    object SnowPackClicked : BulletinEvent()
    object WeatherClicked : BulletinEvent()
    object AvalancheProblemsClicked : BulletinEvent()
    object TravelAdviceClicked : BulletinEvent()
    object OverviewClicked : BulletinEvent()
    object SwipeToRefresh : BulletinEvent()
    class OpenBottomSheet(val problem: AvalancheProblem) : BulletinEvent()
    object CloseBottomSheet : BulletinEvent()
    object ProblemInfoClicked : BulletinEvent()
    object ReturnFromBulletinProblemInfoScreen : BulletinEvent()
    object Retry : BulletinEvent()
}