package ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.views.problem

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
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
import ge.avalanche.zvavi.bulletin.presentation.screen.utill.toRadians
import kotlin.math.cos
import kotlin.math.sin

private const val DEFAULT_SWEEP_ANGLE: Float = 360f
private const val DEFAULT_START_ANGLE: Float = 180f
private const val NEEDLE_LENGTH: Float = 60f
private const val NEEDLE_BASE_WIDTH: Float = 10f
private const val STROKE_WIDTH: Float = 50f
private const val CENTER_Y_OFFSET: Float = 2.09f

/**
 * A composable that renders a sensitivity meter with a needle indicator.
 *
 * @param innerGradient The color for the inner gradient
 * @param trackColor The color for the track
 * @param progressColors The color for the progress indicator
 * @param inputValue The input value (0-100) that determines the needle position
 * @param stroke The stroke width for the track
 * @param modifier The modifier to be applied to the composable
 */
@Composable
fun ProblemSensitivity(
    innerGradient: Color = Color.Yellow,
    trackColor: Color = Color.Blue,
    progressColors: Color = Color.Green,
    inputValue: Int = 40,
    stroke: Dp = 16.dp,
    modifier: Modifier = Modifier,
) {
    val meterValue: Int = getMeterValue(inputValue)
    val fillSwipeAngle: Float = (meterValue / 100f) * DEFAULT_SWEEP_ANGLE

    Box(modifier = modifier.size(96.dp, 56.dp)) {
        Canvas(modifier = Modifier.size(width = 96.dp, height = 56.dp)) {
            val height: Float = size.height
            val width: Float = size.width
            val centerOffset: Offset = Offset(width / 2f, height / CENTER_Y_OFFSET)

            drawTrack(trackColor, width, height)
            drawNeedle(centerOffset, fillSwipeAngle)
        }
    }
}

private fun DrawScope.drawTrack(
    trackColor: Color,
    width: Float,
    height: Float
) {
    drawArc(
        color = trackColor,
        startAngle = DEFAULT_START_ANGLE,
        sweepAngle = DEFAULT_SWEEP_ANGLE,
        useCenter = true,
        topLeft = Offset(0f, 0f),
        size = Size(height, width),
        style = Stroke(width = STROKE_WIDTH, cap = StrokeCap.Round)
    )
}

private fun DrawScope.drawNeedle(
    centerOffset: Offset,
    fillSwipeAngle: Float
) {
    val needleAngle: Float = (fillSwipeAngle / DEFAULT_SWEEP_ANGLE) * DEFAULT_SWEEP_ANGLE + DEFAULT_START_ANGLE
    val needlePath: Path = createNeedlePath(centerOffset, needleAngle)
    drawPath(color = Color.White, path = needlePath)
}

private fun createNeedlePath(centerOffset: Offset, needleAngle: Float): Path {
    return Path().apply {
        val topX: Float = centerOffset.x + NEEDLE_LENGTH * cos(toRadians(needleAngle.toDouble()).toFloat())
        val topY: Float = centerOffset.y + NEEDLE_LENGTH * sin(toRadians(needleAngle.toDouble()).toFloat())

        val baseLeftX: Float = centerOffset.x + NEEDLE_BASE_WIDTH * cos(toRadians((needleAngle - 90).toDouble()).toFloat())
        val baseLeftY: Float = centerOffset.y + NEEDLE_BASE_WIDTH * sin(toRadians((needleAngle - 90).toDouble()).toFloat())
        val baseRightX: Float = centerOffset.x + NEEDLE_BASE_WIDTH * cos(toRadians((needleAngle + 90).toDouble()).toFloat())
        val baseRightY: Float = centerOffset.y + NEEDLE_BASE_WIDTH * sin(toRadians((needleAngle + 90).toDouble()).toFloat())

        moveTo(topX, topY)
        lineTo(baseLeftX, baseLeftY)
        lineTo(baseRightX, baseRightY)
        close()
    }
}

private fun getMeterValue(inputPercentage: Int): Int {
    return inputPercentage.coerceIn(0, 100)
}
