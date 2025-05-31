package ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.views.problem

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.bulletin.api.models.AvalancheProblem
import ge.avalanche.zvavi.bulletin.presentation.screen.utill.toRadians
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import kotlin.math.cos
import kotlin.math.sin

/**
 * Constants for the ProblemSensitivity component.
 * Contains all the configuration values for the sensitivity meter visualization.
 */
private object ProblemSensitivityConstants {
    /** Default stroke width for arcs and circles in dp */
    const val DEFAULT_STROKE_DP: Int = 16

    /** Default size of the component in dp */
    const val DEFAULT_SIZE_DP: Int = 100

    /** Length of the needle from center to tip */
    const val NEEDLE_LENGTH: Float = 100f

    /** Width of the needle base */
    const val NEEDLE_BASE_WIDTH: Float = 15f

    /** Starting angle for the first arc segment in degrees */
    const val ARC_START_ANGLE: Float = 180f

    /** Sweep angle for the first three arc segments in degrees */
    const val ARC_SWEEP_ANGLE: Float = 40f

    /** Starting angle for the second arc segment in degrees */
    const val SECOND_ARC_START_ANGLE: Float = 225f

    /** Starting angle for the third arc segment in degrees */
    const val THIRD_ARC_START_ANGLE: Float = 270f

    /** Starting angle for the fourth arc segment in degrees */
    const val FOURTH_ARC_START_ANGLE: Float = 315f

    /** Sweep angle for the fourth arc segment in degrees */
    const val FOURTH_ARC_SWEEP_ANGLE: Float = 45f

    /** Radius of the center circle */
    const val CIRCLE_RADIUS: Float = 12f

    /** Stroke width for the center circle */
    const val CIRCLE_STROKE_WIDTH: Float = 10f

    /** Angle offset for needle base points in degrees */
    const val NEEDLE_ANGLE_OFFSET: Int = 90

    /** Height divider for arc positioning */
    const val HEIGHT_DIVIDER: Float = 2.5f

    /** Maximum percentage value for the meter */
    const val MAX_PERCENTAGE: Int = 100
}

/**
 * A composable that displays a sensitivity meter with a needle and arc segments.
 * The meter shows the sensitivity level of an avalanche problem.
 *
 * @param primaryColor The primary color for active elements
 * @param secondaryColor The secondary color for inactive elements
 * @param stroke The stroke width for arcs and circles
 * @param modifier Additional modifier for the component
 */
@Composable
fun ProblemSensitivity(
    problem: AvalancheProblem,
    primaryColor: Color = ZvaviTheme.colors.backgroundBrandHigh,
    secondaryColor: Color = ZvaviTheme.colors.overlayBrand,
    stroke: Dp = ProblemSensitivityConstants.DEFAULT_STROKE_DP.dp,
    modifier: Modifier = Modifier,
) {
    val meterValue: Int = getMeterValue(problem.sensitivity.values.first())
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.size(ProblemSensitivityConstants.DEFAULT_SIZE_DP.dp)
    ) {
        Canvas(modifier = Modifier.size(ProblemSensitivityConstants.DEFAULT_SIZE_DP.dp)) {
            val height: Float = size.height
            val width: Float = size.width
            val centerOffset: Offset = Offset(width / 2f, height - stroke.toPx())

            drawArcs(
                problem = problem,
                mainColor = primaryColor,
                secondaryColor = secondaryColor,
                stroke = stroke,
                height = height,
                width = width
            )

            drawCenterCircle(
                secondaryColor = primaryColor,
                width = width,
                height = height,
                stroke = stroke
            )

            drawNeedle(
                mainColor = primaryColor,
                centerOffset = centerOffset,
                meterValue = meterValue
            )
        }
    }
}

/**
 * Ensures the input value is within valid range (0-100)
 *
 * @param inputPercentage The input percentage value
 * @return A value coerced between 0 and MAX_PERCENTAGE
 */
private fun getMeterValue(inputPercentage: Int): Int =
    inputPercentage.coerceIn(0, ProblemSensitivityConstants.MAX_PERCENTAGE)

/**
 * Draws the arc segments of the sensitivity meter
 *
 * @param mainColor Color for active arc segments
 * @param secondaryColor Color for inactive arc segments
 * @param stroke Stroke width for the arcs
 * @param height Canvas height
 * @param width Canvas width
 */
private fun DrawScope.drawArcs(
    problem: AvalancheProblem,
    mainColor: Color,
    secondaryColor: Color,
    stroke: Dp,
    height: Float,
    width: Float
) {
    val arcSize: Size = Size(width - stroke.toPx(), width - stroke.toPx())
    val topLeft: Offset = Offset(
        stroke.toPx() / 2,
        height / ProblemSensitivityConstants.HEIGHT_DIVIDER - stroke.toPx() / 2
    )
    val strokeStyle: Stroke = Stroke(width = stroke.toPx(), cap = StrokeCap.Butt)

    drawArc(
        color = if (problem.sensitivity.values.first() > 11) mainColor else secondaryColor,
        startAngle = ProblemSensitivityConstants.ARC_START_ANGLE,
        sweepAngle = ProblemSensitivityConstants.ARC_SWEEP_ANGLE,
        useCenter = false,
        topLeft = topLeft,
        size = arcSize,
        style = strokeStyle
    )

    drawArc(
        color = if (problem.sensitivity.values.first() >21) mainColor else secondaryColor,
        startAngle = ProblemSensitivityConstants.SECOND_ARC_START_ANGLE,
        sweepAngle = ProblemSensitivityConstants.ARC_SWEEP_ANGLE,
        useCenter = false,
        topLeft = topLeft,
        size = arcSize,
        style = strokeStyle
    )

    drawArc(
        color = if (problem.sensitivity.values.first() >41) mainColor else secondaryColor,
        startAngle = ProblemSensitivityConstants.THIRD_ARC_START_ANGLE,
        sweepAngle = ProblemSensitivityConstants.ARC_SWEEP_ANGLE,
        useCenter = false,
        topLeft = topLeft,
        size = arcSize,
        style = strokeStyle
    )

    drawArc(
        color = if (problem.sensitivity.values.first() > 61) mainColor else secondaryColor,
        startAngle = ProblemSensitivityConstants.FOURTH_ARC_START_ANGLE,
        sweepAngle = ProblemSensitivityConstants.FOURTH_ARC_SWEEP_ANGLE,
        useCenter = false,
        topLeft = topLeft,
        size = arcSize,
        style = strokeStyle
    )
}

/**
 * Draws the center circle of the sensitivity meter
 *
 * @param secondaryColor Color for the circle
 * @param width Canvas width
 * @param height Canvas height
 * @param stroke Stroke width for the circle
 */
private fun DrawScope.drawCenterCircle(
    secondaryColor: Color,
    width: Float,
    height: Float,
    stroke: Dp
) {
    drawCircle(
        color = secondaryColor,
        radius = ProblemSensitivityConstants.CIRCLE_RADIUS,
        center = Offset(width / 2f, height - stroke.toPx()),
        style = Stroke(width = ProblemSensitivityConstants.CIRCLE_STROKE_WIDTH.dp.toPx())
    )
}

/**
 * Draws the needle of the sensitivity meter
 *
 * @param mainColor Color for the needle
 * @param centerOffset Center point of the needle
 * @param meterValue Current value of the meter (0-100)
 */
private fun DrawScope.drawNeedle(
    mainColor: Color,
    centerOffset: Offset,
    meterValue: Int
) {
    val needleAngle: Float = ProblemSensitivityConstants.ARC_START_ANGLE +
            (meterValue / ProblemSensitivityConstants.MAX_PERCENTAGE.toFloat()) * ProblemSensitivityConstants.ARC_START_ANGLE
    val needlePath: Path = Path().apply {
        val topX: Float = centerOffset.x + ProblemSensitivityConstants.NEEDLE_LENGTH *
                cos(toRadians(needleAngle.toDouble()).toFloat())
        val topY: Float = centerOffset.y + ProblemSensitivityConstants.NEEDLE_LENGTH *
                sin(toRadians(needleAngle.toDouble()).toFloat())
        val baseLeftX: Float = centerOffset.x + ProblemSensitivityConstants.NEEDLE_BASE_WIDTH *
                cos(toRadians((needleAngle - ProblemSensitivityConstants.NEEDLE_ANGLE_OFFSET).toDouble()).toFloat())
        val baseLeftY: Float = centerOffset.y + ProblemSensitivityConstants.NEEDLE_BASE_WIDTH *
                sin(toRadians((needleAngle - ProblemSensitivityConstants.NEEDLE_ANGLE_OFFSET).toDouble()).toFloat())
        val baseRightX: Float = centerOffset.x + ProblemSensitivityConstants.NEEDLE_BASE_WIDTH *
                cos(toRadians((needleAngle + ProblemSensitivityConstants.NEEDLE_ANGLE_OFFSET).toDouble()).toFloat())
        val baseRightY: Float = centerOffset.y + ProblemSensitivityConstants.NEEDLE_BASE_WIDTH *
                sin(toRadians((needleAngle + ProblemSensitivityConstants.NEEDLE_ANGLE_OFFSET).toDouble()).toFloat())

        moveTo(topX, topY)
        lineTo(baseLeftX, baseLeftY)
        lineTo(baseRightX, baseRightY)
        close()
    }

    drawPath(color = mainColor, path = needlePath)
}