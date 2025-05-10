package ge.avalanche.zvavi.bulletin.presentation.screen.views


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.bulletin.presentation.screen.utill.toRadians
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import kotlin.math.cos
import kotlin.math.sin


private object CompassConstants {
    const val SEGMENTS_COUNT = 8
    const val SEGMENT_ANGLE = 45.0
    const val INITIAL_ANGLE_OFFSET = -22.5
    const val RADIUS_DELIMITER_1 = 0.2f
    const val RADIUS_DELIMITER_2 = 0.4f
    const val RADIUS_DELIMITER_3 = 0.8f
    const val COMPASS_RADIUS_DIVISOR = 2.5f
    const val NORTH_OFFSET = 1f

    val LABELS = listOf("N", "NE", "E", "SE", "S", "SW", "W", "NW")
    val PRIMARY_INDICES = setOf(0, 1, 3, 5, 6)

}


@Composable
fun ProblemAspectElevation(
    modifier: Modifier = Modifier,
    mainColor: Color = ZvaviTheme.colors.backgroundBrandHigh,
    secondaryColor: Color = ZvaviTheme.colors.overlayBrand,
    strokeColor: Color = ZvaviTheme.colors.overlayNeutral,
    textStyle: TextStyle = ZvaviTheme.typography.text150Accent
) {
    val textMeasurer = rememberTextMeasurer()
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.CenterEnd
    ) {
        Canvas(
            modifier = Modifier
                .size(120.dp)
                .aspectRatio(1f)
                .align(Alignment.Center)
        ) {
            drawOctagon(
                size,
                textMeasurer,
                textStyle,
                mainColor = mainColor,
                secondaryColor = secondaryColor,
                strokeColor = strokeColor
            )
        }
    }
}

private fun DrawScope.drawOctagon(
    size: Size,
    textMeasurer: TextMeasurer,
    textStyle: TextStyle,
    mainColor: Color,
    secondaryColor: Color,
    strokeColor: Color,
) {
    val shape = OctagonShape()
    val centerX = size.width / 2
    val centerY = size.height / 2
    val radius = size.height / 2

    listOf(    CompassConstants.RADIUS_DELIMITER_3,
        CompassConstants.RADIUS_DELIMITER_2,
        CompassConstants.RADIUS_DELIMITER_1
    ).forEach { delimiter ->
        drawSegments(
            segments = shape.createSegments(size, delimiter),
            strokeColor = strokeColor,

            ) { index ->
            if (CompassConstants.PRIMARY_INDICES.contains(index)) mainColor else secondaryColor
        }
    }

//    drawLabels(textStyle, centerX, centerY, radius, textMeasurer, mainColor, secondaryColor)
}

private fun DrawScope.drawSegments(
    segments: List<Path>,
    strokeColor: Color,
    colorSelector: (Int) -> Color
) {
    segments.forEachIndexed { index, segment ->
        drawPath(
            path = segment,
            color = colorSelector(index),
            style = Fill
        )
        drawPath(
            path = segment,
            color = strokeColor,
//            color = Color.White,
            style = Stroke(width = 2.dp.toPx())
        )
    }
}

//private fun DrawScope.drawLabels(
//    textStyle: TextStyle,
//    centerX: Float,
//    centerY: Float,
//    radius: Float,
//    textMeasurer: TextMeasurer,
//    mainColor: Color,
//    secondaryColor: Color,
//) {
//    CompassConstants.LABELS.forEachIndexed { i, label ->
//        val angle = toRadians(i * CompassConstants.SEGMENT_ANGLE - 90)
//        val textX = centerX + radius * cos(angle).toFloat()
//        val textY = centerY + radius * sin(angle).toFloat() +
//                if (label == "N") CompassConstants.NORTH_OFFSET else 0f
//
//        val layout = textMeasurer.measure(
//            text = label,
//            style = textStyle.copy(
//                color = if (CompassConstants.PRIMARY_INDICES.contains(i)) mainColor else secondaryColor,
//
//                )
//        )
//        val adjustedX = textX - layout.size.width / 2
//        val adjustedY = textY - layout.size.height / 2
//
//        drawText(
//            textMeasurer = textMeasurer,
//            text = label,
//            topLeft = Offset(adjustedX, adjustedY),
//            style = textStyle
//        )
//    }
//}

class OctagonShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline =
        Outline.Rectangle(Rect(0f, 0f, size.width, size.height))

    fun createSegments(size: Size, radiusDelimiter: Float): List<Path> =
        (0 until CompassConstants.SEGMENTS_COUNT).map { i ->
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = radiusDelimiter * size.height/2
            val angle1 =
                toRadians(i * CompassConstants.SEGMENT_ANGLE + CompassConstants.INITIAL_ANGLE_OFFSET)
            val angle2 =
                toRadians((i + 1) * CompassConstants.SEGMENT_ANGLE + CompassConstants.INITIAL_ANGLE_OFFSET)
            Path().apply {
                moveTo(centerX, centerY)
                lineTo(
                    centerX + radius * cos(angle1).toFloat(),
                    centerY + radius * sin(angle1).toFloat()
                )
                lineTo(
                    centerX + radius * cos(angle2).toFloat(),
                    centerY + radius * sin(angle2).toFloat()
                )
                close()
            }
        }
}