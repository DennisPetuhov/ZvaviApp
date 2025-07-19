package ge.avalanche.zvavi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import ge.avalanche.zvavi.foundation.navigation.SplashScreenDestination
import ge.avalanche.zvavi.foundation.navigation.ZvaviNavHost
import ge.avalanche.zvavi.foundation.navigation.rememberZvaviNavigationController
import ge.avalanche.zvavi.screens.main.navigation.mainGraph
import ge.avalanche.zvavi.splash.presentation.navigation.splashGraph

@Composable
internal fun ZvaviApp() {
    val navController = rememberNavController()
    val zvaviNavigationController =
        rememberZvaviNavigationController(navController = navController)
    ZvaviNavHost(
        navController = navController,
        startDestination = SplashScreenDestination,
        modifier = Modifier
    ) {
        splashGraph(navigateToDestination = zvaviNavigationController::navigate)
        mainGraph(navigateToDestination = zvaviNavigationController::navigate)
    }
}
