package ge.avalanche.zvavi.splash.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import ge.avalanche.zvavi.foundation.navigation.SplashScreenDestination
import ge.avalanche.zvavi.foundation.navigation.ZvaviNavDestinations
import ge.avalanche.zvavi.foundation.navigation.zvaviComposable
import ge.avalanche.zvavi.splash.presentation.SplashScreen

fun NavGraphBuilder.splashGraph(
    navigateToDestination: (ZvaviNavDestinations, String?, (NavOptionsBuilder.() -> Unit)?) -> Unit
) {
    zvaviComposable(destinations = SplashScreenDestination) {
        SplashScreen(
            onNavigateToMain = {
                navigateToDestination(
                    ge.avalanche.zvavi.foundation.navigation.MainScreenDestination,
                    null
                ) {
                    popUpTo(SplashScreenDestination.route) {
                        inclusive = true
                    }
                }
            }
        )
    }
} 