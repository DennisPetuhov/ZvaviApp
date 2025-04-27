package ge.avalanche.zvavi.bulletin.presentation.models

import ge.avalanche.zvavi.designsystem.boards.ZvaviDashboardEvent

sealed class BulletinEvent {
    object InfoClicked : BulletinEvent(), ZvaviDashboardEvent
    object RecentAvalanchesClicked : BulletinEvent()
    object SnowPackClicked : BulletinEvent()
    object WeatherClicked : BulletinEvent()
    object AvalancheProblemsClicked : BulletinEvent()
    object TravelAdviceClicked : BulletinEvent()
    object OverviewClicked : BulletinEvent()
    object SwipeToRefresh : BulletinEvent()
}