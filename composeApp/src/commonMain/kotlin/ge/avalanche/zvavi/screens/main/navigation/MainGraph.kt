package ge.avalanche.zvavi.screens.main.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import ge.avalanche.zvavi.foundation.navigation.MainScreenDestination
import ge.avalanche.zvavi.foundation.navigation.ZvaviNavDestinations
import ge.avalanche.zvavi.foundation.navigation.zvaviComposable
import ge.avalanche.zvavi.screens.main.ZvaviMainScreen

fun NavGraphBuilder.mainGraph(
    navigateToDestination: (ZvaviNavDestinations, String?, (NavOptionsBuilder.() -> Unit)?) -> Unit
) {
    zvaviComposable(destinations = MainScreenDestination) {
        ZvaviMainScreen()
    }
} 