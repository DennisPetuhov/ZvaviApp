package ge.avalanche.zvavi.foundation.navigation

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


fun NavGraphBuilder.zvaviComposable(
    destinations: ZvaviNavDestinations,
    arguments: List<NamedNavArgument> = destinations.arguments,
    deepLinks: List<NavDeepLink> = destinations.getDeepLinks(),
    content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit,
) {

    composable(
        route = destinations.route,
        arguments = arguments,
        deepLinks = deepLinks,
        enterTransition = destinations.enterTransition,
        exitTransition = destinations.exitTransition,
        popEnterTransition = destinations.popEnterTransition,
        popExitTransition = destinations.popExitTransition,
        content = content,
    )
} 