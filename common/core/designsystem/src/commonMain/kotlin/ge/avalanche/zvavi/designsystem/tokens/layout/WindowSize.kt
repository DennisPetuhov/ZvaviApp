package ge.avalanche.zvavi.designsystem.tokens.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.designsystem.getPlatformScreenDimensions
import ge.avalanche.zvavi.designsystem.tokens.zvaviLayout.SIZE_LG
import ge.avalanche.zvavi.designsystem.tokens.zvaviLayout.SIZE_MD
import ge.avalanche.zvavi.designsystem.tokens.zvaviLayout.SIZE_SM
import ge.avalanche.zvavi.designsystem.tokens.zvaviLayout.SIZE_XL

enum class WindowSize(val breakpoint: Dp) {
    COMPACT(0.dp),
    TABLET_PORTRAIT(600.dp),
    TABLET_LANDSCAPE(840.dp),
    DESKTOP(1200.dp)
}

@Composable
fun rememberWindowSize(): WindowSize {
    val screenWidth = getPlatformScreenDimensions().width
    return remember(screenWidth) {
        when {
            screenWidth < WindowSize.TABLET_PORTRAIT.breakpoint -> WindowSize.COMPACT
            screenWidth < WindowSize.TABLET_LANDSCAPE.breakpoint -> WindowSize.TABLET_PORTRAIT
            screenWidth < WindowSize.DESKTOP.breakpoint -> WindowSize.TABLET_LANDSCAPE
            else -> WindowSize.DESKTOP
        }
    }
}

@Composable
fun getCurrentScreenSize(): String {
    val windowSize = rememberWindowSize()
    return when (windowSize) {
        WindowSize.COMPACT -> SIZE_SM
        WindowSize.TABLET_PORTRAIT -> SIZE_MD
        WindowSize.TABLET_LANDSCAPE -> SIZE_LG
        WindowSize.DESKTOP -> SIZE_XL
    }
}