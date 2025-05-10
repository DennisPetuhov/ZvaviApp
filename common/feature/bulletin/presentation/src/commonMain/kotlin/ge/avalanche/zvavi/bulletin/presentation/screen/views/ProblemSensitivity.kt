package ge.avalanche.zvavi.bulletin.presentation.screen.views

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
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.bulletin.presentation.screen.utill.toRadians
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun ProblemSensitivity(
    innerGradient: Color = Color.Yellow,
    trackColor: Color = Color.Blue,
    progressColors: Color = Color.Green,
    inputValue: Int = 40,
    stroke:Dp = 16.dp,
    modifier: Modifier = Modifier,
) {
    val meterValue = getMeterValue(inputValue)
    Box(modifier = modifier.size(96.dp, 56.dp)) {
        Canvas(modifier = Modifier.size(width = 96.dp, height = 56.dp)) {
            val sweepAngle = 360f
            val fillSwipeAngle = (meterValue / 100f) * sweepAngle
            val height = size.height
            val width = size.width
            val startAngle = 180f
//            val arcHeight = height - 20.dp.toPx()
            val arcHeight = height
            val arcWidth = width

            drawArc(
                color = trackColor,
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = true,
//                topLeft = Offset((width - height + 60f) / 2f, (height - arcHeight) / 2f),
                topLeft = Offset(
                    0f, // Center horizontally
                    0f     // Align bottom of the arc with the canvas bottom
                ),
                size = Size(arcHeight, arcWidth),
                style = Stroke(width = 50f, cap = StrokeCap.Round)
            )
//            drawCircle(
//                color = Color.Blue,
//                radius = 24f,
//                center = Offset(width / 2f, height / 2.09f),
//                style = Stroke(width = 10.dp.toPx())
//
//            )

//            drawArc(
//                color = Color.Cyan,
//                startAngle = startAngle,
//                sweepAngle = fillSwipeAngle,
//                useCenter = false,
//                topLeft = Offset((width - height + 60f) / 2f, (height - arcHeight) / 2),
//                size = Size(arcHeight, arcHeight),
//                style = Stroke(width = 50f, cap = StrokeCap.Round)
//            )
            val centerOffset = Offset(width / 2f, height / 2.09f)
//            drawCircle(
//                Brush.radialGradient(
//                    listOf(
//                        innerGradient.copy(alpha = 0.2f),
//                        Color.Transparent
//                    )
//                ), width / 2f
//            )
//            drawCircle(Color.White, 24f, centerOffset)

            // Calculate needle angle based on inputValue
            val needleAngle = (meterValue / 100f) * sweepAngle + startAngle
            val needleLength = 60f // Adjust this value to control needle length
            val needleBaseWidth = 10f // Adjust this value to control the base width


            val needlePath = Path().apply {
                // Calculate the top point of the needle
                val topX = centerOffset.x + needleLength * cos(
                    toRadians(needleAngle.toDouble()).toFloat()
                )
                val topY = centerOffset.y + needleLength * sin(
                    toRadians(needleAngle.toDouble()).toFloat()
                )

                // Calculate the base points of the needle
                val baseLeftX = centerOffset.x + needleBaseWidth * cos(
                    toRadians((needleAngle - 90).toDouble()).toFloat()
                )
                val baseLeftY = centerOffset.y + needleBaseWidth * sin(
                    toRadians((needleAngle - 90).toDouble()).toFloat()
                )
                val baseRightX = centerOffset.x + needleBaseWidth * cos(
                    toRadians((needleAngle + 90).toDouble()).toFloat()
                )
                val baseRightY = centerOffset.y + needleBaseWidth * sin(
                    toRadians((needleAngle + 90).toDouble()).toFloat()
                )

                moveTo(topX, topY)
                lineTo(baseLeftX, baseLeftY)
                lineTo(baseRightX, baseRightY)
                close()
            }

            drawPath(
                color = Color.White,
                path = needlePath
            )
        }
    }
}


private fun getMeterValue(inputPercentage: Int): Int {
    return if (inputPercentage < 0) {
        0
    } else if (inputPercentage > 100) {
        100
    } else {
        inputPercentage
    }
}
