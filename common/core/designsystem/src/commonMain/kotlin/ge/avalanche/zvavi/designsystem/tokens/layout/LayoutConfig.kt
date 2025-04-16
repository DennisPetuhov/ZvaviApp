package ge.avalanche.zvavi.designsystem.tokens.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.getPlatform
import ge.avalanche.zvavi.designsystem.getPlatformScreenDimensions
import ge.avalanche.zvavi.designsystem.tokens.product.ProductDimensions
import ge.avalanche.zvavi.designsystem.tokens.product.ProductType
import ge.avalanche.zvavi.designsystem.tokens.zvaviLayout.ZvaviLayout

// Create CompositionLocal for the layout configuration
val LocalLayoutConfig = staticCompositionLocalOf<LayoutConfig> {
    error("No LayoutConfig provided")
}

// Create CompositionLocal for window size
val LocalWindowSize = compositionLocalOf<WindowSize> {
    error("No WindowSize provided")
}

interface LayoutConfigContract {
    val breakpoint: String
    val minWidth: Dp
    val maxWidth: Dp
    val width: Dp
    val height: Dp
    val colNumber: Int
    val colWidth: Dp
    val gutter: Dp
    val marginHorizontal: Dp
    val contentCompensation: Dp
    val ignoreMarginHorizontal: Dp
    val canvasScale: Float
    val pyramidSpacing: Dp
}

data class LayoutConfig(
    override val breakpoint: String,
    override val minWidth: Dp,
    override val maxWidth: Dp,
    override val width: Dp,
    override val height: Dp,
    override val colNumber: Int,
    override val colWidth: Dp,
    override val gutter: Dp,
    override val marginHorizontal: Dp,
    override val contentCompensation: Dp,
    override val ignoreMarginHorizontal: Dp,
    override val canvasScale: Float,
    override val pyramidSpacing: Dp

    ) : LayoutConfigContract

@Composable
fun ProvideLayoutConfig(
    productType: ProductType = ProductType.App,
    content: @Composable () -> Unit
) {
    val windowSize = rememberWindowSize()
    val screenWidth = getPlatformScreenDimensions().width
    val screenHeight = getPlatformScreenDimensions().height
    val platform = getPlatform()

    val size = getCurrentScreenSize()
    val layoutConfig = when (windowSize) {
        WindowSize.SMALL -> {
            val layout = when (platform) {
                "ANDROID" -> ZvaviLayout.ZvaviAndroid
                "iOS" -> ZvaviLayout.ZvaviApple
                else -> ZvaviLayout.ZvaviMobile
            }
            LayoutConfig(
                breakpoint = layout.breakpoint,
                minWidth = ProductDimensions.getWidth(productType, size),
                maxWidth = screenWidth,
                width = ProductDimensions.getWidth(productType, size),
                height = ProductDimensions.getHeight(productType, size),
                colNumber = layout.colNumber,
                colWidth = layout.colWidth,
                gutter = layout.gutter,
                marginHorizontal = layout.marginHorizontal,
                contentCompensation = layout.contentCompensation,
                ignoreMarginHorizontal = layout.ignoreMarginHorizontal,
                canvasScale = 1.2f,
                pyramidSpacing = ZvaviSpacing.spacing300
            )
        }

        WindowSize.MEDIUM -> {
            val layout = when (platform) {
                "ANDROID" -> ZvaviLayout.ZvaviAndroid
                "iOS" -> ZvaviLayout.ZvaviApple
                else -> ZvaviLayout.ZvaviMobile
            }
            LayoutConfig(
                breakpoint = layout.breakpoint,
                minWidth = ProductDimensions.getWidth(productType, size),
                maxWidth = screenWidth,
                width = ProductDimensions.getWidth(productType, size),
                height = ProductDimensions.getHeight(productType, size),
                colNumber = layout.colNumber,
                colWidth = layout.colWidth,
                gutter = layout.gutter,
                marginHorizontal = layout.marginHorizontal,
                contentCompensation = layout.contentCompensation,
                ignoreMarginHorizontal = layout.ignoreMarginHorizontal,
                canvasScale = 1.4f,
                pyramidSpacing = ZvaviSpacing.spacing400


            )
        }

        WindowSize.TABLET_PORTRAIT -> {
            val layout = ZvaviLayout.ZvaviTabletPortrait
            LayoutConfig(
                breakpoint = layout.breakpoint,
                minWidth = ProductDimensions.getWidth(productType, size),
                maxWidth = screenWidth,
                width = ProductDimensions.getWidth(productType, size),
                height = ProductDimensions.getHeight(productType, size),
                colNumber = layout.colNumber,
                colWidth = layout.colWidth,
                gutter = layout.gutter,
                marginHorizontal = layout.marginHorizontal,
                contentCompensation = layout.contentCompensation,
                ignoreMarginHorizontal = layout.ignoreMarginHorizontal,
                canvasScale = 2f,
                pyramidSpacing = ZvaviSpacing.spacing600


            )
        }

        WindowSize.TABLET_LANDSCAPE -> {
            val layout = ZvaviLayout.ZvaviTabletLandscape
            LayoutConfig(
                breakpoint = layout.breakpoint,
                minWidth = ProductDimensions.getWidth(productType, size),
                maxWidth = screenWidth,
                width = ProductDimensions.getWidth(productType, size),
                height = ProductDimensions.getHeight(productType, size),
                colNumber = layout.colNumber,
                colWidth = layout.colWidth,
                gutter = layout.gutter,
                marginHorizontal = layout.marginHorizontal,
                contentCompensation = layout.contentCompensation,
                ignoreMarginHorizontal = layout.ignoreMarginHorizontal,
                canvasScale = 2.2f,
                pyramidSpacing = ZvaviSpacing.spacing650

            )
        }

        WindowSize.DESKTOP -> {
            val layout = ZvaviLayout.ZvaviDesktop
            LayoutConfig(
                breakpoint = layout.breakpoint,
                minWidth = ProductDimensions.getWidth(productType, size),
                maxWidth = screenWidth,
                width = ProductDimensions.getWidth(productType, size),
                height = ProductDimensions.getHeight(productType, size),
                colNumber = layout.colNumber,
                colWidth = layout.colWidth,
                gutter = layout.gutter,
                marginHorizontal = layout.marginHorizontal,
                contentCompensation = layout.contentCompensation,
                ignoreMarginHorizontal = layout.ignoreMarginHorizontal,
                canvasScale = 2.5f,
                pyramidSpacing = ZvaviSpacing.spacing700


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
