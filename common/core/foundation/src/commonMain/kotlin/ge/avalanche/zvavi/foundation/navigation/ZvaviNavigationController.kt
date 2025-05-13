package ge.avalanche.zvavi.foundation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.focus.FocusManager
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder

expect @Composable
fun rememberZvaviNavigationController(
    navController: NavHostController,
): ZvaviNavigationController


expect fun createZvaviNavigationController(navController: NavHostController): ZvaviNavigationController


expect class ZvaviNavigationController(navController: NavHostController) {
    fun navigate(
        destinations: ZvaviNavDestinations?,
        route: String? = null,
        navOptionsBuilder: (NavOptionsBuilder.() -> Unit)? = null,
    )
    // make deeplink for KMM
//    fun navigate(deepLink: Uri, navOptionsBuilder: (NavOptionsBuilder.() -> Unit)? = null) {

//    }

    fun hideKeyBoardAnd(
        focusManager: FocusManager,
        after: (() -> Unit)?,
    )
    fun popBackStack(
        hideKeyBoard: Boolean,
        focusManager: FocusManager,
        route: String? = null,
    )

    fun navigateBack(route: String?)
}