package ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.views.problem

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

/**
 * Constants for the ProblemTimeOfDay component.
 * Contains all configuration values for the clock visualization.
 */
private object ProblemTimeOfDayConstants {
    /** Number of divisions in the clock */
    const val CLOCK_DIVISIONS: Int = 12
    
    /** Degrees per division in the clock */
    const val DEGREES_PER_DIVISION: Float = 30f
    
    /** Ratio for inner circle size */
    const val INNER_CIRCLE_RATIO: Float = 2.4f
    
    /** Multiplier for line length */
    const val LINE_LENGTH_MULTIPLIER: Float = 1.5f
    
    /** Width of the clock division lines */
    const val LINE_STROKE_WIDTH: Float = 5f
    
    /** Size of the canvas in dp */
    val CANVAS_SIZE_DP = 100.dp
}

/**
 * A composable that renders a clock-like visualization for problem time of day.
 * Shows a circular clock face with division lines and an inner circle.
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
    Box(modifier = modifier.size(ProblemTimeOfDayConstants.CANVAS_SIZE_DP)) {
        Canvas(
            modifier = Modifier.size(ProblemTimeOfDayConstants.CANVAS_SIZE_DP)
        ) {
            drawMainClock(secondaryColor)
            drawCircle(
                color = mainColor,
                radius = size.minDimension / ProblemTimeOfDayConstants.INNER_CIRCLE_RATIO,
                center = center
            )
            drawClockDivisions(delimiterColor)
        }
    }
}

/**
 * Draws the clock division lines.
 * Creates evenly spaced lines around the clock face.
 *
 * @param delimiterColor The color for the division lines
 */
private fun DrawScope.drawClockDivisions(delimiterColor: Color) {
    val outerRadius: Float = size.minDimension / 2
    val innerRadius: Float = size.minDimension / ProblemTimeOfDayConstants.INNER_CIRCLE_RATIO
    val gap: Float = outerRadius - innerRadius
    val lineLength: Float = gap * ProblemTimeOfDayConstants.LINE_LENGTH_MULTIPLIER
    val startRadius: Float = outerRadius - lineLength

    for (i in 0 until ProblemTimeOfDayConstants.CLOCK_DIVISIONS) {
        val angle: Float = (i * ProblemTimeOfDayConstants.DEGREES_PER_DIVISION) * (PI / 180f).toFloat()
        val startX: Float = center.x + startRadius * cos(angle)
        val startY: Float = center.y + startRadius * sin(angle)
        val endX: Float = center.x + outerRadius * cos(angle)
        val endY: Float = center.y + outerRadius * sin(angle)

        drawLine(
            color = delimiterColor,
            start = Offset(startX, startY),
            end = Offset(endX, endY),
            strokeWidth = ProblemTimeOfDayConstants.LINE_STROKE_WIDTH
        )
    }
}

/**
 * Draws the main outer circle of the clock.
 * Creates the base circle for the clock face.
 *
 * @param mainColor The color for the outer circle
 */
private fun DrawScope.drawMainClock(mainColor: Color) {
    val radius: Float = size.minDimension / 2
    drawCircle(
        color = mainColor,
        radius = radius,
        center = center
    )
}