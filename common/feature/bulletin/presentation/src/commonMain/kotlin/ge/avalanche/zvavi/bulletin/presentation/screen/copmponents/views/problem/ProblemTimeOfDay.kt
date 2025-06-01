package ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.views.problem

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.bulletin.api.models.TimeOfDay
import ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.views.problem.ProblemTimeOfDayConstants.CONTAINER_HEIGHT_DP
import ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.views.problem.ProblemTimeOfDayConstants.CONTAINER_WIDTH_DP
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

    /** Width of the container in dp */
    const val CONTAINER_WIDTH_DP: Int = 104

    /** Height of the container in dp */
    const val CONTAINER_HEIGHT_DP: Int = 100

    /** Mapping of hours to their corresponding angles in degrees */
    val HOUR_ANGLES = mapOf(
        0 to -90f,
        1 to -60f,
        2 to -30f,
        3 to 0f,
        4 to 30f,
        5 to 60f,
        6 to 90f,
        7 to 120f,
        8 to 150f,
        9 to 180f,
        10 to 210f,
        11 to 240f,
        12 to 270f,
        13 to 300f,
        14 to 330f,
        15 to 360f,
        16 to 390f,
        17 to 420f,
        18 to 450f,
    )
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
    timeOfDay: TimeOfDay,
    modifier: Modifier,
    mainColor: Color = ZvaviTheme.colors.backgroundBrandHigh,
    secondaryColor: Color = ZvaviTheme.colors.overlayBrand,
    delimiterColor: Color = ZvaviTheme.colors.layerFloor1
) {
    Box(modifier = modifier.size(ProblemTimeOfDayConstants.CANVAS_SIZE_DP)) {
        Canvas(
            modifier = modifier.size(
                width = CONTAINER_WIDTH_DP.dp,
                height = CONTAINER_HEIGHT_DP.dp
            )
        ) {
            drawMainClock(secondaryColor)
            drawSegment(
                mainColor = mainColor,
                isAllday = timeOfDay.isAllDay,
                startHour = timeOfDay.start,
                endHour = timeOfDay.end
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
        val angle: Float =
            (i * ProblemTimeOfDayConstants.DEGREES_PER_DIVISION) * (PI / 180f).toFloat()
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

private fun calculateSweepAngle(startHour: Int, endHour: Int): Float {
    val startAngle = ProblemTimeOfDayConstants.HOUR_ANGLES[startHour] ?: 0f
    val endAngle = ProblemTimeOfDayConstants.HOUR_ANGLES[endHour] ?: 0f

    // Calculate sweep angle
    var sweep = endAngle - startAngle

    // Handle the case when we cross the 0/360 boundary
    if (sweep < 0) {
        sweep += 360f
    }

    // If endHour is less than startHour, we need to go around the circle
    if (endHour < startHour) {
        sweep = 360f - sweep
    }

    return sweep
}

private fun DrawScope.drawSegment(
    mainColor: Color,
    isAllday: Boolean,
    startHour: Int,
    endHour: Int
) {
    val radius = size.minDimension / ProblemTimeOfDayConstants.INNER_CIRCLE_RATIO
    val startAngle = ProblemTimeOfDayConstants.HOUR_ANGLES[startHour] ?: 0f
    val sweepAngle = if (isAllday) 360f else calculateSweepAngle(startHour, endHour)

    drawArc(
        color = mainColor,
        startAngle = startAngle,
        sweepAngle = sweepAngle,
        useCenter = true,
        topLeft = Offset(center.x - radius, center.y - radius),
        size = Size(radius * 2, radius * 2)
    )
}