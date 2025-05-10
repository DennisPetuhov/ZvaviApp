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
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Density

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme


enum class Trend {
    IMPROVING,
    DETERIORATING,
    NO_CHANGES
}

private const val ONE_THIRD: Float = 1f / 3f
private const val TWO_THIRDS: Float = 2f / 3f
private val CANVAS_SIZE: Dp = 60.dp
private val TREND_STROKE_WIDTH: Dp = 7.dp

@Composable
fun ProblemTrend(
    color: Color = ZvaviTheme.colors.backgroundBrandHigh,
    modifier: Modifier = Modifier,
    direction: Trend = Trend.IMPROVING
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.size(CANVAS_SIZE)
    ) {
        Canvas(
            modifier = Modifier.size(CANVAS_SIZE)
        ) {
            val trendShape: TrendShape = TrendShape()
            drawTrendPaths(
                trendShape = trendShape,
                size = size,
                color = color,
                density = this,
                direction = direction
            )
        }
    }
}

private fun DrawScope.drawTrendPaths(
    trendShape: TrendShape,
    size: Size,
    color: Color,
    direction: Trend,
    density: Density
) {
    val path = trendShape.drawTrend(size, direction)
    drawPath(path, color, style = Stroke(with(density) { TREND_STROKE_WIDTH.toPx() }))
}

class TrendShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(Path())
    }

    fun drawTrend(size: Size, direction: Trend): Path {
        val minDimension: Float = size.minDimension
        return when (direction) {
            Trend.NO_CHANGES -> Path().apply {
                moveTo(ONE_THIRD * minDimension, ONE_THIRD * minDimension)
                lineTo(TWO_THIRDS * minDimension, ONE_THIRD * minDimension)
                moveTo(ONE_THIRD * minDimension, TWO_THIRDS * minDimension)
                lineTo(TWO_THIRDS * minDimension, TWO_THIRDS * minDimension)
            }

            Trend.IMPROVING -> Path().apply {
                moveTo(TWO_THIRDS * minDimension, 0f)
                lineTo(minDimension, 0f)
                lineTo(minDimension, ONE_THIRD * minDimension)

                moveTo(ONE_THIRD * minDimension, ONE_THIRD * minDimension)
                lineTo(TWO_THIRDS * minDimension, ONE_THIRD * minDimension)
                lineTo(TWO_THIRDS * minDimension, TWO_THIRDS * minDimension)

                moveTo(0f, TWO_THIRDS * minDimension)
                lineTo(ONE_THIRD * minDimension, TWO_THIRDS * minDimension)
                lineTo(ONE_THIRD * minDimension, minDimension)
            }

            Trend.DETERIORATING -> Path().apply {
                moveTo(TWO_THIRDS * minDimension, 0f)
                lineTo(TWO_THIRDS * minDimension, ONE_THIRD * minDimension)
                lineTo(minDimension, ONE_THIRD * minDimension)

                moveTo(ONE_THIRD * minDimension, ONE_THIRD * minDimension)
                lineTo(ONE_THIRD * minDimension, TWO_THIRDS * minDimension)
                lineTo(TWO_THIRDS * minDimension, TWO_THIRDS * minDimension)

                moveTo(0f, TWO_THIRDS * minDimension)
                lineTo(0f, minDimension)
                lineTo(ONE_THIRD * minDimension, minDimension)
            }
        }
    }
}