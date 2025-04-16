package ge.avalanche.zvavi.bulletin.presentation.screen.blocks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ge.avalanche.zvavi.bulletin.presentation.screen.boards.ZvaviProblemBoard
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import ge.avalanche.zvavi.designsystem.tokens.layout.LayoutConfig

@Composable
fun ProblemBlock(layoutConfig: LayoutConfig, modifier: Modifier = Modifier) {
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
            ZvaviProblemBoard(text = "Deep persistent slab", layoutConfig = layoutConfig)
            ZvaviProblemBoard(text = "Deep",layoutConfig = layoutConfig)
            ZvaviProblemBoard(text = "Deep slab",layoutConfig = layoutConfig)
            ZvaviProblemBoard(text = "Deep persistent slab",layoutConfig = layoutConfig)
        }

    }
}
