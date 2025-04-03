package ge.avalanche.zvavi.designsystem.layout

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp

@Immutable
data class LayoutConfig(
    val breakpoint: String,
    val minWidth: Dp,
    val maxWidth: Dp,
    val width: Dp,
    val height: Dp,
    val colNumber: Int,
    val colWidth: Dp,
    val gutter: Dp,
    val marginHorizontal: Dp,
    val contentCompensation: Dp,
    val ignoreMarginHorizontal: Dp
)

// Create CompositionLocal for the layout configuration
val LocalLayoutConfig = staticCompositionLocalOf<LayoutConfig> {
    error("No LayoutConfig provided")
}

// Create CompositionLocal for window size
val LocalWindowSize = compositionLocalOf<WindowSize> {
    error("No WindowSize provided")
}
