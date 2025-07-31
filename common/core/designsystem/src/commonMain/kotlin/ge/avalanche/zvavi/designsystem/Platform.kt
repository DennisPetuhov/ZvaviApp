package ge.avalanche.zvavi.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp

expect fun getPlatform(): String

@Composable
expect fun getPlatformScreenDimensions(): PlatformScreenDimensions

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class PlatformScreenDimensions {
    val width: Dp
    val height: Dp
}
