package ge.avalanche.zvavi.bulletin.presentation.models
 
sealed class BulletinAction {
    data object OpenMainScreen : BulletinAction()
    data object OpenProblems: BulletinAction()
    data object OpenRecentAvalanches: BulletinAction()
    data object OpenSnowpack: BulletinAction()
    data object OpenWeather: BulletinAction()
}