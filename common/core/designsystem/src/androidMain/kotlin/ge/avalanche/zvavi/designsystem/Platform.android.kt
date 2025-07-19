package ge.avalanche.zvavi.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

actual fun getPlatform(): String {
    return "ANDROID"
}

actual class PlatformScreenDimensions(
    actual val width: Dp,
    actual val height: Dp
)

@Composable
actual fun getPlatformScreenDimensions(): PlatformScreenDimensions {
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current.density
    
    // Get screen dimensions in dp
    val widthDp = configuration.screenWidthDp.dp
    val heightDp = configuration.screenHeightDp.dp
    
    // Calculate raw pixel values for logging
    val rawWidthPx = (widthDp.value * density).toInt()
    val rawHeightPx = (heightDp.value * density).toInt()
    
    println("**** Android raw width: ${rawWidthPx}px, density: $density, widthDp: $widthDp")
    println("**** Android raw height: ${rawHeightPx}px, density: $density, heightDp: $heightDp")

    
    return PlatformScreenDimensions(
        width = widthDp,
        height = heightDp
    )
}