package ge.avalanche.zvavi.bulletin.presentation.models

sealed class BulletinEvent {
    object InfoClicked : BulletinEvent()
    object RecentAvalanchesClicked : BulletinEvent()
    object SnowPackClicked : BulletinEvent()
    object WeatherClicked : BulletinEvent()
    object AvalancheProblemsClicked : BulletinEvent()
    object TravelAdviceClicked : BulletinEvent()
    object OverviewClicked : BulletinEvent()
    object SwipeToRefresh : BulletinEvent()
    object OpenBottomSheet : BulletinEvent()
    object CloseBottomSheet : BulletinEvent()
    object ProblemInfoClicked : BulletinEvent()
    object ReturnFromBulletinProblemInfoScreen: BulletinEvent()
}