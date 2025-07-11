package ge.avalanche.zvavi.screens.main

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import ge.avalanche.zvavi.bulletin.presentation.navigation.bulletinGraph
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import ge.avalanche.zvavi.explore.presentation.navigation.exploreGraph
import ge.avalanche.zvavi.foundation.navigation.BulletinScreenDestination
import ge.avalanche.zvavi.foundation.navigation.ZvaviNavHost
import ge.avalanche.zvavi.foundation.navigation.rememberZvaviNavigationController
import ge.avalanche.zvavi.screens.main.navigation.ZvaviNavigationBar
import ge.avalanche.zvavi.settings.presentation.navigation.settingsGraph

@Composable
internal fun ZvaviMainScreen() {
    val mainNavController = rememberNavController()
    val mainZvaviNavController =
        rememberZvaviNavigationController(navController = mainNavController)
    val selectedItem = mutableIntStateOf(0)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets.systemBars, // Handle insets here
        containerColor = ZvaviTheme.colors.layerFloor0,
        bottomBar = {
            ZvaviNavigationBar(
                navigateByNavBar = { destination ->
                    mainZvaviNavController.navigate(destination) {
                        popUpTo(mainNavController.graph.findStartDestination().route!!) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                currentDestination = mainZvaviNavController.currentDestination
            )
        }
    ) { innerPadding ->
        ZvaviNavHost(
            navController = mainNavController,
            startDestination = BulletinScreenDestination,
            modifier = Modifier.padding(innerPadding)
        ) {
            bulletinGraph(navigateToDestination = mainZvaviNavController::navigate)
            exploreGraph(navigateToDestination = mainZvaviNavController::navigate)
            settingsGraph(navigateToDestination = mainZvaviNavController::navigate)
        }
    }
}