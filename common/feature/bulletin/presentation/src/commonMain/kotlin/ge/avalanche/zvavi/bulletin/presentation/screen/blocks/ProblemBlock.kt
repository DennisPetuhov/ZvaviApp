package ge.avalanche.zvavi.bulletin.presentation.screen.blocks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import ge.avalanche.zvavi.bulletin.presentation.BulletinViewModel
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinEvent
import ge.avalanche.zvavi.bulletin.presentation.screen.boards.ZvaviProblemBoard
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import ge.avalanche.zvavi.designsystem.tokens.layout.LayoutConfig

@Composable
fun ProblemBlock(
    layoutConfig: LayoutConfig,
    modifier: Modifier = Modifier,
    eventHandler: (BulletinEvent) -> Unit
) {
    var showBottomSheet by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.spacedBy(ZvaviSpacing.spacing200),        // fix after network implementation
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = ZvaviSpacing.spacing350)
    ) {
        Text(
            text = "Problems",
            style = ZvaviTheme.typography.display400Accent.copy(
                color = ZvaviTheme.colors.contentNeutralPrimary
            ),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(
                    start = layoutConfig.contentCompensation,
                    end = layoutConfig.contentCompensation,
                    bottom = ZvaviSpacing.spacing100,
                    top = ZvaviSpacing.spacing300
                )
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(ZvaviSpacing.spacing100),
            modifier = Modifier.fillMaxWidth().wrapContentHeight()
        ) {
            ZvaviProblemBoard(
                text = "Persistent slab",
                layoutConfig = layoutConfig,
                onClick = { showBottomSheet = true }
            )
            ZvaviProblemBoard(
                text = "Wind slab",
                layoutConfig = layoutConfig,
                onClick = { showBottomSheet = true }
            )
            ZvaviProblemBoard(
                text = "Wet loose",
                layoutConfig = layoutConfig,
                onClick = { showBottomSheet = true }
            )
        }
    }

    if (showBottomSheet) {
        AvalancheProblemsBottomSheet(
            layoutConfig = layoutConfig,
            onDismiss = { showBottomSheet = false }
        )
    }
}
