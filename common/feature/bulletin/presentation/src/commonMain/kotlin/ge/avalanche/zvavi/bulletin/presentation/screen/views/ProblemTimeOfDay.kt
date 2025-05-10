package ge.avalanche.zvavi.bulletin.presentation.screen.views

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

@Composable
fun ProblemTimeOfDay(
    modifier: Modifier,
    mainColor: Color = ZvaviTheme.colors.backgroundBrandHigh,
    secondaryColor: Color = ZvaviTheme.colors.overlayBrand,
    delimiterColor:Color=ZvaviTheme.colors.layerFloor1
) {
    Box(modifier = modifier.size(96.dp)) {
        Canvas(
            modifier = Modifier.size(96.dp)
        ) {
            drawMainClock(secondaryColor)
            drawCircle(
                color = mainColor,
                radius = size.minDimension / 2.4f,
                center = center
            )
            myDrawLines(delimiterColor)
        }
    }
}

fun DrawScope.myDrawLines(delimiterColor:Color) {
    val blueRadius = size.minDimension / 2
    val redRadius = size.minDimension / 2.4f
    val gap = blueRadius - redRadius
    val lineLength = gap *1.5f
    val startRadius = blueRadius - lineLength
    val center = center

    for (i in 0..11) {
        val angle = (i * 30f) * (PI / 180f).toFloat()
        val startX = center.x + startRadius * cos(angle)
        val startY = center.y + startRadius * sin(angle)
        val endX = center.x + blueRadius * cos(angle)
        val endY = center.y + blueRadius * sin(angle)

        drawLine(
            color = delimiterColor,
            start = Offset(startX, startY),
            end = Offset(endX, endY),
            strokeWidth = 5f
        )
    }
}

fun DrawScope.drawMainClock(mainColor:Color) {
    val radius = size.minDimension / 2
    val center = center
    drawCircle(
        color = mainColor,
        radius = radius,
        center = center
    )
}