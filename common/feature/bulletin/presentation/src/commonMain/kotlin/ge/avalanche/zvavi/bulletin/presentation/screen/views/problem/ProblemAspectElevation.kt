package ge.avalanche.zvavi.bulletin.presentation.screen.views.problem

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.bulletin.presentation.screen.utill.CompassRules
import ge.avalanche.zvavi.bulletin.presentation.screen.utill.toRadians
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun ProblemAspectElevation(
    modifier: Modifier = Modifier,
    innerActiveSegments: List<Int> = listOf<Int>(1, 3, 5, 7, 8),
    mediumActiveSegments: List<Int> = listOf<Int>(1, 2, 4, 8),
    outerActiveSegments: List<Int> = listOf<Int>(1, 3, 5, 6, 7),
    textMeasurer: TextMeasurer = rememberTextMeasurer(),
    mainColor: Color = ZvaviTheme.colors.backgroundBrandHigh,
    secondaryColor: Color = ZvaviTheme.colors.overlayBrand,
    labelMainColor: Color = ZvaviTheme.colors.contentBrandPrimary,
    labelSecondaryColor: Color = ZvaviTheme.colors.contentNeutralTertiary,
    textStyle: TextStyle = ZvaviTheme.typography.text150Accent
) {
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = modifier.size(110.dp)
    ) {
        Canvas(
            modifier = Modifier.size(110.dp)
        ) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = size.width.coerceAtMost(size.height) / 2.37f

            // Calculate points for each level with gaps
            val innerRadius = radius * 0.4f
            val mediumRadius = radius * 0.7f
            val outerRadius = radius * 1f

            // Convert 1dp to pixels for the gap
            val gapPixels = 1.dp.toPx()

            // Draw segments for each level
            for (i in 0..7) {
                val segmentNumber = i + 1

                // Add 30 degrees (PI/6) to rotate clockwise
                val rotationOffset = PI / 7

                // Inner trapezoids use 35 degrees with 10-degree gap
                val innerStartAngle = i * (45.0 * PI / 180.0) + rotationOffset
                val innerEndAngle = innerStartAngle + (35.0 * PI / 180.0)

                val segmentStartAngle = i * (45.0 * PI / 180.0) + rotationOffset
                val segmentEndAngle = segmentStartAngle + (40.0 * PI / 180.0)

                // Inner level (trapezoids)
                val innerPath = Path().apply {
                    moveTo(
                        centerX + (innerRadius * 0.3f) * cos(innerStartAngle).toFloat(),
                        centerY + (innerRadius * 0.3f) * sin(innerStartAngle).toFloat()
                    )
                    lineTo(
                        centerX + (innerRadius - gapPixels) * cos(innerStartAngle).toFloat(),
                        centerY + (innerRadius - gapPixels) * sin(innerStartAngle).toFloat()
                    )
                    lineTo(
                        centerX + (innerRadius - gapPixels) * cos(innerEndAngle).toFloat(),
                        centerY + (innerRadius - gapPixels) * sin(innerEndAngle).toFloat()
                    )
                    lineTo(
                        centerX + (innerRadius * 0.3f) * cos(innerEndAngle).toFloat(),
                        centerY + (innerRadius * 0.3f) * sin(innerEndAngle).toFloat()
                    )
                    close()
                }
                drawPath(
                    innerPath,
                    if (innerActiveSegments.contains(segmentNumber)) mainColor else secondaryColor
                )

                // Medium level (trapezoids)
                val mediumPath = Path().apply {
                    moveTo(
                        centerX + (innerRadius + gapPixels) * cos(segmentStartAngle).toFloat(),
                        centerY + (innerRadius + gapPixels) * sin(segmentStartAngle).toFloat()
                    )
                    lineTo(
                        centerX + (mediumRadius - gapPixels) * cos(segmentStartAngle).toFloat(),
                        centerY + (mediumRadius - gapPixels) * sin(segmentStartAngle).toFloat()
                    )
                    lineTo(
                        centerX + (mediumRadius - gapPixels) * cos(segmentEndAngle).toFloat(),
                        centerY + (mediumRadius - gapPixels) * sin(segmentEndAngle).toFloat()
                    )
                    lineTo(
                        centerX + (innerRadius + gapPixels) * cos(segmentEndAngle).toFloat(),
                        centerY + (innerRadius + gapPixels) * sin(segmentEndAngle).toFloat()
                    )
                    close()
                }
                drawPath(
                    mediumPath,
                    if (mediumActiveSegments.contains(segmentNumber)) mainColor else secondaryColor
                )

                // Outer level (trapezoids)
                val outerPath = Path().apply {
                    moveTo(
                        centerX + (mediumRadius + gapPixels) * cos(segmentStartAngle).toFloat(),
                        centerY + (mediumRadius + gapPixels) * sin(segmentStartAngle).toFloat()
                    )
                    lineTo(
                        centerX + outerRadius * cos(segmentStartAngle).toFloat(),
                        centerY + outerRadius * sin(segmentStartAngle).toFloat()
                    )
                    lineTo(
                        centerX + outerRadius * cos(segmentEndAngle).toFloat(),
                        centerY + outerRadius * sin(segmentEndAngle).toFloat()
                    )
                    lineTo(
                        centerX + (mediumRadius + gapPixels) * cos(segmentEndAngle).toFloat(),
                        centerY + (mediumRadius + gapPixels) * sin(segmentEndAngle).toFloat()
                    )
                    close()
                }
                drawPath(
                    outerPath,
                    if (outerActiveSegments.contains(segmentNumber)) mainColor else secondaryColor
                )
            }
            drawLabels(
                textStyle = textStyle,
                centerX = centerX,
                centerY = centerY,
                radius = radius + 10f,
                textMeasurer = textMeasurer,
                labelMainColor = labelMainColor,
                labelSecondaryColor = labelSecondaryColor
            )

        }
    }
}

private fun DrawScope.drawLabels(
    labelMainColor: Color,
    labelSecondaryColor: Color,
    textStyle: TextStyle,
    centerX: Float,
    centerY: Float,
    radius: Float,
    textMeasurer: TextMeasurer,
) {
    CompassRules.LABELS.forEachIndexed { i, label ->
        val angle = toRadians(i * CompassRules.SEGMENT_ANGLE - 90)
        val textX = centerX + radius * cos(angle).toFloat()
        val textY = centerY + radius * sin(angle).toFloat() +
                if (label == "N") CompassRules.NORTH_OFFSET else 0f

        val layout = textMeasurer.measure(
            text = label,
        )
        val adjustedX = textX - layout.size.width / 2
        val adjustedY = textY - layout.size.height / 2

        drawText(
            textMeasurer = textMeasurer,
            text = label,
            topLeft = Offset(adjustedX, adjustedY),
            style = textStyle.copy(
                color = if (CompassRules.PRIMARY_INDICES.contains(i)) labelMainColor else labelSecondaryColor,
            )
        )
    }
}


