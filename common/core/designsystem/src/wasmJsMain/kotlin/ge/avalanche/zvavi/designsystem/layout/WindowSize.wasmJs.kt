package ge.avalanche.zvavi.designsystem.layout

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp



actual class PlatformScreen(
    actual val width: Dp,
    actual val height: Dp
)
@OptIn(ExperimentalComposeUiApi::class)
@Composable
actual fun GetPlatformScreen(): PlatformScreen {
    val containerSize = LocalWindowInfo.current.containerSize
    return PlatformScreen(
        width = (containerSize.width).toFloat().dp,
        height = (containerSize.height).toFloat().dp
    )
}
