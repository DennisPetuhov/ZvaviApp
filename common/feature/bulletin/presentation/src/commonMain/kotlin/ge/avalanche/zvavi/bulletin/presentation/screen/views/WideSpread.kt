package ge.avalanche.zvavi.bulletin.presentation.screen.views

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp

class WideSpread {
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

    @Composable
    fun RedCirclesGrid() {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            drawRedCirclesGrid()
        }
    }
}