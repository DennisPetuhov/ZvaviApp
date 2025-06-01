package ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.views.problem

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.bulletin.api.models.Aspects
import ge.avalanche.zvavi.bulletin.api.models.AvalancheProblem
import ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.views.problem.ProblemAspectElevationConstants.CONTAINER_HEIGHT_DP
import ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.views.problem.ProblemAspectElevationConstants.CONTAINER_WIDTH_DP
import ge.avalanche.zvavi.bulletin.presentation.screen.utill.CompassRules
import ge.avalanche.zvavi.bulletin.presentation.screen.utill.toRadians
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

/**
 * Constants for the ProblemAspectElevation component.
 * Contains all configuration values for the compass visualization.
 */
private object ProblemAspectElevationConstants {
    /** Multiplier for the main radius */
    const val RADIUS_MULTIPLIER: Float = 2.37f
    
    /** Multiplier for the inner radius */
    const val INNER_RADIUS_MULTIPLIER: Float = 0.4f
    
    /** Multiplier for the medium radius */
    const val MEDIUM_RADIUS_MULTIPLIER: Float = 0.7f
    
    /** Multiplier for the outer radius */
    const val OUTER_RADIUS_MULTIPLIER: Float = 1.0f
    
    /** Multiplier for the inner segment */
    const val INNER_SEGMENT_MULTIPLIER: Float = 0.3f
    
    /** Angle of each segment in degrees */
    const val SEGMENT_ANGLE_DEGREES: Double = 45.0
    
    /** Angle of inner segment in degrees */
    const val INNER_SEGMENT_ANGLE_DEGREES: Double = 35.0
    
    /** Angle of segment with gap in degrees */
    const val SEGMENT_ANGLE_DEGREES_WITH_GAP: Double = 40.0
    
    /** Rotation offset in radians */
    const val ROTATION_OFFSET_RADIANS: Double = PI / 7
    
    /** Offset for labels in pixels */
    const val LABEL_OFFSET: Float = 10f
    
    /** Gap between segments in dp */
    const val GAP_PIXELS_DP: Int = 1
    
    /** Total number of segments */
    const val TOTAL_SEGMENTS: Int = 8
    
    /** Offset for segment index */
    const val SEGMENT_INDEX_OFFSET: Int = 1
    /** Width of the container in dp */
    const val CONTAINER_WIDTH_DP: Int = 120

    /** Height of the container in dp */
    const val CONTAINER_HEIGHT_DP: Int = 100
    /** Size of the compass in dp */
    const val CANVAS_SIZE_DP: Int = 100

}

/**
 * A composable that displays a compass-like visualization for avalanche problem aspects and elevations.
 * Shows different segments for high alpine, alpine, and sub-alpine areas.
 *
 * @param problem The avalanche problem data
 * @param modifier Modifier for the composable
 * @param textMeasurer TextMeasurer for rendering labels
 * @param mainColor The primary color for active segments
 * @param secondaryColor The color for inactive segments
 * @param labelPrimaryColor The color for active labels
 * @param labelSecondaryColor The color for inactive labels
 * @param textStyle The text style for labels
 */
@Composable
fun ProblemAspectElevation(
    problem: AvalancheProblem,
    modifier: Modifier = Modifier,
    textMeasurer: TextMeasurer = rememberTextMeasurer(),
    mainColor: Color = ZvaviTheme.colors.backgroundBrandHigh,
    secondaryColor: Color = ZvaviTheme.colors.overlayBrand,
    labelPrimaryColor: Color = ZvaviTheme.colors.contentBrandPrimary,
    labelSecondaryColor: Color = ZvaviTheme.colors.contentNeutralTertiary,
    textStyle: TextStyle = ZvaviTheme.typography.text150Accent
) {
    Box(contentAlignment = Alignment.BottomEnd,
        modifier = modifier
            .width(CONTAINER_WIDTH_DP.dp)
            .height(CONTAINER_HEIGHT_DP.dp)
    ) {
        Canvas(
            modifier = Modifier.size(ProblemAspectElevationConstants.CANVAS_SIZE_DP.dp)
        ) {
            val centerX: Float = size.width / 2
            val centerY: Float = size.height / 2
            val radius: Float = size.width.coerceAtMost(size.height) / ProblemAspectElevationConstants.RADIUS_MULTIPLIER
            val gapPixels: Float = ProblemAspectElevationConstants.GAP_PIXELS_DP.dp.toPx()

            drawCompassSegments(
                centerX = centerX,
                centerY = centerY,
                radius = radius,
                gapPixels = gapPixels,
                problem = problem,
                mainColor = mainColor,
                secondaryColor = secondaryColor
            )

            drawLabels(
                aspects = problem.aspects,
                textStyle = textStyle,
                centerX = centerX,
                centerY = centerY,
                radius = radius + ProblemAspectElevationConstants.LABEL_OFFSET,
                textMeasurer = textMeasurer,
                labelPrimaryColor = labelPrimaryColor,
                labelSecondaryColor = labelSecondaryColor
            )
        }
    }
}

/**
 * Draws the compass segments for different elevations.
 *
 * @param centerX The x-coordinate of the center
 * @param centerY The y-coordinate of the center
 * @param radius The base radius
 * @param gapPixels The gap between segments in pixels
 * @param problem The avalanche problem data
 * @param mainColor The primary color for active segments
 * @param secondaryColor The color for inactive segments
 */
private fun DrawScope.drawCompassSegments(
    centerX: Float,
    centerY: Float,
    radius: Float,
    gapPixels: Float,
    problem: AvalancheProblem,
    mainColor: Color,
    secondaryColor: Color
) {
    val innerRadius: Float = radius * ProblemAspectElevationConstants.INNER_RADIUS_MULTIPLIER
    val mediumRadius: Float = radius * ProblemAspectElevationConstants.MEDIUM_RADIUS_MULTIPLIER
    val outerRadius: Float = radius * ProblemAspectElevationConstants.OUTER_RADIUS_MULTIPLIER

    for (i in 0 until ProblemAspectElevationConstants.TOTAL_SEGMENTS) {
        val segmentNumber: Int = i + ProblemAspectElevationConstants.SEGMENT_INDEX_OFFSET
        val segmentStartAngle: Double = i * (ProblemAspectElevationConstants.SEGMENT_ANGLE_DEGREES * PI / 180.0) + 
            ProblemAspectElevationConstants.ROTATION_OFFSET_RADIANS
        val innerEndAngle: Double = segmentStartAngle + (ProblemAspectElevationConstants.INNER_SEGMENT_ANGLE_DEGREES * PI / 180.0)
        val segmentEndAngle: Double = segmentStartAngle + (ProblemAspectElevationConstants.SEGMENT_ANGLE_DEGREES_WITH_GAP * PI / 180.0)

        drawInnerSegment(
            centerX = centerX,
            centerY = centerY,
            innerRadius = innerRadius,
            gapPixels = gapPixels,
            segmentStartAngle = segmentStartAngle,
            innerEndAngle = innerEndAngle,
            segmentNumber = segmentNumber,
            problem = problem,
            mainColor = mainColor,
            secondaryColor = secondaryColor
        )

        drawMediumSegment(
            centerX = centerX,
            centerY = centerY,
            innerRadius = innerRadius,
            mediumRadius = mediumRadius,
            gapPixels = gapPixels,
            segmentStartAngle = segmentStartAngle,
            segmentEndAngle = segmentEndAngle,
            segmentNumber = segmentNumber,
            problem = problem,
            mainColor = mainColor,
            secondaryColor = secondaryColor
        )

        drawOuterSegment(
            centerX = centerX,
            centerY = centerY,
            mediumRadius = mediumRadius,
            outerRadius = outerRadius,
            gapPixels = gapPixels,
            segmentStartAngle = segmentStartAngle,
            segmentEndAngle = segmentEndAngle,
            segmentNumber = segmentNumber,
            problem = problem,
            mainColor = mainColor,
            secondaryColor = secondaryColor
        )
    }
}

/**
 * Draws the inner segment of the compass.
 *
 * @param centerX The x-coordinate of the center
 * @param centerY The y-coordinate of the center
 * @param innerRadius The radius of the inner segment
 * @param gapPixels The gap between segments in pixels
 * @param segmentStartAngle The starting angle of the segment
 * @param innerEndAngle The ending angle of the inner segment
 * @param segmentNumber The number of the segment
 * @param problem The avalanche problem data
 * @param mainColor The primary color for active segments
 * @param secondaryColor The color for inactive segments
 */
private fun DrawScope.drawInnerSegment(
    centerX: Float,
    centerY: Float,
    innerRadius: Float,
    gapPixels: Float,
    segmentStartAngle: Double,
    innerEndAngle: Double,
    segmentNumber: Int,
    problem: AvalancheProblem,
    mainColor: Color,
    secondaryColor: Color
) {
    val innerPath: Path = Path().apply {
        moveTo(
            centerX + (innerRadius * ProblemAspectElevationConstants.INNER_SEGMENT_MULTIPLIER) * cos(segmentStartAngle).toFloat(),
            centerY + (innerRadius * ProblemAspectElevationConstants.INNER_SEGMENT_MULTIPLIER) * sin(segmentStartAngle).toFloat()
        )
        lineTo(
            centerX + (innerRadius - gapPixels) * cos(segmentStartAngle).toFloat(),
            centerY + (innerRadius - gapPixels) * sin(segmentStartAngle).toFloat()
        )
        lineTo(
            centerX + (innerRadius - gapPixels) * cos(innerEndAngle).toFloat(),
            centerY + (innerRadius - gapPixels) * sin(innerEndAngle).toFloat()
        )
        lineTo(
            centerX + (innerRadius * ProblemAspectElevationConstants.INNER_SEGMENT_MULTIPLIER) * cos(innerEndAngle).toFloat(),
            centerY + (innerRadius * ProblemAspectElevationConstants.INNER_SEGMENT_MULTIPLIER) * sin(innerEndAngle).toFloat()
        )
        close()
    }
    drawPath(
        innerPath,
        if (problem.aspects.highAlpine.values.contains(segmentNumber)) mainColor else secondaryColor
    )
}

/**
 * Draws the medium segment of the compass.
 *
 * @param centerX The x-coordinate of the center
 * @param centerY The y-coordinate of the center
 * @param innerRadius The radius of the inner segment
 * @param mediumRadius The radius of the medium segment
 * @param gapPixels The gap between segments in pixels
 * @param segmentStartAngle The starting angle of the segment
 * @param segmentEndAngle The ending angle of the segment
 * @param segmentNumber The number of the segment
 * @param problem The avalanche problem data
 * @param mainColor The primary color for active segments
 * @param secondaryColor The color for inactive segments
 */
private fun DrawScope.drawMediumSegment(
    centerX: Float,
    centerY: Float,
    innerRadius: Float,
    mediumRadius: Float,
    gapPixels: Float,
    segmentStartAngle: Double,
    segmentEndAngle: Double,
    segmentNumber: Int,
    problem: AvalancheProblem,
    mainColor: Color,
    secondaryColor: Color
) {
    val mediumPath: Path = Path().apply {
        moveTo(
            centerX + (innerRadius + gapPixels) * cos(segmentStartAngle).toFloat(),
            centerY + (innerRadius + gapPixels) * sin(segmentStartAngle).toFloat()
        )
        lineTo(
            centerX + (mediumRadius - gapPixels) * cos(segmentStartAngle).toFloat(),
            centerY + (mediumRadius - gapPixels) * sin(segmentStartAngle).toFloat()
        )
        lineTo(
            centerX + (mediumRadius - gapPixels) * cos(segmentEndAngle).toFloat(),
            centerY + (mediumRadius - gapPixels) * sin(segmentEndAngle).toFloat()
        )
        lineTo(
            centerX + (innerRadius + gapPixels) * cos(segmentEndAngle).toFloat(),
            centerY + (innerRadius + gapPixels) * sin(segmentEndAngle).toFloat()
        )
        close()
    }
    drawPath(
        mediumPath,
        if (problem.aspects.alpine.values.contains(segmentNumber)) mainColor else secondaryColor
    )
}

/**
 * Draws the outer segment of the compass.
 *
 * @param centerX The x-coordinate of the center
 * @param centerY The y-coordinate of the center
 * @param mediumRadius The radius of the medium segment
 * @param outerRadius The radius of the outer segment
 * @param gapPixels The gap between segments in pixels
 * @param segmentStartAngle The starting angle of the segment
 * @param segmentEndAngle The ending angle of the segment
 * @param segmentNumber The number of the segment
 * @param problem The avalanche problem data
 * @param mainColor The primary color for active segments
 * @param secondaryColor The color for inactive segments
 */
private fun DrawScope.drawOuterSegment(
    centerX: Float,
    centerY: Float,
    mediumRadius: Float,
    outerRadius: Float,
    gapPixels: Float,
    segmentStartAngle: Double,
    segmentEndAngle: Double,
    segmentNumber: Int,
    problem: AvalancheProblem,
    mainColor: Color,
    secondaryColor: Color
) {
    val outerPath: Path = Path().apply {
        moveTo(
            centerX + (mediumRadius + gapPixels) * cos(segmentStartAngle).toFloat(),
            centerY + (mediumRadius + gapPixels) * sin(segmentStartAngle).toFloat()
        )
        lineTo(
            centerX + outerRadius * cos(segmentStartAngle).toFloat(),
            centerY + outerRadius * sin(segmentStartAngle).toFloat()
        )
        lineTo(
            centerX + outerRadius * cos(segmentEndAngle).toFloat(),
            centerY + outerRadius * sin(segmentEndAngle).toFloat()
        )
        lineTo(
            centerX + (mediumRadius + gapPixels) * cos(segmentEndAngle).toFloat(),
            centerY + (mediumRadius + gapPixels) * sin(segmentEndAngle).toFloat()
        )
        close()
    }
    drawPath(
        outerPath,
        if (problem.aspects.subAlpine.values.contains(segmentNumber)) mainColor else secondaryColor
    )
}

/**
 * Draws the compass labels.
 *
 * @param aspects The aspects data
 * @param textStyle The text style for labels
 * @param centerX The x-coordinate of the center
 * @param centerY The y-coordinate of the center
 * @param radius The radius for label placement
 * @param textMeasurer The TextMeasurer for rendering text
 * @param labelPrimaryColor The color for active labels
 * @param labelSecondaryColor The color for inactive labels
 */
private fun DrawScope.drawLabels(
    aspects: Aspects,
    textStyle: TextStyle,
    centerX: Float,
    centerY: Float,
    radius: Float,
    textMeasurer: TextMeasurer,
    labelPrimaryColor: Color,
    labelSecondaryColor: Color
) {
    CompassRules.LABELS.forEachIndexed { index: Int, label: String ->
        val angle: Double = toRadians(index * CompassRules.SEGMENT_ANGLE - 90)
        val textX: Float = centerX + radius * cos(angle).toFloat()
        val textY: Float = centerY + radius * sin(angle).toFloat() +
                if (label == "N") CompassRules.NORTH_OFFSET else 0f

        val layout = textMeasurer.measure(text = label)
        val adjustedX: Float = textX - layout.size.width / 2
        val adjustedY: Float = textY - layout.size.height / 2

        drawText(
            textMeasurer = textMeasurer,
            text = label,
            topLeft = Offset(adjustedX, adjustedY),
            style = textStyle.copy(
                color = if (aspects.alpine.keys.contains(label.lowercase())
                    || aspects.highAlpine.keys.contains(label.lowercase())
                    || aspects.subAlpine.keys.contains(label.lowercase())
                ) labelPrimaryColor else labelSecondaryColor,
            )
        )
    }
}