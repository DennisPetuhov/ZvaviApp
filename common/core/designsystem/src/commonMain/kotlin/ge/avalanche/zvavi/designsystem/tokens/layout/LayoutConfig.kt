package ge.avalanche.zvavi.designsystem.tokens.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
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
    override val ignoreMarginHorizontal: Dp
) : LayoutConfigContract

@Composable
fun ProvideLayoutConfig(
    productType: ProductType = ProductType.App,
    content: @Composable () -> Unit
) {
    val windowSize = rememberWindowSize()

    val size = getCurrentScreenSize()
    val layoutConfig = when (windowSize) {
        WindowSize.COMPACT -> {
            val layout = ZvaviLayout.ZvaviMobile
            LayoutConfig(
                breakpoint = layout.breakpoint,
                minWidth = ProductDimensions.getWidth(productType, size),
                maxWidth = ProductDimensions.getWidth(productType, size),
                width = ProductDimensions.getWidth(productType, size),
                height = ProductDimensions.getHeight(productType, size),
                colNumber = layout.colNumber,
                colWidth = layout.colWidth,
                gutter = layout.gutter,
                marginHorizontal = layout.marginHorizontal,
                contentCompensation = layout.contentCompensation,
                ignoreMarginHorizontal = layout.ignoreMarginHorizontal
            )
        }

        WindowSize.TABLET_PORTRAIT -> {
            val layout = ZvaviLayout.ZvaviTabletPortrait
            LayoutConfig(
                breakpoint = layout.breakpoint,
                minWidth = ProductDimensions.getWidth(productType, size),
                maxWidth = ProductDimensions.getWidth(productType, size),
                width = ProductDimensions.getWidth(productType, size),
                height = ProductDimensions.getHeight(productType, size),
                colNumber = layout.colNumber,
                colWidth = layout.colWidth,
                gutter = layout.gutter,
                marginHorizontal = layout.marginHorizontal,
                contentCompensation = layout.contentCompensation,
                ignoreMarginHorizontal = layout.ignoreMarginHorizontal
            )
        }

        WindowSize.TABLET_LANDSCAPE -> {
            val layout = ZvaviLayout.ZvaviTabletLandscape
            LayoutConfig(
                breakpoint = layout.breakpoint,
                minWidth = ProductDimensions.getWidth(productType, size),
                maxWidth = ProductDimensions.getWidth(productType, size),
                width = ProductDimensions.getWidth(productType, size),
                height = ProductDimensions.getHeight(productType, size),
                colNumber = layout.colNumber,
                colWidth = layout.colWidth,
                gutter = layout.gutter,
                marginHorizontal = layout.marginHorizontal,
                contentCompensation = layout.contentCompensation,
                ignoreMarginHorizontal = layout.ignoreMarginHorizontal
            )
        }

        WindowSize.DESKTOP -> {
            val layout = ZvaviLayout.ZvaviDesktop
            LayoutConfig(
                breakpoint = layout.breakpoint,
                minWidth = ProductDimensions.getWidth(productType, size),
                maxWidth = ProductDimensions.getWidth(productType, size),
                width = ProductDimensions.getWidth(productType, size),
                height = ProductDimensions.getHeight(productType, size),
                colNumber = layout.colNumber,
                colWidth = layout.colWidth,
                gutter = layout.gutter,
                marginHorizontal = layout.marginHorizontal,
                contentCompensation = layout.contentCompensation,
                ignoreMarginHorizontal = layout.ignoreMarginHorizontal
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
