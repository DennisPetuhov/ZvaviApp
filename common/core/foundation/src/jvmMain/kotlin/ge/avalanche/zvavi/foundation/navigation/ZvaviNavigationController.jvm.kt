package ge.avalanche.zvavi.foundation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.focus.FocusManager
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import co.touchlab.kermit.Logger
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
actual fun rememberZvaviNavigationController(
    navController: NavHostController,
): ZvaviNavigationController {
    return remember(navController) { ZvaviNavigationController(navController) }
}
actual fun createZvaviNavigationController(navController: NavHostController): ZvaviNavigationController {
    return ZvaviNavigationController(navController)}

actual class ZvaviNavigationController actual constructor(private val navController: NavHostController) {
    private val logger = Logger.withTag("Routing")

  actual  val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    actual fun navigate(
        destinations: ZvaviNavDestinations?,
        route: String? ,
        navOptionsBuilder: (NavOptionsBuilder.() -> Unit)?,
    ) {
        logger.d { "routes ${destinations?.route} $route" }
        navController.navigate(route ?: destinations?.route ?: ZvaviRoutes.BULLETIN_SCREEN) {
            navOptionsBuilder?.invoke(this)
        }
    }
    // make deeplink for KMM
//    fun navigate(deepLink: Uri, navOptionsBuilder: (NavOptionsBuilder.() -> Unit)? = null) {
//        val builder: NavOptionsBuilder.() -> Unit = {
//            launchSingleTop = false
//            navOptionsBuilder?.invoke(this)
//        }
//        try {
//            navController.navigate(deepLink, navOptions(builder))
//        } catch (e: Exception) {
//            logger.e(e) { "Navigation failed" }
//        }
//    }

    actual  fun hideKeyBoardAnd(
        focusManager: FocusManager,
        after: (() -> Unit)?,
    ) {
        focusManager.clearFocus()
        after?.invoke()
    }

    actual fun popBackStack(
        hideKeyBoard: Boolean,
        focusManager: FocusManager,
        route: String?,
    ) {
        if (navController.previousBackStackEntry == null) {
            return
        }
        if (hideKeyBoard) {
            hideKeyBoardAnd(focusManager = focusManager) {
                navigateBack(route)
            }
        } else {
            navigateBack(route)
        }
    }

    actual fun navigateBack(route: String?) {
        if (route != null) {
            navController.popBackStack(route = route, inclusive = true)
        } else {
            navController.popBackStack()
        }
    }
}