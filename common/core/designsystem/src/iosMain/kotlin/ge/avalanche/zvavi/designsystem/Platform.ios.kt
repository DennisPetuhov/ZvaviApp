package ge.avalanche.zvavi.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


 actual fun getPlatform():String{
    return "iOS"}

actual class PlatformScreenDimensions(
    actual val width: Dp,
    actual val height: Dp
)

@OptIn(ExperimentalComposeUiApi::class)
@Composable
actual fun getPlatformScreenDimensions(): PlatformScreenDimensions {
    val containerSize = LocalWindowInfo.current.containerSize
    return PlatformScreenDimensions(
        width = (containerSize.width).toFloat().dp,
        height = (containerSize.height).toFloat().dp
    )
}



