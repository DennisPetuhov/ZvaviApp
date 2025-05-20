package ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.blocks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinEvent
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinViewState
import ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.boards.ZvaviProblemBoard
import ge.avalanche.zvavi.bulletin.presentation.screen.dialogs.AvalancheProblemsBottomSheet
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import ge.avalanche.zvavi.designsystem.tokens.layout.LayoutConfig

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProblemsBlock(
    viewState: BulletinViewState,
    layoutConfig: LayoutConfig,
    modifier: Modifier = Modifier,
    eventHandler: (BulletinEvent) -> Unit,
) {
    var bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )

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
                onClick = { eventHandler(BulletinEvent.OpenBottomSheet) }
            )
            ZvaviProblemBoard(
                text = "Wind slab",
                layoutConfig = layoutConfig,
                onClick = { eventHandler(BulletinEvent.OpenBottomSheet) }
            )
            ZvaviProblemBoard(
                text = "Wet loose",
                layoutConfig = layoutConfig,
                onClick = { eventHandler(BulletinEvent.OpenBottomSheet) }
            )
        }
    }
    if (viewState.showBottomSheet) {
        AvalancheProblemsBottomSheet(
            sheetState = bottomSheetState,
            layoutConfig = layoutConfig,
            onDismiss = {eventHandler(BulletinEvent.CloseBottomSheet)},
            eventHandler = eventHandler
        )
    }
}
