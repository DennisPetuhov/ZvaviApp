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
    const val CANVAS_WIDTH_DP: Int = 104

    /** Height of the grid in dp */
    const val CANVAS_HEIGHT_DP: Int = 60

    /** Width of the container in dp */
    const val CONTAINER_WIDTH_DP: Int = 104

    /** Height of the container in dp */
    const val CONTAINER_HEIGHT_DP: Int = 90
}

/**
 * Calculates the starting position for the grid of circles.
 * Centers the grid within the available space.
 *
 * @return A Pair containing the x and y coordinates for the grid start
 */
private fun DrawScope.calculateGridStartPosition(): Pair<Float, Float> {
    val circleRadius = ProblemDistributionConstants.CIRCLE_RADIUS_DP.dp.toPx()
    val gap = ProblemDistributionConstants.GAP_DP.dp.toPx()
    val diameter = circleRadius * 2

    val totalWidth = ProblemDistributionConstants.COLUMNS * diameter +
            (ProblemDistributionConstants.COLUMNS - 1) * gap
    val totalHeight = ProblemDistributionConstants.ROWS * diameter +
            (ProblemDistributionConstants.ROWS - 1) * gap

    val startX = (size.width - totalWidth) / 2 + circleRadius
    val startY = (size.height - totalHeight) / 2 + circleRadius

    return Pair(startX, startY)
}

/**
 * Draws a grid of colored circles representing the distribution.
 * The number of colored circles is determined by the percentage parameter.
 *
 * @param percentage The percentage of circles to be colored (0 to 100)
 * @param activeColor The color for the active circles
 * @param inactiveColor The color for the inactive circles
 */
private fun DrawScope.drawIsolatedAndWideSpreadPattern(
    percentage: Int,
    activeColor: Color,
    inactiveColor: Color
) {
    val circleRadius = ProblemDistributionConstants.CIRCLE_RADIUS_DP.dp.toPx()
    val gap = ProblemDistributionConstants.GAP_DP.dp.toPx()
    val diameter = circleRadius * 2
    val totalDots = ProblemDistributionConstants.COLUMNS * ProblemDistributionConstants.ROWS
    val (startX, startY) = calculateGridStartPosition()
    val activeDotsCount = (totalDots * percentage) / 100
    val activeIndices = (0 until totalDots)
        .toMutableList()
        .apply { shuffle() }
        .take(activeDotsCount)
        .toSet()

    for (row in 0 until ProblemDistributionConstants.ROWS) {
        for (col in 0 until ProblemDistributionConstants.COLUMNS) {
            val x = startX + col * (diameter + gap)
            val y = startY + row * (diameter + gap)
            val dotIndex = row * ProblemDistributionConstants.COLUMNS + col
            val color = if (activeIndices.contains(dotIndex)) activeColor else inactiveColor

            drawCircle(
                color = color,
                radius = circleRadius,
                center = Offset(x, y)
            )
        }
    }
}

/**
 * Draws a grid of circles with a specific pattern of secondary colors.
 * Pattern:
 * Row 1: only 6th circle is secondary
 * Row 2: 5th, 6th and 7th circles are secondary (all between and including 5th and 7th)
 * Row 3: 4th through last circles are secondary (all between and including 4th and last)
 * Row 4: 3rd through 7th circles are secondary (all between and including 3rd and 7th)
 */
private fun DrawScope.drawSpecificPattern(
    activeColor: Color,
    inactiveColor: Color
) {
    val circleRadius = ProblemDistributionConstants.CIRCLE_RADIUS_DP.dp.toPx()
    val gap = ProblemDistributionConstants.GAP_DP.dp.toPx()
    val diameter = circleRadius * 2
    val (startX, startY) = calculateGridStartPosition()

    for (row in 0 until ProblemDistributionConstants.ROWS) {
        for (col in 0 until ProblemDistributionConstants.COLUMNS) {
            val x = startX + col * (diameter + gap)
            val y = startY + row * (diameter + gap)
            val isInactive = when (row) {
                0 -> col == 5
                1 -> col in 4..6
                2 -> col in 3 until ProblemDistributionConstants.COLUMNS
                3 -> col in 2..6
                else -> false
            }

            drawCircle(
                color = if (isInactive) inactiveColor else activeColor,
                radius = circleRadius,
                center = Offset(x, y)
            )
        }
    }
}

/**
 * A composable that displays a grid of circles representing the distribution of an avalanche problem.
 * The grid shows the percentage of affected areas through colored circles.
 *
 * @param distributionPercentage The percentage of circles to be colored (0 to 100)
 * @param activeColor The color for the active circles
 * @param inactiveColor The color for the inactive circles
 * @param modifier Modifier for the composable
 */
@Composable
internal fun ProblemDistribution(
    distributionPercentage: Int,
    activeColor: Color = ZvaviTheme.colors.backgroundBrandHigh,
    inactiveColor: Color = ZvaviTheme.colors.overlayBrand,
    modifier: Modifier = Modifier
) {
    val normalizedPercentage = distributionPercentage.coerceIn(0, 100)
    Box(contentAlignment = Alignment.BottomEnd,
        modifier = modifier
            .width(ProblemDistributionConstants.CONTAINER_WIDTH_DP.dp)
            .height(ProblemDistributionConstants.CONTAINER_HEIGHT_DP.dp)
    ) {
        Canvas(
            modifier = Modifier
                .width(ProblemDistributionConstants.CANVAS_WIDTH_DP.dp)
                .height(ProblemDistributionConstants.CANVAS_HEIGHT_DP.dp)
        ) {
            if (normalizedPercentage == 50) {
                drawSpecificPattern(
                    activeColor = inactiveColor,
                    inactiveColor = activeColor
                )

            } else {
                drawIsolatedAndWideSpreadPattern(
                    percentage = normalizedPercentage,
                    activeColor = activeColor,
                    inactiveColor = inactiveColor
                )
            }
        }
    }
}