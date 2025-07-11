package ge.avalanche.zvavi.screens.main.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import ge.avalanche.zvavi.designsystem.components.navigation.ZvaviBottomNavBar
import ge.avalanche.zvavi.designsystem.components.navigation.ZvaviNavigationBarItem
import ge.avalanche.zvavi.designsystem.icons.ZvaviIcons
import ge.avalanche.zvavi.designsystem.strings.ZvaviStrings
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import ge.avalanche.zvavi.foundation.navigation.ZvaviBottomNavBarItem
import ge.avalanche.zvavi.foundation.navigation.BulletinScreenDestination
import ge.avalanche.zvavi.foundation.navigation.ExplorerScreenDestination
import ge.avalanche.zvavi.foundation.navigation.SettingScreenDestination
import ge.avalanche.zvavi.foundation.navigation.ZvaviNavDestinations
import org.jetbrains.compose.resources.stringResource

@Composable
fun ZvaviNavigationBar(
    navigateByNavBar: (ZvaviNavDestinations) -> Unit,
    currentDestination: NavDestination?
) {
    ZvaviBottomNavBar {
        getBottomItems().forEach{  item ->
            val isSelected = currentDestination?.hierarchy?.any {
                it.route == item.destination.route
            } == true
            ZvaviNavigationBarItem(
                selected = isSelected,
                onClick = { navigateByNavBar(item.destination) },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label,
                    )
                },
                label = {
                    Text(
                        item.label,
                        style = ZvaviTheme.typography.compact200Default
                    )
                },
            )
        }
    }
}

@Composable
fun getBottomItems(): List<ZvaviBottomNavBarItem> {
    return listOf(
        ZvaviBottomNavBarItem(
            destination = BulletinScreenDestination,
            stringResource(ZvaviStrings.bulletin),
            ZvaviIcons.BulletinIcon,
            ZvaviIcons.BulletinIcon,
        ),
        ZvaviBottomNavBarItem(
            destination = ExplorerScreenDestination,
            stringResource(ZvaviStrings.explore),
            ZvaviIcons.ExploreIcon,
            ZvaviIcons.ExploreIcon,

            ),
        ZvaviBottomNavBarItem(
            SettingScreenDestination,
            stringResource(ZvaviStrings.settings),
            ZvaviIcons.SettingsIcon,
            ZvaviIcons.SettingsIcon,
        )
    )
}