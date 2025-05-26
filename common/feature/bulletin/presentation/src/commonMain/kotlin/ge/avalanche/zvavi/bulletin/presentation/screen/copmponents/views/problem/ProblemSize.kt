package ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.views.problem

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.bulletin.presentation.screen.utill.getTan45
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme

/**
 * Constants for the ProblemSize component.
 * Contains all configuration values for the size visualization.
 */
private object ProblemSizeConstants {
    /** Size of the canvas in dp */
    val CANVAS_SIZE_DP: Dp = 100.dp
    
    /** Default gap between levels in dp */
    val DEFAULT_GAP_DP: Dp = 4.dp
    
    /** Default number of levels */
    const val DEFAULT_QUANTITY: Int = 5
}

/**
 * A composable that displays an avalanche problem size indicator.
 * Shows a series of triangular shapes representing different size levels.
 *
 * @param avalancheSize The size of the avalanche problem (1-5)
 * @param backgroundColor Background color for inactive levels
 * @param color Color for active levels
 * @param modifier Modifier for the composable
 */
@Composable
fun ZvaviProblemSize(
    avalancheSize: Int,
    backgroundColor: Color = ZvaviTheme.colors.overlayBrand,
    color: Color = ZvaviTheme.colors.backgroundBrandHigh,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.CenterEnd,
        modifier = modifier.size(ProblemSizeConstants.CANVAS_SIZE_DP)
    ) {
        Canvas(modifier = Modifier.size(ProblemSizeConstants.CANVAS_SIZE_DP)) {
            val problemSizeShape = ProblemSizeShape()
            drawPath(
                problemSizeShape.drawFirstLevel(
                    size = size,
                    color = color,
                    quantity = ProblemSizeConstants.DEFAULT_QUANTITY,
                    density = this
                ),
                color = color
            )
            problemSizeShape.drawOtherLevels(
                size = size,
                quantity = ProblemSizeConstants.DEFAULT_QUANTITY,
                density = this
            ).forEachIndexed { index, path ->
                drawPath(
                    path = path,
                    color = if (index < avalancheSize - 1) color else backgroundColor,
                    style = Fill
                )
            }
        }
    }
}

/**
 * Shape class for drawing avalanche problem size indicators.
 * Handles the creation of triangular shapes for different size levels.
 */
class ProblemSizeShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline = Outline.Generic(Path())

    /**
     * Draws the first level of the size indicator.
     *
     * @param size The size of the drawing area
     * @param color The color for the level
     * @param quantity The total number of levels
     * @param density The density for converting dp to pixels
     * @param gap The gap between levels
     * @return A Path object representing the first level
     */
    internal fun drawFirstLevel(
        size: Size,
        color: Color,
        quantity: Int,
        density: Density,
        gap: Dp = ProblemSizeConstants.DEFAULT_GAP_DP
    ): Path {
        val gapPx: Float = with(density) { gap.toPx() }
        val totalGap: Float = gapPx * (quantity - 1)
        val minDimension: Float = size.minDimension
        val levelWidth: Float = (minDimension - totalGap) / quantity
        val x: Float = levelWidth
        
        return Path().apply {
            moveTo(0f, minDimension)
            lineTo(x, minDimension - getTan45() * x)
            lineTo(x, minDimension)
            close()
        }
    }

    /**
     * Draws the remaining levels of the size indicator.
     *
     * @param size The size of the drawing area
     * @param quantity The total number of levels
     * @param gap The gap between levels
     * @param density The density for converting dp to pixels
     * @return A list of Path objects representing the remaining levels
     */
    internal fun drawOtherLevels(
        size: Size,
        quantity: Int,
        gap: Dp = ProblemSizeConstants.DEFAULT_GAP_DP,
        density: Density
    ): List<Path> {
        val minDimension: Float = size.minDimension
        val gapPx: Float = with(density) { gap.toPx() }
        val totalGap: Float = gapPx * (quantity - 1)
        val levelWidth: Float = (minDimension - totalGap) / quantity
        
        return (1 until quantity).map { i ->
            val x1: Float = i * (levelWidth + gapPx)
            val x2: Float = x1
            val x3: Float = x1 + levelWidth
            
            Path().apply {
                moveTo(x1, minDimension)
                lineTo(x2, minDimension - (getTan45() * x1))
                lineTo(x3, minDimension - (getTan45() * x3))
                lineTo(x3, minDimension)
                close()
            }
        }
    }
}