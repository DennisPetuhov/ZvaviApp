package ge.avalanche.zvavi.foundation.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class ZvaviBottomNavBarItem(
    val destination: ZvaviNavDestinations,
    val label: String,
    val selectedIcon: ImageVector,
    val icon: ImageVector
)