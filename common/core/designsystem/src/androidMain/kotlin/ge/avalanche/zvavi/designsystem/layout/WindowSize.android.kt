package ge.avalanche.zvavi.designsystem.layout

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

actual class PlatformScreen(
    actual val width: Dp,
    actual val height: Dp
)

@Composable
actual fun GetPlatformScreen(): PlatformScreen {
    val configuration = LocalConfiguration.current
    return PlatformScreen(
        width = configuration.screenWidthDp.dp,
        height = configuration.screenHeightDp.dp
    )
}