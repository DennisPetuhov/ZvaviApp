package ge.avalanche.zvavi.designsystem.tokens.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.designsystem.getPlatform
import ge.avalanche.zvavi.designsystem.getPlatformScreenDimensions
import ge.avalanche.zvavi.designsystem.tokens.zvaviLayout.SIZE_LG
import ge.avalanche.zvavi.designsystem.tokens.zvaviLayout.SIZE_MD
import ge.avalanche.zvavi.designsystem.tokens.zvaviLayout.SIZE_SM
import ge.avalanche.zvavi.designsystem.tokens.zvaviLayout.SIZE_XL
import ge.avalanche.zvavi.designsystem.tokens.zvaviLayout.SIZE_XXL

/**
 * Represents different window size classes for responsive design.
 *
 * These breakpoints are based on common device sizes:
 * - SMALL: Small phones (~320dp width)
 * - MEDIUM: Medium phones (~360-480dp width)
 * - TABLET_PORTRAIT: Tablets in portrait (~600dp width)
 * - TABLET_LANDSCAPE: Tablets in landscape (~960dp width)
 * - DESKTOP: Desktop and large screens (1200dp+)
 */
enum class WindowSize(val breakpoint: Dp) {
    /**
     * Small phones (~320dp width)
     */
    SMALL(320.dp),

    /**
     * Medium phones (~360-480dp width)
     */
    MEDIUM(360.dp),

    /**
     * Tablets in portrait (~600dp width)
     */

    TABLET_PORTRAIT(800.dp),
//    TABLET_PORTRAIT(600.dp),

    /**
     * Tablets in landscape (~960dp width)
     */
    TABLET_LANDSCAPE(1280.dp),
//    TABLET_LANDSCAPE(960.dp),

    /**
     * Desktop and large screens (1200dp+)
     */
    DESKTOP(1600.dp)
}

/**
 * Determines the current window size based on screen width and orientation.
 *
 * This function uses device-appropriate breakpoints to determine the appropriate
 * window size class for the current device.
 */
@Composable
fun rememberWindowSize(): WindowSize {
    val screenWidth = getPlatformScreenDimensions().width
    val screenHeight = getPlatformScreenDimensions().height
    val isLandscape = screenWidth > screenHeight
    val platform = getPlatform()

    println("**** screenWidth: $screenWidth, screenHeight: $screenHeight, isLandscape: $isLandscape, platform: $platform")

    return remember(screenWidth, screenHeight, isLandscape, platform) {
        when (platform) {
            "Desktop", "Web" -> {
                // For web and desktop, use screen width to determine size
                if (screenWidth >= WindowSize.DESKTOP.breakpoint) {
                    WindowSize.DESKTOP
                } else {
                    WindowSize.MEDIUM // For smaller desktop/web screens, use MEDIUM
                }
            }
            "ANDROID", "iOS" -> {
                // For mobile platforms, check if it's a tablet or phone
                if (screenWidth >= WindowSize.TABLET_PORTRAIT.breakpoint) {
                    // It's a tablet, now determine orientation
                    if (isLandscape) {
                        WindowSize.TABLET_LANDSCAPE
                    } else {
                        WindowSize.TABLET_PORTRAIT
                    }
                } else {
                    // It's a phone, determine size
                    if (screenWidth < WindowSize.MEDIUM.breakpoint) {
                        WindowSize.SMALL
                    } else {
                        WindowSize.MEDIUM
                    }
                }
            }
            else -> {
                // Default case for unknown platforms
                if (screenWidth >= WindowSize.DESKTOP.breakpoint) {
                    WindowSize.DESKTOP
                } else if (screenWidth >= WindowSize.TABLET_PORTRAIT.breakpoint) {
                    if (isLandscape) {
                        WindowSize.TABLET_LANDSCAPE
                    } else {
                        WindowSize.TABLET_PORTRAIT
                    }
                } else if (screenWidth < WindowSize.MEDIUM.breakpoint) {
                    WindowSize.SMALL
                } else {
                    WindowSize.MEDIUM
                }
            }
        }
    }
}

/**
 * Returns the current screen size as a string constant.
 *
 * This function maps the WindowSize enum to the corresponding size constant
 * used in the design system.
 */
@Composable
fun getCurrentScreenSize(): String {
    val windowSize = rememberWindowSize()
    println(
        "**** AFTER breakpoint: ${rememberWindowSize().breakpoint}, tablet or landscape ${windowSize.name}, windowsizebreakpoint" +
                " ${windowSize.breakpoint}, getPlatformScreenDimensions.width ${getPlatformScreenDimensions().width}," +
                "getPlatformScreenDimensions.height ${getPlatformScreenDimensions().height}"
    )
    return when (windowSize) {
        WindowSize.SMALL -> SIZE_SM
        WindowSize.MEDIUM -> SIZE_MD
        WindowSize.TABLET_PORTRAIT -> SIZE_LG
        WindowSize.TABLET_LANDSCAPE -> SIZE_XL
        WindowSize.DESKTOP -> SIZE_XXL
    }
}