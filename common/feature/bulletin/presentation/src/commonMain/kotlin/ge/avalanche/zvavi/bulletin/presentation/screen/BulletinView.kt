package ge.avalanche.zvavi.bulletin.presentation.screen

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinEvent
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinViewState
import ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.blocks.AvalanchesSnowpackWeatherBlock
import ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.blocks.DataLocationBlock
import ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.blocks.OverallRisksBlock
import ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.blocks.ProblemsBlock
import ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.blocks.RiskByHeightBlock
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import ge.avalanche.zvavi.designsystem.tokens.layout.LayoutConfig
import ge.avalanche.zvavi.designsystem.tokens.layout.LocalLayoutConfig


@Composable
internal fun BulletinView(
    viewState: BulletinViewState,
    modifier: Modifier = Modifier,
    eventHandler: (BulletinEvent) -> Unit,
    ) {
    val layoutConfig = LocalLayoutConfig.current
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ZvaviTheme.colors.layerFloor0)
    ) {
        DataLocationBlock(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = ZvaviSpacing.spacing400, vertical = ZvaviSpacing.spacing100)
        )
        ContentBlocks(
            viewState = viewState,
            layoutConfig = layoutConfig,
            scrollState = scrollState,
            eventHandler = eventHandler
        )
    }
}

@Composable
private fun ContentBlocks(
    viewState: BulletinViewState,
    layoutConfig: LayoutConfig,
    scrollState: ScrollState,
    eventHandler: (BulletinEvent) -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(ZvaviSpacing.spacing100),
        modifier = Modifier.fillMaxSize()
            .padding(
                vertical = ZvaviSpacing.spacing350,
                horizontal = layoutConfig.marginHorizontal
            )
            .verticalScroll(scrollState)
    ) {
        OverallRisksBlock(viewState = viewState, eventHandler = eventHandler,layoutConfig= layoutConfig)
        RiskByHeightBlock(viewState = viewState, layoutConfig = layoutConfig)
        ProblemsBlock(
            viewState = viewState,
            eventHandler = eventHandler,
            layoutConfig = layoutConfig
        )
        AvalanchesSnowpackWeatherBlock(layoutConfig, viewState = viewState)
    }
}