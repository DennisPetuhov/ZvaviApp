package ge.avalanche.zvavi.bulletin.presentation.screen.views

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.bulletin.presentation.screen.utill.getTan45
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme


private val CANVAS_SIZE: Dp = 96.dp

@Composable
fun ZvaviProblemSize(
    color: Color = ZvaviTheme.colors.backgroundBrandHigh,
    modifier: Modifier = Modifier,
) {
    Box(contentAlignment = Alignment.CenterEnd,
        modifier = modifier.size(CANVAS_SIZE)) {
        Canvas(
            modifier = Modifier.size(CANVAS_SIZE)
        ) {
            val problemSizeShape = ProblemSizeShape()
            drawPath(
                problemSizeShape.drawFirstLevel(size = size, color = color, density= this,quantity = 5),
                color = color
            )
            problemSizeShape.drawOtherLevels(
                size = size,
                quantity = 5,
                density = this
            ).forEach { path ->
                drawPath(path = path, color = color, style = Fill)
            }
        }
    }
}


class ProblemSizeShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(Path())
    }

    fun drawFirstLevel(
        size: Size,
        color: Color,
        quantity: Int,
        density: Density,
        gap: Dp = 4.dp
    ): Path {

        val gapPx = with(density) { gap.toPx() }
        val totalGap = gapPx * (quantity - 1)
        val minDimension: Float = size.minDimension
        val levelWidth = (minDimension - totalGap) / quantity
        val x = levelWidth
        return Path().apply {
            moveTo(0f, minDimension)
            lineTo(x, minDimension - getTan45() * x)
            lineTo(x, minDimension)
            close()
        }
    }

    fun drawOtherLevels(
        size: Size,
        quantity: Int,
        gap: Dp = 4.dp,
        density: Density
    ): List<Path> {
        val minDimension = size.minDimension
        val gapPx = with(density) { gap.toPx() }
        val totalGap = gapPx * (quantity - 1)
        val levelWidth = (minDimension - totalGap) / quantity
        return (1 until quantity).map { i ->
            val x1 = i * (levelWidth + gapPx)
            val x2 = x1
            val x3 = x1 + levelWidth
            Path().apply {
                moveTo(x1, minDimension)
                lineTo(x2, minDimension - (getTan45() * x1))
                lineTo(x3, minDimension - (getTan45() * x3))
                lineTo(x3, minDimension)
                close()
            }
        }
    }
}