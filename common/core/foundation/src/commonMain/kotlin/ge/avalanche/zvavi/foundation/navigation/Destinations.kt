package ge.avalanche.zvavi.foundation.navigation

import androidx.navigation.NamedNavArgument


object BulletinScreenDestination : ZvaviNavDestinations, ZvaviNavAnimations by FadeAnimations {
    override val route: String = Routes.BULLETIN_SCREEN
    override val arguments: List<NamedNavArgument> = emptyList()
}

object BulletinProblemInfoScreenDestination : ZvaviNavDestinations,
    ZvaviNavAnimations by FadeAnimations {
    override val route = Routes.BULLETIN_PROBLEM_INFO_SCREEN
    override val arguments: List<NamedNavArgument>
        get() = emptyList()
}