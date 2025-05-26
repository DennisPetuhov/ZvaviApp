package ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.views

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import kotlin.math.PI
import kotlin.math.tan

/**
 * Constants for the RiskPyramid component.
 * Contains all configuration values for the pyramid visualization.
 */
private object RiskPyramidConstants {
    /** Conversion factor from degrees to radians */
    const val DEGREE_TO_RADIANS: Double = PI / 180
    
    /** Angle of the pentagon in degrees */
    const val PENTAGON_ANGLE: Double = 30.0
    
    /** X-axis offset multiplier for pentagon content */
    const val PENTAGON_CONTENT_OFFSET_X: Float = 0.2f
    
    /** Y-axis offset divisor for pentagon content */
    const val PENTAGON_CONTENT_OFFSET_Y: Float = 6f
    
    /** Normal X-axis offset multiplier for rectangle content */
    const val RECTANGLE_CONTENT_OFFSET_X_NORMAL: Float = 0.15f
    
    /** Corrected X-axis offset multiplier for rectangle content */
    const val RECTANGLE_CONTENT_OFFSET_X_CORRECTED: Float = 0.2f
    
    /** Y-axis offset divisor for rectangle content */
    const val RECTANGLE_CONTENT_OFFSET_Y: Float = 3f
}

/**
 * Converts degrees to radians.
 *
 * @param degree The angle in degrees
 * @return The angle in radians
 */
private fun toRadians(degree: Double): Double = degree * RiskPyramidConstants.DEGREE_TO_RADIANS

/**
 * Calculates the tangent of 30 degrees.
 *
 * @return The tangent value as Float
 */
private fun getTan30(): Float = tan(toRadians(RiskPyramidConstants.PENTAGON_ANGLE)).toFloat()

/**
 * A composable that draws a pentagon shape with customizable content.
 * Used to represent risk levels in the avalanche risk pyramid.
 *
 * @param canvasWidth The width of the canvas
 * @param canvasHeight The height of the canvas
 * @param color The color of the pentagon
 * @param modifier Additional modifier for the composable
 * @param content The content to be displayed inside the pentagon
 */
@Composable
internal fun PentagonView(
    canvasWidth: Dp,
    canvasHeight: Dp,
    color: Color,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {}
) {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = modifier
            .wrapContentSize()
            .padding(bottom = ZvaviSpacing.spacing50)
    ) {
        Canvas(modifier = Modifier.size(canvasWidth, canvasHeight)) {
            val width: Float = size.width
            val height: Float = size.height
            val tan30: Float = getTan30()

            val path: Path = Path().apply {
                moveTo(height * tan30, 0f)  // Point A
                lineTo(0f, height)          // Point B
                lineTo(width, height)       // Point C
                lineTo(width, height / 2)   // Point D
                lineTo(width - tan30 * height / 2, 0f)  // Point E
                close()
            }
            drawPath(path = path, color = color)
        }
        
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(
                    x = -(canvasWidth.value * RiskPyramidConstants.PENTAGON_CONTENT_OFFSET_X).dp,
                    y = -canvasHeight / RiskPyramidConstants.PENTAGON_CONTENT_OFFSET_Y
                )
        ) {
            content()
        }
    }
}

/**
 * A composable that draws a rectangle shape with customizable content.
 * Used to represent risk levels in the avalanche risk pyramid.
 *
 * @param canvasWidth The width of the canvas
 * @param canvasHeight The height of the canvas
 * @param color The color of the rectangle
 * @param needCorrectionX Whether to apply X-axis correction for content positioning
 * @param content The content to be displayed inside the rectangle
 * @param modifier Additional modifier for the composable
 */
@Composable
internal fun RectangleView(
    canvasWidth: Dp,
    canvasHeight: Dp,
    color: Color,
    needCorrectionX: Boolean = false,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .wrapContentSize()
            .padding(bottom = ZvaviSpacing.spacing50)
    ) {
        Canvas(modifier = Modifier.size(canvasWidth, canvasHeight)) {
            val width: Float = size.width
            val height: Float = size.height
            val tan30: Float = getTan30()

            val path: Path = Path().apply {
                moveTo(0f, height)          // Point B
                lineTo(width, height)       // Point D
                lineTo(width, 0f)           // Point C
                lineTo(height * tan30, 0f)  // Point A
                close()
            }
            drawPath(path = path, color = color)
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.BottomCenter)
                .offset(
                    x = if (needCorrectionX) 
                        (RiskPyramidConstants.RECTANGLE_CONTENT_OFFSET_X_CORRECTED * canvasWidth.value).dp
                    else 
                        (RiskPyramidConstants.RECTANGLE_CONTENT_OFFSET_X_NORMAL * canvasWidth.value).dp,
                    y = -canvasHeight / RiskPyramidConstants.RECTANGLE_CONTENT_OFFSET_Y
                )
        ) {
            content()
        }
    }
}