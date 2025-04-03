package ge.avalanche.zvavi.designsystem.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import ge.avalanche.zvavi.designsystem.ZvaviLayout
import ge.avalanche.zvavi.designsystem.getPlatform
import ge.avalanche.zvavi.designsystem.product.ProductType


@Composable
expect fun GetPlatformScreen(): PlatformScreen

@Composable
fun rememberWindowSize(): WindowSize {
    val screen = GetPlatformScreen()
    val width = screen.width

    return remember(width) {
        mutableStateOf(
            when {
                width <= WindowSizeBreakpoints.compactMax -> WindowSize.COMPACT
                width <= WindowSizeBreakpoints.tabletPortraitMax -> WindowSize.TABLET_PORTRAIT
                width <= WindowSizeBreakpoints.tabletLandscapeMax -> WindowSize.TABLET_LANDSCAPE
                else -> WindowSize.DESKTOP
            }
        )
    }.value
}

@Composable
fun ProvideLayoutConfig(
    productType: ProductType = ProductType.App,
    content: @Composable () -> Unit
) {
    val windowSize = rememberWindowSize()
    val currentPlatform = getPlatform()
    
    val layoutConfig = when (windowSize) {
        WindowSize.COMPACT -> when (productType) {
            is ProductType.App -> LayoutConfig(
                breakpoint = WindowSize.COMPACT.breakpoint,
                minWidth = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.minWidth
                    "iOS" -> ZvaviLayout.ZvaviApple.minWidth
                    else -> ZvaviLayout.ZvaviMobile.minWidth
                },
                maxWidth = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.maxWidth
                    "iOS" -> ZvaviLayout.ZvaviApple.maxWidth
                    else -> ZvaviLayout.ZvaviMobile.maxWidth
                },
                width = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.width
                    "iOS" -> ZvaviLayout.ZvaviApple.width
                    else -> ZvaviLayout.ZvaviMobile.width
                },
                height = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.height
                    "iOS" -> ZvaviLayout.ZvaviApple.height
                    else -> ZvaviLayout.ZvaviMobile.height
                },
                colNumber = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.colNumber
                    "iOS" -> ZvaviLayout.ZvaviApple.colNumber
                    else -> ZvaviLayout.ZvaviMobile.colNumber
                },
                colWidth = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.colWidth
                    "iOS" -> ZvaviLayout.ZvaviApple.colWidth
                    else -> ZvaviLayout.ZvaviMobile.colWidth
                },
                gutter = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.gutter
                    "iOS" -> ZvaviLayout.ZvaviApple.gutter
                    else -> ZvaviLayout.ZvaviMobile.gutter
                },
                marginHorizontal = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.marginHorizontal
                    "iOS" -> ZvaviLayout.ZvaviApple.marginHorizontal
                    else -> ZvaviLayout.ZvaviMobile.marginHorizontal
                },
                contentCompensation = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.contentCompensation
                    "iOS" -> ZvaviLayout.ZvaviApple.contentCompensation
                    else -> ZvaviLayout.ZvaviMobile.contentCompensation
                },
                ignoreMarginHorizontal = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.ignoreMarginHorizontal
                    "iOS" -> ZvaviLayout.ZvaviApple.ignoreMarginHorizontal
                    else -> ZvaviLayout.ZvaviMobile.ignoreMarginHorizontal
                }
            )
            is ProductType.Extensions -> LayoutConfig(
                breakpoint = WindowSize.COMPACT.breakpoint,
                minWidth = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.minWidth
                    "iOS" -> ZvaviLayout.ZvaviApple.minWidth
                    else -> ZvaviLayout.ZvaviMobile.minWidth
                },
                maxWidth = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.maxWidth
                    "iOS" -> ZvaviLayout.ZvaviApple.maxWidth
                    else -> ZvaviLayout.ZvaviMobile.maxWidth
                },
                width = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.width
                    "iOS" -> ZvaviLayout.ZvaviApple.width
                    else -> ZvaviLayout.ZvaviMobile.width
                },
                height = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.height
                    "iOS" -> ZvaviLayout.ZvaviApple.height
                    else -> ZvaviLayout.ZvaviMobile.height
                },
                colNumber = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.colNumber
                    "iOS" -> ZvaviLayout.ZvaviApple.colNumber
                    else -> ZvaviLayout.ZvaviMobile.colNumber
                },
                colWidth = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.colWidth
                    "iOS" -> ZvaviLayout.ZvaviApple.colWidth
                    else -> ZvaviLayout.ZvaviMobile.colWidth
                },
                gutter = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.gutter
                    "iOS" -> ZvaviLayout.ZvaviApple.gutter
                    else -> ZvaviLayout.ZvaviMobile.gutter
                },
                marginHorizontal = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.marginHorizontal
                    "iOS" -> ZvaviLayout.ZvaviApple.marginHorizontal
                    else -> ZvaviLayout.ZvaviMobile.marginHorizontal
                },
                contentCompensation = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.contentCompensation
                    "iOS" -> ZvaviLayout.ZvaviApple.contentCompensation
                    else -> ZvaviLayout.ZvaviMobile.contentCompensation
                },
                ignoreMarginHorizontal = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.ignoreMarginHorizontal
                    "iOS" -> ZvaviLayout.ZvaviApple.ignoreMarginHorizontal
                    else -> ZvaviLayout.ZvaviMobile.ignoreMarginHorizontal
                }
            )
            is ProductType.MiniApp -> LayoutConfig(
                breakpoint = WindowSize.COMPACT.breakpoint,
                minWidth = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.minWidth
                    "iOS" -> ZvaviLayout.ZvaviApple.minWidth
                    else -> ZvaviLayout.ZvaviMobile.minWidth
                },
                maxWidth = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.maxWidth
                    "iOS" -> ZvaviLayout.ZvaviApple.maxWidth
                    else -> ZvaviLayout.ZvaviMobile.maxWidth
                },
                width = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.width
                    "iOS" -> ZvaviLayout.ZvaviApple.width
                    else -> ZvaviLayout.ZvaviMobile.width
                },
                height = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.height
                    "iOS" -> ZvaviLayout.ZvaviApple.height
                    else -> ZvaviLayout.ZvaviMobile.height
                },
                colNumber = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.colNumber
                    "iOS" -> ZvaviLayout.ZvaviApple.colNumber
                    else -> ZvaviLayout.ZvaviMobile.colNumber
                },
                colWidth = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.colWidth
                    "iOS" -> ZvaviLayout.ZvaviApple.colWidth
                    else -> ZvaviLayout.ZvaviMobile.colWidth
                },
                gutter = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.gutter
                    "iOS" -> ZvaviLayout.ZvaviApple.gutter
                    else -> ZvaviLayout.ZvaviMobile.gutter
                },
                marginHorizontal = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.marginHorizontal
                    "iOS" -> ZvaviLayout.ZvaviApple.marginHorizontal
                    else -> ZvaviLayout.ZvaviMobile.marginHorizontal
                },
                contentCompensation = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.contentCompensation
                    "iOS" -> ZvaviLayout.ZvaviApple.contentCompensation
                    else -> ZvaviLayout.ZvaviMobile.contentCompensation
                },
                ignoreMarginHorizontal = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.ignoreMarginHorizontal
                    "iOS" -> ZvaviLayout.ZvaviApple.ignoreMarginHorizontal
                    else -> ZvaviLayout.ZvaviMobile.ignoreMarginHorizontal
                }
            )
            is ProductType.Website -> LayoutConfig(
                breakpoint = WindowSize.COMPACT.breakpoint,
                minWidth = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.minWidth
                    "iOS" -> ZvaviLayout.ZvaviApple.minWidth
                    else -> ZvaviLayout.ZvaviMobile.minWidth
                },
                maxWidth = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.maxWidth
                    "iOS" -> ZvaviLayout.ZvaviApple.maxWidth
                    else -> ZvaviLayout.ZvaviMobile.maxWidth
                },
                width = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.width
                    "iOS" -> ZvaviLayout.ZvaviApple.width
                    else -> ZvaviLayout.ZvaviMobile.width
                },
                height = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.height
                    "iOS" -> ZvaviLayout.ZvaviApple.height
                    else -> ZvaviLayout.ZvaviMobile.height
                },
                colNumber = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.colNumber
                    "iOS" -> ZvaviLayout.ZvaviApple.colNumber
                    else -> ZvaviLayout.ZvaviMobile.colNumber
                },
                colWidth = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.colWidth
                    "iOS" -> ZvaviLayout.ZvaviApple.colWidth
                    else -> ZvaviLayout.ZvaviMobile.colWidth
                },
                gutter = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.gutter
                    "iOS" -> ZvaviLayout.ZvaviApple.gutter
                    else -> ZvaviLayout.ZvaviMobile.gutter
                },
                marginHorizontal = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.marginHorizontal
                    "iOS" -> ZvaviLayout.ZvaviApple.marginHorizontal
                    else -> ZvaviLayout.ZvaviMobile.marginHorizontal
                },
                contentCompensation = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.contentCompensation
                    "iOS" -> ZvaviLayout.ZvaviApple.contentCompensation
                    else -> ZvaviLayout.ZvaviMobile.contentCompensation
                },
                ignoreMarginHorizontal = when (currentPlatform) {
                    "ANDROID" -> ZvaviLayout.ZvaviAndroid.ignoreMarginHorizontal
                    "iOS" -> ZvaviLayout.ZvaviApple.ignoreMarginHorizontal
                    else -> ZvaviLayout.ZvaviMobile.ignoreMarginHorizontal
                }
            )
        }

        WindowSize.TABLET_PORTRAIT -> when (productType) {
            is ProductType.App -> LayoutConfig(
                breakpoint = WindowSize.TABLET_PORTRAIT.breakpoint,
                minWidth = ZvaviLayout.ZvaviTabletPortrait.minWidth,
                maxWidth = ZvaviLayout.ZvaviTabletPortrait.maxWidth,
                width = ZvaviLayout.ZvaviTabletPortrait.width,
                height = ZvaviLayout.ZvaviTabletPortrait.height,
                colNumber = ZvaviLayout.ZvaviTabletPortrait.colNumber,
                colWidth = ZvaviLayout.ZvaviTabletPortrait.colWidth,
                gutter = ZvaviLayout.ZvaviTabletPortrait.gutter,
                marginHorizontal = ZvaviLayout.ZvaviTabletPortrait.marginHorizontal,
                contentCompensation = ZvaviLayout.ZvaviTabletPortrait.contentCompensation,
                ignoreMarginHorizontal = ZvaviLayout.ZvaviTabletPortrait.ignoreMarginHorizontal
            )
            is ProductType.Extensions -> LayoutConfig(
                breakpoint = WindowSize.TABLET_PORTRAIT.breakpoint,
                minWidth = ZvaviLayout.ZvaviTabletPortrait.minWidth,
                maxWidth = ZvaviLayout.ZvaviTabletPortrait.maxWidth,
                width = ZvaviLayout.ZvaviTabletPortrait.width,
                height = ZvaviLayout.ZvaviTabletPortrait.height,
                colNumber = ZvaviLayout.ZvaviTabletPortrait.colNumber,
                colWidth = ZvaviLayout.ZvaviTabletPortrait.colWidth,
                gutter = ZvaviLayout.ZvaviTabletPortrait.gutter,
                marginHorizontal = ZvaviLayout.ZvaviTabletPortrait.marginHorizontal,
                contentCompensation = ZvaviLayout.ZvaviTabletPortrait.contentCompensation,
                ignoreMarginHorizontal = ZvaviLayout.ZvaviTabletPortrait.ignoreMarginHorizontal
            )
            is ProductType.MiniApp -> LayoutConfig(
                breakpoint = WindowSize.TABLET_PORTRAIT.breakpoint,
                minWidth = ZvaviLayout.ZvaviTabletPortrait.minWidth,
                maxWidth = ZvaviLayout.ZvaviTabletPortrait.maxWidth,
                width = ZvaviLayout.ZvaviTabletPortrait.width,
                height = ZvaviLayout.ZvaviTabletPortrait.height,
                colNumber = ZvaviLayout.ZvaviTabletPortrait.colNumber,
                colWidth = ZvaviLayout.ZvaviTabletPortrait.colWidth,
                gutter = ZvaviLayout.ZvaviTabletPortrait.gutter,
                marginHorizontal = ZvaviLayout.ZvaviTabletPortrait.marginHorizontal,
                contentCompensation = ZvaviLayout.ZvaviTabletPortrait.contentCompensation,
                ignoreMarginHorizontal = ZvaviLayout.ZvaviTabletPortrait.ignoreMarginHorizontal
            )
            is ProductType.Website -> LayoutConfig(
                breakpoint = WindowSize.TABLET_PORTRAIT.breakpoint,
                minWidth = ZvaviLayout.ZvaviTabletPortrait.minWidth,
                maxWidth = ZvaviLayout.ZvaviTabletPortrait.maxWidth,
                width = ZvaviLayout.ZvaviTabletPortrait.width,
                height = ZvaviLayout.ZvaviTabletPortrait.height,
                colNumber = ZvaviLayout.ZvaviTabletPortrait.colNumber,
                colWidth = ZvaviLayout.ZvaviTabletPortrait.colWidth,
                gutter = ZvaviLayout.ZvaviTabletPortrait.gutter,
                marginHorizontal = ZvaviLayout.ZvaviTabletPortrait.marginHorizontal,
                contentCompensation = ZvaviLayout.ZvaviTabletPortrait.contentCompensation,
                ignoreMarginHorizontal = ZvaviLayout.ZvaviTabletPortrait.ignoreMarginHorizontal
            )
        }

        WindowSize.TABLET_LANDSCAPE -> when (productType) {
            is ProductType.App -> LayoutConfig(
                breakpoint = WindowSize.TABLET_LANDSCAPE.breakpoint,
                minWidth = ZvaviLayout.ZvaviTabletLandscape.minWidth,
                maxWidth = ZvaviLayout.ZvaviTabletLandscape.maxWidth,
                width = ZvaviLayout.ZvaviTabletLandscape.width,
                height = ZvaviLayout.ZvaviTabletLandscape.height,
                colNumber = ZvaviLayout.ZvaviTabletLandscape.colNumber,
                colWidth = ZvaviLayout.ZvaviTabletLandscape.colWidth,
                gutter = ZvaviLayout.ZvaviTabletLandscape.gutter,
                marginHorizontal = ZvaviLayout.ZvaviTabletLandscape.marginHorizontal,
                contentCompensation = ZvaviLayout.ZvaviTabletLandscape.contentCompensation,
                ignoreMarginHorizontal = ZvaviLayout.ZvaviTabletLandscape.ignoreMarginHorizontal
            )
            is ProductType.Extensions -> LayoutConfig(
                breakpoint = WindowSize.TABLET_LANDSCAPE.breakpoint,
                minWidth = ZvaviLayout.ZvaviTabletLandscape.minWidth,
                maxWidth = ZvaviLayout.ZvaviTabletLandscape.maxWidth,
                width = ZvaviLayout.ZvaviTabletLandscape.width,
                height = ZvaviLayout.ZvaviTabletLandscape.height,
                colNumber = ZvaviLayout.ZvaviTabletLandscape.colNumber,
                colWidth = ZvaviLayout.ZvaviTabletLandscape.colWidth,
                gutter = ZvaviLayout.ZvaviTabletLandscape.gutter,
                marginHorizontal = ZvaviLayout.ZvaviTabletLandscape.marginHorizontal,
                contentCompensation = ZvaviLayout.ZvaviTabletLandscape.contentCompensation,
                ignoreMarginHorizontal = ZvaviLayout.ZvaviTabletLandscape.ignoreMarginHorizontal
            )
            is ProductType.MiniApp -> LayoutConfig(
                breakpoint = WindowSize.TABLET_LANDSCAPE.breakpoint,
                minWidth = ZvaviLayout.ZvaviTabletLandscape.minWidth,
                maxWidth = ZvaviLayout.ZvaviTabletLandscape.maxWidth,
                width = ZvaviLayout.ZvaviTabletLandscape.width,
                height = ZvaviLayout.ZvaviTabletLandscape.height,
                colNumber = ZvaviLayout.ZvaviTabletLandscape.colNumber,
                colWidth = ZvaviLayout.ZvaviTabletLandscape.colWidth,
                gutter = ZvaviLayout.ZvaviTabletLandscape.gutter,
                marginHorizontal = ZvaviLayout.ZvaviTabletLandscape.marginHorizontal,
                contentCompensation = ZvaviLayout.ZvaviTabletLandscape.contentCompensation,
                ignoreMarginHorizontal = ZvaviLayout.ZvaviTabletLandscape.ignoreMarginHorizontal
            )
            is ProductType.Website -> LayoutConfig(
                breakpoint = WindowSize.TABLET_LANDSCAPE.breakpoint,
                minWidth = ZvaviLayout.ZvaviTabletLandscape.minWidth,
                maxWidth = ZvaviLayout.ZvaviTabletLandscape.maxWidth,
                width = ZvaviLayout.ZvaviTabletLandscape.width,
                height = ZvaviLayout.ZvaviTabletLandscape.height,
                colNumber = ZvaviLayout.ZvaviTabletLandscape.colNumber,
                colWidth = ZvaviLayout.ZvaviTabletLandscape.colWidth,
                gutter = ZvaviLayout.ZvaviTabletLandscape.gutter,
                marginHorizontal = ZvaviLayout.ZvaviTabletLandscape.marginHorizontal,
                contentCompensation = ZvaviLayout.ZvaviTabletLandscape.contentCompensation,
                ignoreMarginHorizontal = ZvaviLayout.ZvaviTabletLandscape.ignoreMarginHorizontal
            )
        }

        WindowSize.DESKTOP -> when (productType) {
            is ProductType.App -> LayoutConfig(
                breakpoint = WindowSize.DESKTOP.breakpoint,
                minWidth = ZvaviLayout.ZvaviDesktop.minWidth,
                maxWidth = ZvaviLayout.ZvaviDesktop.maxWidth,
                width = ZvaviLayout.ZvaviDesktop.width,
                height = ZvaviLayout.ZvaviDesktop.height,
                colNumber = ZvaviLayout.ZvaviDesktop.colNumber,
                colWidth = ZvaviLayout.ZvaviDesktop.colWidth,
                gutter = ZvaviLayout.ZvaviDesktop.gutter,
                marginHorizontal = ZvaviLayout.ZvaviDesktop.marginHorizontal,
                contentCompensation = ZvaviLayout.ZvaviDesktop.contentCompensation,
                ignoreMarginHorizontal = ZvaviLayout.ZvaviDesktop.ignoreMarginHorizontal
            )
            is ProductType.Extensions -> LayoutConfig(
                breakpoint = WindowSize.DESKTOP.breakpoint,
                minWidth = ZvaviLayout.ZvaviDesktop.minWidth,
                maxWidth = ZvaviLayout.ZvaviDesktop.maxWidth,
                width = ZvaviLayout.ZvaviDesktop.width,
                height = ZvaviLayout.ZvaviDesktop.height,
                colNumber = ZvaviLayout.ZvaviDesktop.colNumber,
                colWidth = ZvaviLayout.ZvaviDesktop.colWidth,
                gutter = ZvaviLayout.ZvaviDesktop.gutter,
                marginHorizontal = ZvaviLayout.ZvaviDesktop.marginHorizontal,
                contentCompensation = ZvaviLayout.ZvaviDesktop.contentCompensation,
                ignoreMarginHorizontal = ZvaviLayout.ZvaviDesktop.ignoreMarginHorizontal
            )
            is ProductType.MiniApp -> LayoutConfig(
                breakpoint = WindowSize.DESKTOP.breakpoint,
                minWidth = ZvaviLayout.ZvaviDesktop.minWidth,
                maxWidth = ZvaviLayout.ZvaviDesktop.maxWidth,
                width = ZvaviLayout.ZvaviDesktop.width,
                height = ZvaviLayout.ZvaviDesktop.height,
                colNumber = ZvaviLayout.ZvaviDesktop.colNumber,
                colWidth = ZvaviLayout.ZvaviDesktop.colWidth,
                gutter = ZvaviLayout.ZvaviDesktop.gutter,
                marginHorizontal = ZvaviLayout.ZvaviDesktop.marginHorizontal,
                contentCompensation = ZvaviLayout.ZvaviDesktop.contentCompensation,
                ignoreMarginHorizontal = ZvaviLayout.ZvaviDesktop.ignoreMarginHorizontal
            )
            is ProductType.Website -> LayoutConfig(
                breakpoint = WindowSize.DESKTOP.breakpoint,
                minWidth = ZvaviLayout.ZvaviDesktop.minWidth,
                maxWidth = ZvaviLayout.ZvaviDesktop.maxWidth,
                width = ZvaviLayout.ZvaviDesktop.width,
                height = ZvaviLayout.ZvaviDesktop.height,
                colNumber = ZvaviLayout.ZvaviDesktop.colNumber,
                colWidth = ZvaviLayout.ZvaviDesktop.colWidth,
                gutter = ZvaviLayout.ZvaviDesktop.gutter,
                marginHorizontal = ZvaviLayout.ZvaviDesktop.marginHorizontal,
                contentCompensation = ZvaviLayout.ZvaviDesktop.contentCompensation,
                ignoreMarginHorizontal = ZvaviLayout.ZvaviDesktop.ignoreMarginHorizontal
            )
        }
    }

    CompositionLocalProvider(
        LocalWindowSize provides windowSize,
        LocalLayoutConfig provides layoutConfig
    ) {
        content()
    }
}

//@Composable
//fun Modifier.responsiveSpacing(
//    horizontal: Boolean = true,
//    vertical: Boolean = true
//) = composed {
//    val config = LocalLayoutConfig.current
//    when {
//        horizontal && vertical -> padding(
//            horizontal = config.marginHorizontal,
//            vertical = config.contentCompensation
//        )
//
//        horizontal -> padding(horizontal = config.marginHorizontal)
//        vertical -> padding(vertical = config.contentCompensation)
//        else -> this
//    }
//}