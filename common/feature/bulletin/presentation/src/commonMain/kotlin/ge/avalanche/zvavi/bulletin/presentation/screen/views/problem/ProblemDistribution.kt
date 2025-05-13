package ge.avalanche.zvavi.bulletin.presentation.screen.views.problem

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme

private data class GridConfig(
    val circleRadius: Float,
    val gap: Float,
    val columns: Int,
    val rows: Int
) {
    val diameter: Float = circleRadius * 2
    val totalWidth: Float = columns * diameter + (columns - 1) * gap
    val totalHeight: Float = rows * diameter + (rows - 1) * gap
    val totalDots: Int = columns * rows
}

private fun DrawScope.calculateGridStartPosition(config: GridConfig): Pair<Float, Float> {
    val startX = (size.width - config.totalWidth) / 2 + config.circleRadius
    val startY = (size.height - config.totalHeight) / 2 + config.circleRadius
    return Pair(startX, startY)
}

private fun DrawScope.drawColoredCirclesGrid(
    bluePercentage: Float,
    mainColor: Color,
    secondaryColor: Color
) {
    val config = GridConfig(
        circleRadius = 4.dp.toPx(),
        gap = 8.dp.toPx(),
        columns = 7,
        rows = 4
    )
    val (startX, startY) = calculateGridStartPosition(config)
    
    val blueDotsCount = (config.totalDots * bluePercentage).toInt()
    val blueIndices = (0 until config.totalDots)
        .toMutableList()
        .apply { shuffle() }
        .take(blueDotsCount)
        .toSet()

    var dotIndex = 0
    for (row in 0 until config.rows) {
        for (col in 0 until config.columns) {
            val x = startX + col * (config.diameter + config.gap)
            val y = startY + row * (config.diameter + config.gap)
            val color = if (blueIndices.contains(dotIndex)) mainColor else secondaryColor
            
            drawCircle(
                color = color,
                radius = config.circleRadius,
                center = Offset(x, y)
            )
            dotIndex++
        }
    }
}

@Composable
internal fun ColoredCirclesGrid(
    bluePercentage: Float,
    mainColor: Color = ZvaviTheme.colors.backgroundBrandHigh,
    secondaryColor: Color = ZvaviTheme.colors.overlayBrand,
    modifier: Modifier = Modifier
) {
    val normalizedPercentage = bluePercentage.coerceIn(0f, 1f)
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .width(104.dp)
            .height(56.dp)
    ) {
        Canvas(
            modifier = Modifier
                .width(104.dp)
                .height(56.dp)
        ) {
            drawColoredCirclesGrid(
                normalizedPercentage,
                mainColor = mainColor,
                secondaryColor = secondaryColor
            )
        }
    }
}