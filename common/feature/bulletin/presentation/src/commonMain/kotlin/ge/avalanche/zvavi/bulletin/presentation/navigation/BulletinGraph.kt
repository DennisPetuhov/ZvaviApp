package ge.avalanche.zvavi.bulletin.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import ge.avalanche.zvavi.bulletin.presentation.screen.BulletinProblemInfoScreen
import ge.avalanche.zvavi.bulletin.presentation.screen.BulletinScreen
import ge.avalanche.zvavi.foundation.navigation.BulletinProblemInfoScreenDestination
import ge.avalanche.zvavi.foundation.navigation.BulletinScreenDestination
import ge.avalanche.zvavi.foundation.navigation.ExploreAvalancheSizeInfoScreenDestination
import ge.avalanche.zvavi.foundation.navigation.ExplorerScreenDestination
import ge.avalanche.zvavi.foundation.navigation.ZvaviNavDestinations
import ge.avalanche.zvavi.foundation.navigation.zvaviComposable

fun NavGraphBuilder.bulletinGraph(
    navigateToDestination: (ZvaviNavDestinations, String?, (NavOptionsBuilder.() -> Unit)?) -> Unit,
) {
    zvaviComposable(destinations = BulletinScreenDestination) {
        BulletinScreen(onNavigate = { destination ->
            navigateToDestination(destination, route) {}
        })
    }
    zvaviComposable(destinations = BulletinProblemInfoScreenDestination) {
        BulletinProblemInfoScreen()
    }
}