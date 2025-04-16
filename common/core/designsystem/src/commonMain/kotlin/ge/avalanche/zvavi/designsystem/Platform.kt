package ge.avalanche.zvavi.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp

expect fun getPlatform(): String

@Composable
expect fun getPlatformScreenDimensions(): PlatformScreenDimensions

expect class PlatformScreenDimensions {
    val width: Dp
    val height: Dp
}
