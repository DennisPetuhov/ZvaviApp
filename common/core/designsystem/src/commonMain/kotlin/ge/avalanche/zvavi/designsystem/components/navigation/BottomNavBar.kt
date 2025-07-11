package ge.avalanche.zvavi.designsystem.components.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme

@Composable
fun ZvaviBottomNavBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    NavigationBar(
        modifier = modifier,
        contentColor =ZvaviTheme.colors.layerFloorOverlay ,
        containerColor = ZvaviTheme.colors.layerFloorOverlay,
        content = content,
    )
}

@Composable
fun RowScope.ZvaviNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    alwaysShowLabel: Boolean = true,
    icon: @Composable () -> Unit,
    label: @Composable (() -> Unit)? = null,
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = icon,
        modifier = modifier,
        enabled = enabled,
        label = label,
        alwaysShowLabel = alwaysShowLabel,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = AssNavigationNarColorsDefaults.selectedIconColor(),
            unselectedIconColor = AssNavigationNarColorsDefaults.unselectedIconAndTextColor(),
            selectedTextColor = AssNavigationNarColorsDefaults.selectedItemAndTextColor(),
            unselectedTextColor = AssNavigationNarColorsDefaults.unselectedIconAndTextColor(),
            indicatorColor = AssNavigationNarColorsDefaults.selectedIndicatorColor(),

            ),
    )
}

object AssNavigationNarColorsDefaults {
    @Composable
    fun selectedIconColor() = ZvaviTheme.colors.contentBrandPrimary

    @Composable
    fun unselectedIconAndTextColor() = ZvaviTheme.colors.contentNeutralTertiary

    @Composable
    fun selectedItemAndTextColor() = ZvaviTheme.colors.contentBrandPrimary

    @Composable
    fun selectedIndicatorColor() = ZvaviTheme.colors.layerFloorOverlay
}