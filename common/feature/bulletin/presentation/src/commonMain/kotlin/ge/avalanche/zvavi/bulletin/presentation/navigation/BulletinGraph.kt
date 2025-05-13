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
    onBack: () -> Unit,
    navigateToDestination: (ZvaviNavDestinations, String?, (NavOptionsBuilder.() -> Unit)?) -> Unit,
//    navigateByDeepLink: (Uri, (NavOptionsBuilder.() -> Unit)?) -> Unit,
) {
    zvaviComposable(destinations = BulletinScreenDestination) {
        BulletinScreen(
            onInfoProblemClicked ={ navigateToDestination(BulletinProblemInfoScreenDestination,"bulletin_problem_screen",null)}
        )
    }

    zvaviComposable(destinations = BulletinProblemInfoScreenDestination) {
        BulletinProblemInfoScreen()
    }
} 