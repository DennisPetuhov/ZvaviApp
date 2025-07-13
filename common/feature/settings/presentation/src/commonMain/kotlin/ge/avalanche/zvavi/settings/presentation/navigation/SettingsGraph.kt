package ge.avalanche.zvavi.settings.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import ge.avalanche.zvavi.foundation.navigation.SettingScreenDestination
import ge.avalanche.zvavi.foundation.navigation.ZvaviNavDestinations
import ge.avalanche.zvavi.foundation.navigation.zvaviComposable
import ge.avalanche.zvavi.settings.presentation.screen.SettingsScreen

fun NavGraphBuilder.settingsGraph(
    navigateToDestination: (ZvaviNavDestinations, String?, (NavOptionsBuilder.() -> Unit)?) -> Unit,
) {
    zvaviComposable(destinations = SettingScreenDestination) {
        SettingsScreen()
    }
}