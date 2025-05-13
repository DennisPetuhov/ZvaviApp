package ge.avalanche.zvavi.foundation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.focus.FocusManager
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.currentBackStackEntryAsState
import co.touchlab.kermit.Logger

//// common/core/foundation/src/commonMain/kotlin/ge/avalanche/zvavi/foundation/navigation/ZvaviNavigationController.kt
//package ge.avalanche.zvavi.foundation.navigation
//
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavHostController
//
//expect class ZvaviNavigationController(navController: NavHostController) {
//    val currentDestinations: NavDestination?
//    fun navigate(
//        destinations: ZvaviNavDestinations?,
//        route: String? = null,
//        navOptionsBuilder: (NavOptionsBuilder.() -> Unit)? = null,
//    )
//    fun popBackStack(
//        hideKeyBoard: Boolean,
//        focusManager: FocusManager,
//        route: String? = null,
//    )
//}

expect @Composable
fun rememberZvaviNavigationController(
    navController: NavHostController,
): ZvaviNavigationController


expect fun createZvaviNavigationController(navController: NavHostController): ZvaviNavigationController


expect class ZvaviNavigationController(  navController: NavHostController) {


//    val currentDestinations: NavDestination?
//        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

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