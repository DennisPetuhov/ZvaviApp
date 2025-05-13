package ge.avalanche.zvavi.bulletin.presentation.screen.views.problem

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
private  val CANVAS_SIZE_DP: Dp = 60.dp
private val TREND_STROKE_WIDTH_DP: Dp = 7.dp

@Composable
fun ProblemTrend(
    color: Color = ZvaviTheme.colors.backgroundBrandHigh,
    modifier: Modifier = Modifier,
    direction: Trend = Trend.IMPROVING
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.size(CANVAS_SIZE_DP)
    ) {
        Canvas(modifier = Modifier.size(CANVAS_SIZE_DP)) {
            drawTrendPaths(
                trendShape = TrendShape(),
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
    drawPath(
        path = path,
        color = color,
        style = Stroke(width = with(density) { TREND_STROKE_WIDTH_DP.toPx() })
    )
}

class TrendShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline = Outline.Generic(Path())

    fun drawTrend(size: Size, direction: Trend): Path {
        val minDimension: Float = size.minDimension
        return when (direction) {
            Trend.NO_CHANGES -> createNoChangesPath(minDimension)
            Trend.IMPROVING -> createImprovingPath(minDimension)
            Trend.DETERIORATING -> createDeterioratingPath(minDimension)
        }
    }

    private fun createNoChangesPath(minDimension: Float): Path = Path().apply {
        moveTo(ONE_THIRD * minDimension, ONE_THIRD * minDimension)
        lineTo(TWO_THIRDS * minDimension, ONE_THIRD * minDimension)
        moveTo(ONE_THIRD * minDimension, TWO_THIRDS * minDimension)
        lineTo(TWO_THIRDS * minDimension, TWO_THIRDS * minDimension)
    }

    private fun createImprovingPath(minDimension: Float): Path = Path().apply {
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

    private fun createDeterioratingPath(minDimension: Float): Path = Path().apply {
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