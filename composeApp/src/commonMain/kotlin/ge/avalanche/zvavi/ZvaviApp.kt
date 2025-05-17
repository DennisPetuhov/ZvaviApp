package ge.avalanche.zvavi

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import ge.avalanche.zvavi.bulletin.presentation.navigation.bulletinGraph
import ge.avalanche.zvavi.foundation.navigation.BulletinScreenDestination
import ge.avalanche.zvavi.foundation.navigation.ZvaviNavHost
import ge.avalanche.zvavi.foundation.navigation.rememberZvaviNavigationController

@Composable
internal fun ZvaviApp() {
    val navController = rememberNavController()
    val zvaviNavigationController =
        rememberZvaviNavigationController(navController = navController)
    ZvaviNavHost(
        navController = navController,
        startDestination = BulletinScreenDestination
    ) {
        bulletinGraph(navigateToDestination = zvaviNavigationController::navigate)
    }
}
