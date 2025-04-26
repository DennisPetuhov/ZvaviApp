package ge.avalanche.zvavi.bulletin.presentation.screen.blocks

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
import ge.avalanche.zvavi.bulletin.presentation.screen.RiskBoard
import ge.avalanche.zvavi.designsystem.boards.ZvaviDashboard
import ge.avalanche.zvavi.designsystem.boards.ZvaviDashboardEvent
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme

@Composable
fun OverallRisksBlock(viewState: BulletinViewState, eventHandler: (BulletinEvent) -> Unit, modifier: Modifier = Modifier) {
    RiskBoard(
        modifier = modifier
            .fillMaxWidth()
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        ZvaviDashboard(
            name = "Travel Advice",
            mainBlock = {
                Text(
                    text = "",
                    style = ZvaviTheme.typography.compact300Default.copy(color = ZvaviTheme.colors.contentNeutralPrimary),
                    minLines = 2,
                    maxLines = 8,
                )
            },
            eventHandler = { event -> 
                when (event) {
                    ZvaviDashboardEvent.InfoClicked -> eventHandler(BulletinEvent.InfoClicked)
                }
            },
            modifier = Modifier
                .weight(0.95f, fill = false)
                .fillMaxHeight()
        )
        Spacer(
            modifier = Modifier
                .weight(0.02f)
        )
        ZvaviDashboard(
            name = "OverView",
            mainBlock = {
                Text(
                    text = viewState.overallInformation,
                    style = ZvaviTheme.typography.compact300Default.copy(color = ZvaviTheme.colors.contentNeutralPrimary),
                    minLines = 2,
                    maxLines = 8,
                )
            },
            eventHandler = { event ->
                when (event) {
                    ZvaviDashboardEvent.InfoClicked -> eventHandler(BulletinEvent.InfoClicked)
                }
            },
            modifier = Modifier
                .weight(0.95f, fill = false)
                .fillMaxHeight()
        )
    }
}