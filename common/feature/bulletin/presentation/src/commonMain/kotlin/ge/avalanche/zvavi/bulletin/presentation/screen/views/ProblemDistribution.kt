package ge.avalanche.zvavi.bulletin.presentation.screen.views

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
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

private fun DrawScope.drawRedCirclesGrid() {
    val circleRadius = 4.dp.toPx()
    val gap = 8.dp.toPx()
    val columns = 7
    val rows = 4

    val diameter = circleRadius * 2
    val totalWidth = columns * diameter + (columns - 1) * gap
    val totalHeight = rows * diameter + (rows - 1) * gap

    val startX = (size.width - totalWidth) / 2 + circleRadius
    val startY = (size.height - totalHeight) / 2 + circleRadius

    for (row in 0 until rows) {
        for (col in 0 until columns) {
            val x = startX + col * (diameter + gap)
            val y = startY + row * (diameter + gap)
            drawCircle(
                color = Color.Red,
                radius = circleRadius,
                center = Offset(x, y)
            )
        }
    }
}

private fun DrawScope.drawColoredCirclesGrid(
    bluePercentage: Float,
    mainColor: Color,
    secondaryColor: Color
) {
    val circleRadius = 4.dp.toPx()
    val gap = 8.dp.toPx()
    val columns = 7
    val rows = 4
    val totalDots = columns * rows

    val diameter = circleRadius * 2
    val totalWidth = columns * diameter + (columns - 1) * gap
    val totalHeight = rows * diameter + (rows - 1) * gap

    val startX = (size.width - totalWidth) / 2 + circleRadius
    val startY = (size.height - totalHeight) / 2 + circleRadius

    // Create a list of indices and shuffle it
    val indices = (0 until totalDots).toMutableList()
    indices.shuffle()

    // Calculate how many dots should be blue
    val blueDotsCount = (totalDots * bluePercentage).toInt()

    // Create a set of indices that will be blue
    val blueIndices = indices.take(blueDotsCount).toSet()

    var dotIndex = 0
    for (row in 0 until rows) {
        for (col in 0 until columns) {
            val x = startX + col * (diameter + gap)
            val y = startY + row * (diameter + gap)

            // Determine color based on whether this dot's index is in the blue set
            val color = if (blueIndices.contains(dotIndex)) mainColor else secondaryColor

            drawCircle(
                color = color,
                radius = circleRadius,
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