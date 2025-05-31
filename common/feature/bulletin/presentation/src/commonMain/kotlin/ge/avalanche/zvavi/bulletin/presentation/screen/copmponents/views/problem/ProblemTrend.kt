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
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.bulletin.api.models.Trend
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme



/**
 * Constants for the ProblemTrend component.
 * Contains all configuration values for the trend visualization.
 */
private object ProblemTrendConstants {
    /** One third of the total size */
    const val ONE_THIRD: Float = 1f / 3f
    
    /** Two thirds of the total size */
    const val TWO_THIRDS: Float = 2f / 3f
    
    /** Size of the canvas in dp */
    val CANVAS_SIZE_DP: Dp = 100.dp
    
    /** Width of the trend lines in dp */
    val TREND_STROKE_WIDTH_DP: Dp = 7.dp
    
    /** Size of the inner canvas in dp */
    val INNER_CANVAS_SIZE_DP: Dp = 90.dp
}

/**
 * A composable that renders a trend visualization for avalanche problems.
 * Shows directional arrows indicating the trend of the problem.
 *
 * @param color The color for the trend lines
 * @param modifier The modifier to be applied to the layout
 * @param direction The direction of the trend
 */
@Composable
fun ProblemTrend(
    color: Color = ZvaviTheme.colors.backgroundBrandHigh,
    modifier: Modifier = Modifier,
    direction: Trend
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.size(ProblemTrendConstants.CANVAS_SIZE_DP)
    ) {
        Canvas(modifier = Modifier.size(ProblemTrendConstants.INNER_CANVAS_SIZE_DP)) {
            drawTrendPaths(
                trendShape = TrendShape(),
                size = size,
                color = color,
                density = this,
                direction = direction
            )
        }
    }
}

/**
 * Draws the trend paths based on the specified direction.
 *
 * @param trendShape The shape object used to draw the trend
 * @param size The size of the drawing area
 * @param color The color for the trend lines
 * @param direction The direction of the trend
 * @param density The density for converting dp to pixels
 */
private fun DrawScope.drawTrendPaths(
    trendShape: TrendShape,
    size: Size,
    color: Color,
    direction: Trend,
    density: Density
) {
    val path: Path = trendShape.drawTrend(size, direction)
    drawPath(
        path = path,
        color = color,
        style = Stroke(width = with(density) { ProblemTrendConstants.TREND_STROKE_WIDTH_DP.toPx() })
    )
}

/**
 * Shape class for drawing trend indicators.
 * Handles the creation of different trend path patterns.
 */
class TrendShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline = Outline.Generic(Path())

    /**
     * Creates a path based on the specified trend direction.
     *
     * @param size The size of the drawing area
     * @param direction The direction of the trend
     * @return A Path object representing the trend
     */
    fun drawTrend(size: Size, direction: Trend): Path {
        val minDimension: Float = size.minDimension
        return when (direction) {
            Trend.NO_CHANGES -> createNoChangesPath(minDimension)
            Trend.IMPROVING -> createImprovingPath(minDimension)
            Trend.DETERIORATING -> createDeterioratingPath(minDimension)
        }
    }

    /**
     * Creates a path for no changes trend.
     * Draws two horizontal lines.
     */
    private fun createNoChangesPath(minDimension: Float): Path = Path().apply {
        moveTo(ProblemTrendConstants.ONE_THIRD * minDimension, ProblemTrendConstants.ONE_THIRD * minDimension)
        lineTo(ProblemTrendConstants.TWO_THIRDS * minDimension, ProblemTrendConstants.ONE_THIRD * minDimension)
        moveTo(ProblemTrendConstants.ONE_THIRD * minDimension, ProblemTrendConstants.TWO_THIRDS * minDimension)
        lineTo(ProblemTrendConstants.TWO_THIRDS * minDimension, ProblemTrendConstants.TWO_THIRDS * minDimension)
    }

    /**
     * Creates a path for improving trend.
     * Draws upward-pointing arrows.
     */
    private fun createImprovingPath(minDimension: Float): Path = Path().apply {
        moveTo(ProblemTrendConstants.TWO_THIRDS * minDimension, 0f)
        lineTo(minDimension, 0f)
        lineTo(minDimension, ProblemTrendConstants.ONE_THIRD * minDimension)

        moveTo(ProblemTrendConstants.ONE_THIRD * minDimension, ProblemTrendConstants.ONE_THIRD * minDimension)
        lineTo(ProblemTrendConstants.TWO_THIRDS * minDimension, ProblemTrendConstants.ONE_THIRD * minDimension)
        lineTo(ProblemTrendConstants.TWO_THIRDS * minDimension, ProblemTrendConstants.TWO_THIRDS * minDimension)

        moveTo(0f, ProblemTrendConstants.TWO_THIRDS * minDimension)
        lineTo(ProblemTrendConstants.ONE_THIRD * minDimension, ProblemTrendConstants.TWO_THIRDS * minDimension)
        lineTo(ProblemTrendConstants.ONE_THIRD * minDimension, minDimension)
    }

    /**
     * Creates a path for deteriorating trend.
     * Draws downward-pointing arrows.
     */
    private fun createDeterioratingPath(minDimension: Float): Path = Path().apply {
        moveTo(ProblemTrendConstants.TWO_THIRDS * minDimension, 0f)
        lineTo(ProblemTrendConstants.TWO_THIRDS * minDimension, ProblemTrendConstants.ONE_THIRD * minDimension)
        lineTo(minDimension, ProblemTrendConstants.ONE_THIRD * minDimension)

        moveTo(ProblemTrendConstants.ONE_THIRD * minDimension, ProblemTrendConstants.ONE_THIRD * minDimension)
        lineTo(ProblemTrendConstants.ONE_THIRD * minDimension, ProblemTrendConstants.TWO_THIRDS * minDimension)
        lineTo(ProblemTrendConstants.TWO_THIRDS * minDimension, ProblemTrendConstants.TWO_THIRDS * minDimension)

        moveTo(0f, ProblemTrendConstants.TWO_THIRDS * minDimension)
        lineTo(0f, minDimension)
        lineTo(ProblemTrendConstants.ONE_THIRD * minDimension, minDimension)
    }
}