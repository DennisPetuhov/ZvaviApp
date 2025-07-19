package ge.avalanche.zvavi.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.platform.LocalDensity
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
    val density = LocalDensity.current.density
    
    // Convert raw pixels to density-independent pixels (dp)
    // We need to divide by the actual density to get dp values
    val widthDp = (containerSize.width / density).dp
    val heightDp = (containerSize.height / density).dp
    
    println("iOS raw width: ${containerSize.width}, density: $density, widthDp: $widthDp")
    
    return PlatformScreenDimensions(
        width = widthDp,
        height = heightDp
    )
}



