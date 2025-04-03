package ge.avalanche.zvavi.designsystem.layout

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.designsystem.Layout

enum class WindowSize(val breakpoint: String) {
    COMPACT("mobile"),    // sm
    TABLET_PORTRAIT("tablet-portrait"),
    TABLET_LANDSCAPE("tablet-landscape"),
    DESKTOP("desktop")     // lg
}

object WindowSizeBreakpoints {
    val compactMax = Layout.breakpointMd - 1.dp
    val tabletPortraitMax = Layout.breakpointLg - 1.dp
    val tabletLandscapeMax = Layout.breakpointXl - 1.dp
}

expect class PlatformScreen {
    val width: Dp
    val height: Dp
}
