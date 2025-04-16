package ge.avalanche.zvavi.bulletin.presentation.screen.blocks

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ge.avalanche.zvavi.bulletin.presentation.screen.RiskBoard
import ge.avalanche.zvavi.designsystem.boards.ZvaviDashboard
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme

@Composable
fun OverallRisksBlock() {
    RiskBoard(
        modifier = Modifier
            .fillMaxWidth()
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        ZvaviDashboard(
            mainBlock = {
                Text(
                    "I am SuperDuper and natural avalanches are likely, human triggered avalanches are very likely",
                    style = ZvaviTheme.typography.compact300Default.copy(color = ZvaviTheme.colors.contentNeutralPrimary),
                    minLines = 2,
                )
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
            name = "LikelyHood",
            mainBlock = {
                Text(
                    "I am",
                    style = ZvaviTheme.typography.compact300Default.copy(color = ZvaviTheme.colors.contentNeutralPrimary)
                )
            },
            modifier = Modifier
                .weight(0.95f, fill = false)
                .fillMaxHeight()
        )
    }
}