package ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.views.problem

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme

/**
 * Constants for the ProblemDistribution component.
 * Contains all configuration values for the distribution grid visualization.
 */
private object ProblemDistributionConstants {
    /** Radius of each circle in the grid in dp */
    const val CIRCLE_RADIUS_DP: Int = 4
    
    /** Gap between circles in dp */
    const val GAP_DP: Int = 8
    
    /** Number of columns in the grid */
    const val COLUMNS: Int = 7
    
    /** Number of rows in the grid */
    const val ROWS: Int = 4
    
    /** Width of the grid in dp */
    const val GRID_WIDTH_DP: Int = 104
    
    /** Height of the grid in dp */
    const val GRID_HEIGHT_DP: Int = 56
    
    /** Width of the container in dp */
    const val CONTAINER_WIDTH_DP: Int = 100
    
    /** Height of the container in dp */
    const val CONTAINER_HEIGHT_DP: Int = 100
}

/**
 * Calculates the starting position for the grid of circles.
 * Centers the grid within the available space.
 *
 * @return A Pair containing the x and y coordinates for the grid start
 */
private fun DrawScope.calculateGridStartPosition(): Pair<Float, Float> {
    val circleRadius: Float = ProblemDistributionConstants.CIRCLE_RADIUS_DP.dp.toPx()
    val gap: Float = ProblemDistributionConstants.GAP_DP.dp.toPx()
    val diameter: Float = circleRadius * 2
    val totalWidth: Float = ProblemDistributionConstants.COLUMNS * diameter + (ProblemDistributionConstants.COLUMNS - 1) * gap
    val totalHeight: Float = ProblemDistributionConstants.ROWS * diameter + (ProblemDistributionConstants.ROWS - 1) * gap
    val startX: Float = (size.width - totalWidth) / 2 + circleRadius
    val startY: Float = (size.height - totalHeight) / 2 + circleRadius
    return Pair(startX, startY)
}

/**
 * Draws a grid of colored circles representing the distribution.
 * The number of colored circles is determined by the bluePercentage parameter.
 *
 * @param bluePercentage The percentage of circles to be colored (0.0 to 1.0)
 * @param mainColor The color for the active circles
 * @param secondaryColor The color for the inactive circles
 */
private fun DrawScope.drawColoredCirclesGrid(
    bluePercentage: Int,
    mainColor: Color,
    secondaryColor: Color
) {
    val circleRadius: Float = ProblemDistributionConstants.CIRCLE_RADIUS_DP.dp.toPx()
    val gap: Float = ProblemDistributionConstants.GAP_DP.dp.toPx()
    val diameter: Float = circleRadius * 2
    val totalDots: Int = ProblemDistributionConstants.COLUMNS * ProblemDistributionConstants.ROWS
    val (startX, startY) = calculateGridStartPosition()
    val blueDotsCount: Int = (totalDots * bluePercentage).toInt()/100
    val blueIndices: Set<Int> = (0 until totalDots)
        .toMutableList()
        .apply { shuffle() }
        .take(blueDotsCount)
        .toSet()
    var dotIndex: Int = 0
    for (row in 0 until ProblemDistributionConstants.ROWS) {
        for (col in 0 until ProblemDistributionConstants.COLUMNS) {
            val x: Float = startX + col * (diameter + gap)
            val y: Float = startY + row * (diameter + gap)
            val color: Color = if (blueIndices.contains(dotIndex)) mainColor else secondaryColor
            drawCircle(
                color = color,
                radius = circleRadius,
                center = Offset(x, y)
            )
            dotIndex++
        }
    }
}

/**
 * A composable that displays a grid of circles representing the distribution of an avalanche problem.
 * The grid shows the percentage of affected areas through colored circles.
 *
 * @param bluePercentage The percentage of circles to be colored (0.0 to 1.0)
 * @param mainColor The color for the active circles
 * @param secondaryColor The color for the inactive circles
 * @param modifier Modifier for the composable
 */
@Composable
internal fun ColoredCirclesGrid(
    bluePercentage: Int,
    mainColor: Color = ZvaviTheme.colors.backgroundBrandHigh,
    secondaryColor: Color = ZvaviTheme.colors.overlayBrand,
    modifier: Modifier = Modifier
) {
    val normalizedPercentage: Int = bluePercentage.coerceIn(0, 100)
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = modifier
            .width(ProblemDistributionConstants.CONTAINER_WIDTH_DP.dp)
            .height(ProblemDistributionConstants.CONTAINER_HEIGHT_DP.dp)
    ) {
        Canvas(
            modifier = Modifier
                .width(ProblemDistributionConstants.GRID_WIDTH_DP.dp)
                .height(ProblemDistributionConstants.GRID_HEIGHT_DP.dp)
        ) {
            drawColoredCirclesGrid(
                normalizedPercentage,
                mainColor = mainColor,
                secondaryColor = secondaryColor
            )
        }
    }
}