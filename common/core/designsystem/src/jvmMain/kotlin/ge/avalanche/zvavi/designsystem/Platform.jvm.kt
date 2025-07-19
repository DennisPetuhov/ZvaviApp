package ge.avalanche.zvavi.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

actual fun getPlatform(): String {
    return "Desktop"
}

actual class PlatformScreenDimensions(
    actual val width: Dp,
    actual val height: Dp
)

@OptIn(ExperimentalComposeUiApi::class)
@Composable
actual fun getPlatformScreenDimensions(): PlatformScreenDimensions {
    val containerSize = LocalWindowInfo.current.containerSize
    val density = LocalDensity.current.density
    val widthDp = (containerSize.width / density).dp
    val heightDp = (containerSize.height / density).dp

    return PlatformScreenDimensions(
        width = widthDp,
        height = heightDp
    )
}
