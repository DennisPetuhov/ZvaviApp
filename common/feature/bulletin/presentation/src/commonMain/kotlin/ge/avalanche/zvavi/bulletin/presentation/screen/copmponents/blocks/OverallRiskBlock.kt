package ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.blocks

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinEvent
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinViewState
import ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.boards.RiskBoard
import ge.avalanche.zvavi.bulletin.presentation.screen.utill.toTravelAdvice
import ge.avalanche.zvavi.designsystem.animation.shimmer.shimmerEffect
import ge.avalanche.zvavi.designsystem.boards.ZvaviDashboard
import ge.avalanche.zvavi.designsystem.boards.ZvaviDashboardEvent
import ge.avalanche.zvavi.designsystem.strings.ZvaviStrings
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import ge.avalanche.zvavi.designsystem.tokens.layout.LayoutConfig
import org.jetbrains.compose.resources.stringResource


@Composable
fun OverallRisksBlock(
    viewState: BulletinViewState,
    eventHandler: (BulletinEvent) -> Unit,
    layoutConfig: LayoutConfig,
    modifier: Modifier = Modifier
) {
    RiskBoard(
        viewState = viewState,
        modifier = modifier
            .fillMaxWidth()
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        ZvaviDashboard(
            name = stringResource(ZvaviStrings.travelAdvice),
            mainBlock = {
                Text(
                    text = viewState.riskLevelOverall.toTravelAdvice(),
                    style = ZvaviTheme.typography.compact300Default.copy(color = ZvaviTheme.colors.contentNeutralPrimary),
                    maxLines = 6,
                    modifier = Modifier
                        .fillMaxWidth()
                        .shimmerEffect()
                )
            },
            eventHandler = { event ->
                when (event) {
                    ZvaviDashboardEvent.InfoClicked -> eventHandler(BulletinEvent.InfoClicked)
                }
            },
            layoutConfig = layoutConfig,
            modifier = Modifier
                .weight(0.95f, fill = false)
                .fillMaxHeight()
        )
        Spacer(
            modifier = Modifier
                .weight(0.02f)
        )
        ZvaviDashboard(
            name = stringResource(ZvaviStrings.overview),
            mainBlock = {
                Text(
                    text = viewState.overallInformation,
                    style = ZvaviTheme.typography.compact300Default.copy(color = ZvaviTheme.colors.contentNeutralPrimary),
                    maxLines = 6,
                    modifier = Modifier
                        .fillMaxWidth()
                        .shimmerEffect()
                )
            },
            eventHandler = { event ->
                when (event) {
                    ZvaviDashboardEvent.InfoClicked -> eventHandler(BulletinEvent.InfoClicked)
                }
            },
            layoutConfig = layoutConfig,
            modifier = Modifier
                .weight(0.95f, fill = false)
                .fillMaxHeight()
        )
    }
}