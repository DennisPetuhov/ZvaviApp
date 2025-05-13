package ge.avalanche.zvavi.foundation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun ZvaviNavHost(
    navController: NavHostController,
    startDestination: ZvaviNavDestinations,
    animations: ZvaviNavAnimations = SlidingAnimations,
    builder: NavGraphBuilder.() -> Unit,
) {
    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = startDestination.route,
        enterTransition = animations.enterTransition,
        exitTransition = animations.exitTransition,
        popEnterTransition = animations.popEnterTransition,
        popExitTransition = animations.popExitTransition,
        builder = builder
    )
}