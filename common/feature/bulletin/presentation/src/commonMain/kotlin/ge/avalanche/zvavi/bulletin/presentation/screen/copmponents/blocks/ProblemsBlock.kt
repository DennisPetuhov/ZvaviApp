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
import ge.avalanche.zvavi.designsystem.components.header.ZvaviHeader
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.strings.ZvaviStrings
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import ge.avalanche.zvavi.designsystem.tokens.layout.LayoutConfig
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProblemsBlock(
    viewState: BulletinViewState,
    layoutConfig: LayoutConfig,
    modifier: Modifier = Modifier,
    eventHandler: (BulletinEvent) -> Unit,
) {
    val bottomSheetState =
        rememberModalBottomSheetState(skipPartiallyExpanded = true, confirmValueChange = { true })
    val problems = viewState.avalancheProblems

    Column(
        verticalArrangement = Arrangement.spacedBy(ZvaviSpacing.spacing200),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = ZvaviSpacing.spacing350)
    ) {
        ZvaviHeader(
            text = ZvaviStrings.problems,
            modifier = modifier.padding(
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
            for (problem in problems) {
                ZvaviProblemBoard(
                    problem = problem,
                    layoutConfig = layoutConfig,
                    onClick = { eventHandler(BulletinEvent.OpenBottomSheet(problem = problem)) })

            }
        }
    }
    if (viewState.showBottomSheet) {
        AvalancheProblemsBottomSheet(
            problem = viewState.selectedProblem,
            sheetState = bottomSheetState,
            layoutConfig = layoutConfig,
            onDismiss = { eventHandler(BulletinEvent.CloseBottomSheet) },
            eventHandler = eventHandler
        )
    }
}