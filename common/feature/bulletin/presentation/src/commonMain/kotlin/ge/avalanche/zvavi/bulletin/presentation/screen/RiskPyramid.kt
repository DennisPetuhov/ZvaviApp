package ge.avalanche.zvavi.bulletin.presentation.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import kotlin.math.PI
import kotlin.math.tan


private fun toRadians(degree: Double): Double = degree * (PI / 180)
private fun getTan30(): Float = tan(toRadians(30.0)).toFloat()

@Composable
internal fun PentagonView(
    canvasWidth: Dp = 225.dp,
    canvasHeight: Dp = 150.dp,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {}
) {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = modifier
            .wrapContentSize()
            .padding(bottom = ZvaviSpacing.spacing50),

        ) {
        Canvas(modifier = Modifier.size(canvasWidth, canvasHeight)) {
            val width = size.width
            val height = size.height
            val tan30 = getTan30()

            // Define pentagon points
            val a = Offset(height * tan30, 0f)
            val b = Offset(0f, height)
            val c = Offset(width, height)
            val d = Offset(width, height / 2)
            val e = Offset(width - tan30 * height / 2, 0f)

            val path = Path().apply {
                moveTo(a.x, a.y)
                lineTo(b.x, b.y)
                lineTo(c.x, c.y)
                lineTo(d.x, d.y)
                lineTo(e.x, e.y)
                close()
            }
            drawPath(path = path, color = Color.Red)
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(x = -(canvasWidth.value * 0.2f).dp, y = -canvasHeight / 6)
        ) {
            content.invoke()
        }
    }
}

@Composable
internal fun RectangleView(
    canvasWidth: Dp,
    canvasHeight: Dp,
    needCorrectionX: Boolean = false,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .wrapContentSize()
            .padding(bottom = ZvaviSpacing.spacing50),
    ) {
        Canvas(
            modifier = Modifier
                .size(canvasWidth, canvasHeight)
        ) {
            val width = size.width
            val height = size.height
            val tan30 = getTan30()

            // Define rectangle points
            val a = Offset(height * tan30, 0f)
            val b = Offset(0f, height)
            val c = Offset(width, 0f)
            val d = Offset(width, height)

            val path = Path().apply {
                moveTo(b.x, b.y)
                lineTo(d.x, d.y)
                lineTo(c.x, c.y)
                lineTo(a.x, a.y)
                close()
            }

            drawPath(path = path, color = Color.Yellow)
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxHeight()
                .align(Alignment.BottomCenter)
                .offset(
                    x = if (needCorrectionX) (0.2 * canvasWidth.value).dp
                    else (0.15 * canvasWidth.value).dp,
                    y = -canvasHeight / 3
                )
        ) {
            content.invoke()
        }
    }
}