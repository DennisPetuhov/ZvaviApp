package ge.avalanche.zvavi.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

actual fun getPlatform(): String {
    return "Android"
}

actual class PlatformScreenDimensions(
    actual val width: Dp,
    actual val height: Dp
)

@Composable
actual fun getPlatformScreenDimensions(): PlatformScreenDimensions {
    val configuration = LocalConfiguration.current
    return PlatformScreenDimensions(
        width = configuration.screenWidthDp.dp,
        height = configuration.screenHeightDp.dp
    )
}