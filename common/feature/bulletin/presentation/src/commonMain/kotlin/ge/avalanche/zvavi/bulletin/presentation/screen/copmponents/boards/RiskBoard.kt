package ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.boards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinViewState
import ge.avalanche.zvavi.bulletin.presentation.screen.utill.RiskLevelIcon
import ge.avalanche.zvavi.bulletin.presentation.screen.utill.overallRiskBackgroundColor
import ge.avalanche.zvavi.designsystem.animation.shimmer.shimmerEffect
import ge.avalanche.zvavi.designsystem.dimens.ZvaviRadius
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.strings.ZvaviStrings
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import ge.avalanche.zvavi.designsystem.tokens.layout.LocalLayoutConfig
import org.jetbrains.compose.resources.stringResource

@Composable
fun RiskBoard(
    viewState: BulletinViewState,
    modifier: Modifier = Modifier
) {
    val layoutConfig = LocalLayoutConfig.current
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clip(RoundedCornerShape(ZvaviRadius.radius550))
            .overallRiskBackgroundColor(viewState.riskLevelOverall)
            .padding(
                vertical = ZvaviSpacing.spacing350,
                horizontal = layoutConfig.contentCompensation
            ).shimmerEffect()
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxHeight().weight(3.5f, fill = false)
        ) {
            Text(
                text = stringResource(ZvaviStrings.overallRiskLevel),
                style = ZvaviTheme.typography.text250Default.copy(color = ZvaviTheme.colors.contentStaticDarkPrimary),
                modifier = Modifier.padding(vertical = ZvaviSpacing.spacing100)
            )
            Text(
                text = viewState.riskLevelOverall.name,
                style = ZvaviTheme.typography.display500Accent.copy(color = ZvaviTheme.colors.contentStaticDarkPrimary),
                modifier = Modifier.padding(vertical = ZvaviSpacing.spacing100).shimmerEffect()
            )
        }
        RiskLevelIcon(viewState.riskLevelOverall, modifier = Modifier.weight(1f, fill = false))
    }
}