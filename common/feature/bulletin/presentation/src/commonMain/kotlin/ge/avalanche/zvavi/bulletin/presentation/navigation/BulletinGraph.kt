package ge.avalanche.zvavi.bulletin.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import ge.avalanche.zvavi.bulletin.presentation.screen.BulletinProblemInfoScreen
import ge.avalanche.zvavi.bulletin.presentation.screen.BulletinScreen
import ge.avalanche.zvavi.foundation.navigation.BulletinProblemInfoScreenDestination
import ge.avalanche.zvavi.foundation.navigation.BulletinScreenDestination
import ge.avalanche.zvavi.foundation.navigation.ZvaviNavDestinations
import ge.avalanche.zvavi.foundation.navigation.zvaviComposable

@Suppress("UNUSED_PARAMETER")
fun NavGraphBuilder.bulletinGraph(
    navigateToDestination: (ZvaviNavDestinations, String?, (NavOptionsBuilder.() -> Unit)?) -> Unit,
) {
    zvaviComposable(destinations = BulletinScreenDestination) {
        BulletinScreen(onNavigate = {
            navigateToDestination(BulletinProblemInfoScreenDestination, route) {}
        })
    }

    zvaviComposable(destinations = BulletinProblemInfoScreenDestination) {
        BulletinProblemInfoScreen()
    }
}