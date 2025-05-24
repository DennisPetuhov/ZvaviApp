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
import ge.avalanche.zvavi.bulletin.presentation.screen.utill.toRadians
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import kotlin.math.cos
import kotlin.math.sin



@Composable
fun ProblemSensitivity(
    mainColor: Color = ZvaviTheme.colors.backgroundBrandHigh,
    secondaryColor: Color = ZvaviTheme.colors.overlayBrand,
    inputValue: Int = DEFAULT_INPUT_VALUE,
    stroke: Dp = DEFAULT_STROKE_DP.dp,
    modifier: Modifier = Modifier,
) {
    val meterValue = getMeterValue(inputValue)
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.size(DEFAULT_SIZE_DP.dp)
    ) {
        Canvas(modifier = Modifier.size(DEFAULT_SIZE_DP.dp)) {
            val height = size.height
            val width = size.width
            val centerOffset = Offset(width / 2f, height - stroke.toPx() / 2)
            
            drawArcs(
                mainColor = mainColor,
                secondaryColor = secondaryColor,
                stroke = stroke,
                height = height,
                width = width
            )
            
            drawCenterCircle(
                secondaryColor = secondaryColor,
                width = width,
                height = height,
                stroke = stroke
            )
            
            drawNeedle(
                mainColor = mainColor,
                centerOffset = centerOffset,
                meterValue = meterValue
            )
        }
    }
}

private fun getMeterValue(inputPercentage: Int): Int = inputPercentage.coerceIn(0, 100)

private fun DrawScope.drawArcs(
    mainColor: Color,
    secondaryColor: Color,
    stroke: Dp,
    height: Float,
    width: Float
) {
    val arcSize = Size(width - stroke.toPx(), width - stroke.toPx())
    val topLeft = Offset(stroke.toPx() / 2, height / 2.5f - stroke.toPx() / 2)
    val strokeStyle = Stroke(width = stroke.toPx(), cap = StrokeCap.Butt)

    drawArc(
        color = mainColor,
        startAngle = ARC_START_ANGLE,
        sweepAngle = ARC_SWEEP_ANGLE,
        useCenter = false,
        topLeft = topLeft,
        size = arcSize,
        style = strokeStyle
    )
    
    drawArc(
        color = mainColor,
        startAngle = SECOND_ARC_START_ANGLE,
        sweepAngle = ARC_SWEEP_ANGLE,
        useCenter = false,
        topLeft = topLeft,
        size = arcSize,
        style = strokeStyle
    )
    
    drawArc(
        color = mainColor,
        startAngle = THIRD_ARC_START_ANGLE,
        sweepAngle = ARC_SWEEP_ANGLE,
        useCenter = false,
        topLeft = topLeft,
        size = arcSize,
        style = strokeStyle
    )
    
    drawArc(
        color = secondaryColor,
        startAngle = FOURTH_ARC_START_ANGLE,
        sweepAngle = FOURTH_ARC_SWEEP_ANGLE,
        useCenter = false,
        topLeft = topLeft,
        size = arcSize,
        style = strokeStyle
    )
}

private fun DrawScope.drawCenterCircle(
    secondaryColor: Color,
    width: Float,
    height: Float,
    stroke: Dp
) {
    drawCircle(
        color = secondaryColor,
        radius = CIRCLE_RADIUS,
        center = Offset(width / 2f, height - stroke.toPx() / 2),
        style = Stroke(width = CIRCLE_STROKE_WIDTH.dp.toPx())
    )
}

private fun DrawScope.drawNeedle(
    mainColor: Color,
    centerOffset: Offset,
    meterValue: Int
) {
    val needleAngle = ARC_START_ANGLE + (meterValue / 100f) * ARC_START_ANGLE
    val needlePath = Path().apply {
        val topX = centerOffset.x + NEEDLE_LENGTH * cos(toRadians(needleAngle.toDouble()).toFloat())
        val topY = centerOffset.y + NEEDLE_LENGTH * sin(toRadians(needleAngle.toDouble()).toFloat())
        val baseLeftX = centerOffset.x + NEEDLE_BASE_WIDTH * cos(toRadians((needleAngle - 90).toDouble()).toFloat())
        val baseLeftY = centerOffset.y + NEEDLE_BASE_WIDTH * sin(toRadians((needleAngle - 90).toDouble()).toFloat())
        val baseRightX = centerOffset.x + NEEDLE_BASE_WIDTH * cos(toRadians((needleAngle + 90).toDouble()).toFloat())
        val baseRightY = centerOffset.y + NEEDLE_BASE_WIDTH * sin(toRadians((needleAngle + 90).toDouble()).toFloat())

        moveTo(topX, topY)
        lineTo(baseLeftX, baseLeftY)
        lineTo(baseRightX, baseRightY)
        close()
    }

    drawPath(color = mainColor, path = needlePath)
}
private const val DEFAULT_INPUT_VALUE = 60
private const val DEFAULT_STROKE_DP = 16
private const val DEFAULT_SIZE_DP = 96
private const val NEEDLE_LENGTH = 80f
private const val NEEDLE_BASE_WIDTH = 15f
private const val ARC_START_ANGLE = 180f
private const val ARC_SWEEP_ANGLE = 40f
private const val SECOND_ARC_START_ANGLE = 225f
private const val THIRD_ARC_START_ANGLE = 270f
private const val FOURTH_ARC_START_ANGLE = 315f
private const val FOURTH_ARC_SWEEP_ANGLE = 45f
private const val CIRCLE_RADIUS = 8f
private const val CIRCLE_STROKE_WIDTH = 10f