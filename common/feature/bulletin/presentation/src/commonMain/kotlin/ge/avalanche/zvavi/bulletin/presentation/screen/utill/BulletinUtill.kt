package ge.avalanche.zvavi.bulletin.presentation.screen.utill

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import ge.avalanche.zvavi.bulletin.api.models.AvalancheRiskLevel
import ge.avalanche.zvavi.designsystem.dimens.ZvaviRadius
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import kotlin.math.PI
import kotlin.math.tan

@Composable
fun StyledPyramidText(text: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(ZvaviRadius.radius300))
            .background(color = ZvaviTheme.colors.backgroundStaticLightHigh)
            .padding(horizontal = ZvaviSpacing.spacing150, vertical = ZvaviSpacing.spacing150)
    ) {
        Text(
            text,
            style = ZvaviTheme.typography.compact300Numeric.copy(color = ZvaviTheme.colors.contentStaticDarkPrimary),
        )
    }
}


@Composable
fun AvalancheRiskLevel.toColor(): Color {
    return when (this) {
        AvalancheRiskLevel.GENERAL_INFORMATION -> Color(ZvaviTheme.colors.backgroundInfoHigh.value)
        AvalancheRiskLevel.LOW -> Color(ZvaviTheme.colors.backgroundAttentionHigh.value)
        AvalancheRiskLevel.MODERATE -> Color(ZvaviTheme.colors.backgroundPositiveHigh.value)
        AvalancheRiskLevel.CONSIDERABLE -> Color(ZvaviTheme.colors.backgroundWarningHigh.value)
        AvalancheRiskLevel.HIGH -> Color(ZvaviTheme.colors.backgroundNegativeHigh.value)
        AvalancheRiskLevel.EXTREME -> Color(ZvaviTheme.colors.backgroundInfoHigh.value)
    }
}

@Composable
fun AvalancheRiskLevel.toTravelAdvice(): String {
    return when (this) {
        AvalancheRiskLevel.GENERAL_INFORMATION -> ""
        AvalancheRiskLevel.LOW -> "Generally safe. Watch for unstable snow on isolate terrain features"
        AvalancheRiskLevel.MODERATE -> "Heightened avalanche conditions on specific terrain features. Evaluates snow and terrain carefully. Identify features of concern."
        AvalancheRiskLevel.CONSIDERABLE -> "Dangerous avalanche conditions.Careful snowpack evaluation, cautious route-finding, and conservative decision-making essential."
        AvalancheRiskLevel.HIGH -> "Very Dangerous avalanche conditions.  Avoid all avalanche terrain."
        AvalancheRiskLevel.EXTREME -> "Avoid all avalanche terrain."
    }
}

internal fun toRadians(degree: Double): Double = degree * (PI / 180)

internal fun getTan45(): Float = tan(toRadians(45.0)).toFloat()

object CompassRules {
    const val SEGMENT_ANGLE = 45.0
    const val NORTH_OFFSET = 5f
    val LABELS = listOf("N", "NE", "E", "SE", "S", "SW", "W", "NW")
    val PRIMARY_INDICES = setOf(1, 3, 5, 6)
}