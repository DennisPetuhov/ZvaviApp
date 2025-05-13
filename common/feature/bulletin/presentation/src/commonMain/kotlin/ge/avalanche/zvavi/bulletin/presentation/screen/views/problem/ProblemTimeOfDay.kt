package ge.avalanche.zvavi.bulletin.presentation.screen.views.problem

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

private const val CLOCK_SIZE_DP = 96
private const val CLOCK_DIVISIONS = 12
private const val DEGREES_PER_DIVISION = 30f
private const val INNER_CIRCLE_RATIO = 2.4f
private const val LINE_LENGTH_MULTIPLIER = 1.5f
private const val LINE_STROKE_WIDTH = 5f

/**
 * A composable that renders a clock-like visualization for problem time of day.
 *
 * @param modifier The modifier to be applied to the layout
 * @param mainColor The primary color for the inner circle
 * @param secondaryColor The color for the outer circle
 * @param delimiterColor The color for the clock division lines
 */
@Composable
fun ProblemTimeOfDay(
    modifier: Modifier,
    mainColor: Color = ZvaviTheme.colors.backgroundBrandHigh,
    secondaryColor: Color = ZvaviTheme.colors.overlayBrand,
    delimiterColor: Color = ZvaviTheme.colors.layerFloor1
) {
    Box(modifier = modifier.size(CLOCK_SIZE_DP.dp)) {
        Canvas(
            modifier = Modifier.size(CLOCK_SIZE_DP.dp)
        ) {
            drawMainClock(secondaryColor)
            drawCircle(
                color = mainColor,
                radius = size.minDimension / INNER_CIRCLE_RATIO,
                center = center
            )
            drawClockDivisions(delimiterColor)
        }
    }
}

/**
 * Draws the clock division lines.
 *
 * @param delimiterColor The color for the division lines
 */
private fun DrawScope.drawClockDivisions(delimiterColor: Color) {
    val outerRadius = size.minDimension / 2
    val innerRadius = size.minDimension / INNER_CIRCLE_RATIO
    val gap = outerRadius - innerRadius
    val lineLength = gap * LINE_LENGTH_MULTIPLIER
    val startRadius = outerRadius - lineLength

    for (i in 0 until CLOCK_DIVISIONS) {
        val angle = (i * DEGREES_PER_DIVISION) * (PI / 180f).toFloat()
        val startX = center.x + startRadius * cos(angle)
        val startY = center.y + startRadius * sin(angle)
        val endX = center.x + outerRadius * cos(angle)
        val endY = center.y + outerRadius * sin(angle)

        drawLine(
            color = delimiterColor,
            start = Offset(startX, startY),
            end = Offset(endX, endY),
            strokeWidth = LINE_STROKE_WIDTH
        )
    }
}

/**
 * Draws the main outer circle of the clock.
 *
 * @param mainColor The color for the outer circle
 */
private fun DrawScope.drawMainClock(mainColor: Color) {
    val radius = size.minDimension / 2
    drawCircle(
        color = mainColor,
        radius = radius,
        center = center
    )
}