package ge.avalanche.zvavi.bulletin.presentation.models

sealed class BulletinEvent {
    class EmailChanged(val newValue: String) : BulletinEvent()
    class PasswordChanged(val newValue: String) : BulletinEvent()
    data object RecentAvalanchesClicked : BulletinEvent()
    data object SnowPackClicked : BulletinEvent()
    data object WeatherClicked : BulletinEvent()
    data object BulletinClicked : BulletinEvent()
    data object TravelAdviceClicked : BulletinEvent()
    data object OverviewClicked : BulletinEvent()
}