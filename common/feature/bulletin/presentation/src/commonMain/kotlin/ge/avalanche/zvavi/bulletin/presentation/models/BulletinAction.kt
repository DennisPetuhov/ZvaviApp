package ge.avalanche.zvavi.bulletin.presentation.models

sealed class BulletinAction {
    data object OpenProblem : BulletinAction()
    data object OpenRecentAvalanches : BulletinAction()
    data object OpenSnowpack : BulletinAction()
    data object OpenWeather : BulletinAction()
}