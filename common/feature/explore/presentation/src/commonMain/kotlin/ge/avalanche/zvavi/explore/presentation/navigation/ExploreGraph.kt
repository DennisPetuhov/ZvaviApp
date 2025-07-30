package ge.avalanche.zvavi.explore.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import ge.avalanche.zvavi.explore.presentation.screen.ExploreAvalancheSizeInfoScreen
import ge.avalanche.zvavi.explore.presentation.screen.ExploreScreen
import ge.avalanche.zvavi.foundation.navigation.ExploreAvalancheSizeInfoScreenDestination
import ge.avalanche.zvavi.foundation.navigation.ExplorerScreenDestination
import ge.avalanche.zvavi.foundation.navigation.ZvaviNavDestinations
import ge.avalanche.zvavi.foundation.navigation.zvaviComposable


fun NavGraphBuilder.exploreGraph(
    navigateToDestination: (ZvaviNavDestinations, String?, (NavOptionsBuilder.() -> Unit)?) -> Unit,
) {
    zvaviComposable(destinations = ExplorerScreenDestination) {
        ExploreScreen()
    }
    zvaviComposable(destinations = ExploreAvalancheSizeInfoScreenDestination){
        ExploreAvalancheSizeInfoScreen()
    }
}