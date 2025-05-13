package ge.avalanche.zvavi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.compose.rememberNavController
import ge.avalanche.zvavi.bulletin.presentation.navigation.bulletinGraph
import ge.avalanche.zvavi.foundation.navigation.BulletinScreenDestination
import ge.avalanche.zvavi.foundation.navigation.ZvaviNavHost
import ge.avalanche.zvavi.foundation.navigation.createZvaviNavigationController
import ge.avalanche.zvavi.foundation.navigation.rememberZvaviNavigationController

@Composable
internal fun ZvaviApp() {
//    BulletinScreen()
    val navController = rememberNavController()
//    val zvaviNavigationController = remember(navController) {
//        createZvaviNavigationController(navController)
//    }

    val zvaviNavigationController =
        rememberZvaviNavigationController(navController = navController)
    val focusManager = LocalFocusManager.current
//    val selectedItem = remember { mutableIntStateOf(1) }
    ZvaviNavHost(
        navController = navController,
        startDestination = remember { BulletinScreenDestination }
    ) {
        bulletinGraph(
            onBack = {
                zvaviNavigationController.popBackStack(
                    hideKeyBoard = true,
                    focusManager = focusManager
                )
            },
            navigateToDestination = zvaviNavigationController::navigate,
        )
    }
}
