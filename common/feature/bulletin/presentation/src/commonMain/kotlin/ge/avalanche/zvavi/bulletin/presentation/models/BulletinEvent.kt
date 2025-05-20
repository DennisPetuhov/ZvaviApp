package ge.avalanche.zvavi.bulletin.presentation.models

sealed class BulletinEvent {
    object InfoClicked : BulletinEvent()
    object ProblemInfoClicked : BulletinEvent()
    object RecentAvalanchesClicked : BulletinEvent()
    object SnowPackClicked : BulletinEvent()
    object WeatherClicked : BulletinEvent()
    object AvalancheProblemsClicked : BulletinEvent()
    object TravelAdviceClicked : BulletinEvent()
    object OverviewClicked : BulletinEvent()
    object SwipeToRefresh : BulletinEvent()
    object OpenBottomSheet : BulletinEvent()
    object CloseBottomSheet : BulletinEvent()
    object NavigateToBulletinProblemScreen : BulletinEvent()
    object ReturnFromBulletinProblemScreen: BulletinEvent()
}