package ge.avalanche.zvavi.bulletin.presentation.screen.views


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin


private object CompassConstants {
    const val SEGMENTS_COUNT = 8
    const val SEGMENT_ANGLE = 45.0
    const val INITIAL_ANGLE_OFFSET = -22.5
    const val RADIUS_DELIMITER_1 = 1.4f
    const val RADIUS_DELIMITER_2 = 2.4f
    const val RADIUS_DELIMITER_3 = 3.3f
    const val RADIUS_HEIGHT_DIVISOR = 10.5f
    const val COMPASS_RADIUS_DIVISOR = 2.5f
    const val TEXT_SIZE = 16f
    const val NORTH_OFFSET = 1f

    val LABELS = listOf("N", "NE", "E", "SE", "S", "SW", "W", "NW")
    val PRIMARY_INDICES = setOf(0, 1, 3, 5, 6)
    val COLORS = CompassColors(
        primary = Color.Blue,
        secondary = Color.White,
        accent = Color.Green,
        stroke = Color.White
    )
}

data class CompassColors(
    val primary: Color,
    val secondary: Color,
    val accent: Color,
    val stroke: Color
)

class ZvaviOctagon : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline = Outline.Rectangle(androidx.compose.ui.geometry.Rect(0f, 0f, size.width, size.height))

    fun createSegments(size: Size, radiusDelimiter: Float): List<Path> =
        (0 until CompassConstants.SEGMENTS_COUNT).map { i ->
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = radiusDelimiter * size.height / CompassConstants.RADIUS_HEIGHT_DIVISOR
            val angle1 = toRadians(i * CompassConstants.SEGMENT_ANGLE + CompassConstants.INITIAL_ANGLE_OFFSET)
            val angle2 = toRadians((i + 1) * CompassConstants.SEGMENT_ANGLE + CompassConstants.INITIAL_ANGLE_OFFSET)
            Path().apply {
                moveTo(centerX, centerY)
                lineTo(centerX + radius * cos(angle1).toFloat(), centerY + radius * sin(angle1).toFloat())
                lineTo(centerX + radius * cos(angle2).toFloat(), centerY + radius * sin(angle2).toFloat())
                close()
            }
        }
}

@Composable
fun CompassOctagon(
    modifier: Modifier = Modifier,
    colors: CompassColors = CompassConstants.COLORS,
    textStyle: TextStyle = ZvaviTheme.typography.text150Default
) {
    val textMeasurer = rememberTextMeasurer()
    Box(
        modifier = modifier.size(150.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(150.dp)) {
            drawCompassOctagon(size, textMeasurer, textStyle, colors)
        }
    }
}

private fun DrawScope.drawCompassOctagon(
    size: Size,
    textMeasurer: TextMeasurer,
    textStyle: TextStyle,
    colors: CompassColors
) {
    val shape = ZvaviOctagon()
    val centerX = size.width / 2
    val centerY = size.height / 2
    val radius = size.height / CompassConstants.COMPASS_RADIUS_DIVISOR

    listOf(
        CompassConstants.RADIUS_DELIMITER_3,
        CompassConstants.RADIUS_DELIMITER_2,
        CompassConstants.RADIUS_DELIMITER_1
    ).forEach { delimiter ->
        drawSegments(
            shape.createSegments(size, delimiter),
            colors
        ) { index ->
            if (CompassConstants.PRIMARY_INDICES.contains(index)) colors.primary else colors.accent
        }
    }

    drawLabels(textStyle, centerX, centerY, radius, textMeasurer, colors)
}

private fun DrawScope.drawSegments(
    segments: List<Path>,
    colors: CompassColors,
    colorSelector: (Int) -> Color
) {
    segments.forEachIndexed { index, segment ->
        drawPath(path = segment, color = colorSelector(index))
        drawPath(path = segment, color = colors.stroke, style = Stroke(width = 3.dp.toPx()))
    }
}

private fun DrawScope.drawLabels(
    textStyle: TextStyle,
    centerX: Float,
    centerY: Float,
    radius: Float,
    textMeasurer: TextMeasurer,
    colors: CompassColors
) {
    CompassConstants.LABELS.forEachIndexed { i, label ->
        val angle = toRadians(i * CompassConstants.SEGMENT_ANGLE - 90)
        val textX = centerX + radius * cos(angle).toFloat()
        val textY = centerY + radius * sin(angle).toFloat() +
            if (label == "N") CompassConstants.NORTH_OFFSET else 0f

        val layout = textMeasurer.measure(
            text = label,
            style = textStyle.copy(
                color = if (CompassConstants.PRIMARY_INDICES.contains(i)) colors.primary else colors.accent,
                fontSize = CompassConstants.TEXT_SIZE.sp
            )
        )
        val adjustedX = textX - layout.size.width / 2
        val adjustedY = textY - layout.size.height / 2

        drawText(
            textMeasurer = textMeasurer,
            text = label,
            topLeft = Offset(adjustedX, adjustedY),
            style = textStyle.copy(
                color = if (CompassConstants.PRIMARY_INDICES.contains(i)) colors.primary else colors.accent,
                fontSize = CompassConstants.TEXT_SIZE.sp
            )
        )
    }
}

private fun toRadians(degrees: Double): Double = degrees * (PI / 180)
