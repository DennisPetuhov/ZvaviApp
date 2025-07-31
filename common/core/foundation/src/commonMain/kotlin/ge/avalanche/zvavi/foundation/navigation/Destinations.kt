package ge.avalanche.zvavi.foundation.navigation

import androidx.navigation.NamedNavArgument

object SplashScreenDestination : ZvaviNavDestinations, ZvaviNavAnimations by FadeAnimations {
    override val route: String = ZvaviRoutes.SPLASH_SCREEN
    override val arguments: List<NamedNavArgument> = emptyList()
}

object MainScreenDestination : ZvaviNavDestinations, ZvaviNavAnimations by FadeAnimations {
    override val route: String = ZvaviRoutes.MAIN_SCREEN
    override val arguments: List<NamedNavArgument> = emptyList()
}

object BulletinScreenDestination : ZvaviNavDestinations, ZvaviNavAnimations by FadeAnimations {
    override val route: String = ZvaviRoutes.BULLETIN_SCREEN
    override val arguments: List<NamedNavArgument> = emptyList()
}

object BulletinProblemInfoScreenDestination : ZvaviNavDestinations,
    ZvaviNavAnimations by FadeAnimations {
    override val route = ZvaviRoutes.BULLETIN_PROBLEM_INFO_SCREEN
    override val arguments: List<NamedNavArgument>
        get() = emptyList()
}
object ExplorerScreenDestination : ZvaviNavDestinations, ZvaviNavAnimations by FadeAnimations {
    override val route: String = ZvaviRoutes.EXPLORER_SCREEN
    override val arguments: List<NamedNavArgument> = emptyList()
}
object SettingScreenDestination : ZvaviNavDestinations, ZvaviNavAnimations by FadeAnimations {
    override val route: String = ZvaviRoutes.SETTING_SCREEN
    override val arguments: List<NamedNavArgument> = emptyList()
}

object ExploreAvalancheSizeInfoScreenDestination : ZvaviNavDestinations,
    ZvaviNavAnimations by FadeAnimations {
    override val route = ZvaviRoutes.EXPLORER_AVALANCHE_SIZE_INFO_SCREEN
    override val arguments: List<NamedNavArgument>
        get() = emptyList()
}