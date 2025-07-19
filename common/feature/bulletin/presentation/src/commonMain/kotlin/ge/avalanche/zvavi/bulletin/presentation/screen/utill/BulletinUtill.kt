package ge.avalanche.zvavi.bulletin.presentation.screen.utill

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.bulletin.api.models.AvalancheProblem
import ge.avalanche.zvavi.bulletin.api.models.AvalancheProblemType
import ge.avalanche.zvavi.bulletin.api.models.AvalancheRiskLevel
import ge.avalanche.zvavi.designsystem.animation.shimmer.shimmerEffect
import ge.avalanche.zvavi.designsystem.dimens.ZvaviRadius
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.icons.ZvaviIcons
import ge.avalanche.zvavi.designsystem.strings.ZvaviStrings
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import kotlinx.datetime.Month
import org.jetbrains.compose.resources.stringResource
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
            modifier = Modifier.shimmerEffect()
        )
    }
}


@Composable
fun AvalancheRiskLevel.toColor(): Color {
    return when (this) {
        AvalancheRiskLevel.NO_INFO -> Color(ZvaviTheme.colors.backgroundInfoHigh.value)
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
        AvalancheRiskLevel.NO_INFO -> ""
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
}

/**
 * Displays error content with retry button
 * @param errorMessage Message to be displayed
 * @param onRetry Callback for retry action
 */
@Composable
internal fun ErrorContent(
    errorMessage: String,
    onRetry: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = errorMessage,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onRetry) {
            Text("Retry")
        }
    }
}

@Composable
fun RiskLevelIcon(riskLevel: AvalancheRiskLevel, modifier: Modifier) {
    val icon = when (riskLevel) {
        AvalancheRiskLevel.EXTREME -> ZvaviIcons.RiskLevelExtreme
        AvalancheRiskLevel.HIGH -> ZvaviIcons.RiskLevelHigh
        AvalancheRiskLevel.CONSIDERABLE -> ZvaviIcons.RiskLevelConsiderable
        AvalancheRiskLevel.MODERATE -> ZvaviIcons.RiskLevelModerate
        AvalancheRiskLevel.LOW -> ZvaviIcons.RiskLevelLow
        AvalancheRiskLevel.NO_INFO -> ZvaviIcons.RiskLevelExtreme
    }
    Image(
        imageVector = icon,
        contentDescription = stringResource(ZvaviStrings.dangerLevel),
        modifier = modifier.aspectRatio(1f).shimmerEffect()
    )
}

@Composable
fun Modifier.overallRiskBackgroundColor(riskLevel: AvalancheRiskLevel) = this.then(
    Modifier.background(
        when (riskLevel) {
            AvalancheRiskLevel.EXTREME -> ZvaviTheme.colors.backgroundNeutralHigh
            AvalancheRiskLevel.HIGH -> ZvaviTheme.colors.backgroundNegativeHigh
            AvalancheRiskLevel.CONSIDERABLE -> ZvaviTheme.colors.backgroundWarningHigh
            AvalancheRiskLevel.MODERATE -> ZvaviTheme.colors.backgroundAttentionHigh
            AvalancheRiskLevel.LOW -> ZvaviTheme.colors.backgroundPositiveHigh
            AvalancheRiskLevel.NO_INFO -> ZvaviTheme.colors.backgroundNeutralHigh
        }
    )
)

internal val Month.shortName: String
    get() = when (this) {
        Month.JANUARY -> "Jan"
        Month.FEBRUARY -> "Feb"
        Month.MARCH -> "Mar"
        Month.APRIL -> "Apr"
        Month.MAY -> "May"
        Month.JUNE -> "Jun"
        Month.JULY -> "Jul"
        Month.AUGUST -> "Aug"
        Month.SEPTEMBER -> "Sep"
        Month.OCTOBER -> "Oct"
        Month.NOVEMBER -> "Nov"
        Month.DECEMBER -> "Dec"
        else -> "error"
    }

@Composable
internal fun ZvaviProblemIcon(problem: AvalancheProblem, modifier: Modifier) {
    val problemType = problem.type
    val (icon: ImageVector, contentDescription: String) = when (problemType) {
        is AvalancheProblemType.WindSlab -> ZvaviIcons.AvalancheProblemWindSlab to problemType.value
        is AvalancheProblemType.WetSlab -> ZvaviIcons.AvalancheProblemWetSlab to problemType.value
        is AvalancheProblemType.LooseDry -> ZvaviIcons.AvalancheProblemDryLoose to problemType.value
        is AvalancheProblemType.LooseWet -> ZvaviIcons.AvalancheProblemWetLoose to problemType.value
        is AvalancheProblemType.PersistentSlab -> ZvaviIcons.AvalancheProblemPersistentSlab to problemType.value
        is AvalancheProblemType.StormSlab -> ZvaviIcons.AvalancheProblemStormSlab to problemType.value
        is AvalancheProblemType.Cornice -> ZvaviIcons.AvalancheProblemCorniceFall to problemType.value
        is AvalancheProblemType.Glide -> ZvaviIcons.AvalancheProblemGlideAvalanche to problemType.value
        is AvalancheProblemType.DeepSlab -> ZvaviIcons.AvalancheProblemDeepPersistentSlab to problemType.value
        is AvalancheProblemType.Unknown -> ZvaviIcons.AvalancheProblemWetLoose to problemType.unknownValue
    }

    Image(
        imageVector = icon,
        contentDescription = contentDescription,
        modifier = modifier
            .aspectRatio(1f)
            .clip(RoundedCornerShape(ZvaviRadius.radius550))
            .border(
                border = BorderStroke(1.dp, ZvaviTheme.colors.borderNeutralSecondary),
                shape = RoundedCornerShape(ZvaviRadius.radius550)
            )
            .shimmerEffect()
    )
}