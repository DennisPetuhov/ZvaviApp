package ge.avalanche.zvavi.bulletin.presentation.screen.views

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import org.jetbrains.skia.Font
import org.jetbrains.skia.Paint
import org.jetbrains.skia.Typeface

actual fun DrawScope.drawPlatformText(
    text: String,
    x: Float,
    y: Float,
    color: Color,
    fontSize: Float
) {
    drawContext.canvas.nativeCanvas.apply {
        val paint = Paint().apply {
            this.color = color.toArgb()
            this.textSize = fontSize
            this.textAlign = Paint.Align.CENTER
        }
        val font = Font(Typeface.makeDefault(), fontSize)
        drawString(text, x, y, font, paint)
    }
} 